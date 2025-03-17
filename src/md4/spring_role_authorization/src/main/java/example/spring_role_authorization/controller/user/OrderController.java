package example.spring_role_authorization.controller.user;

import example.spring_role_authorization.model.Account;
import example.spring_role_authorization.model.CartItem;
import example.spring_role_authorization.model.DTO.OrderDTO;
import example.spring_role_authorization.model.Order;
import example.spring_role_authorization.model.OrderDetail;
import example.spring_role_authorization.repository.CartItemRepository;
import example.spring_role_authorization.repository.IAccountRepository;
import example.spring_role_authorization.repository.IOrderDetailRepository;
import example.spring_role_authorization.repository.IOrderRepository;
import example.spring_role_authorization.service.ICartItemService;
import example.spring_role_authorization.service.Impl.OrderDetailService;
import example.spring_role_authorization.service.Impl.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private ICartItemService cartItemService;
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private IOrderDetailRepository orderDetailRepository;
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("")
    public String order(Model model, Principal principal) {
        String username = principal.getName();
        Account account = accountRepository.findByUsername(username);

        List<CartItem> cartItemList = cartItemService.selectAllProductInCartOfAccount(account.getId());
        if(cartItemList.isEmpty()){
            return "redirect:/user";
        }
        OrderDTO orderDTO = new OrderDTO();

        long totalPrice =cartItemList.stream()
                .mapToLong(cart -> (long) (cart.getProduct().getPrice() * cart.getQuantity()))
                .sum();
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("orderDTO", orderDTO);
        model.addAttribute("cartItemList", cartItemList);
        return "user/order/order";
    }

    @PostMapping("")
    public String orders(Model model, Principal principal,
                         @Valid @ModelAttribute("orderDTO") OrderDTO orderDTO,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "user/order/order";
        }
        else{
            String userName = principal.getName();
            Account account = accountRepository.findByUsername(userName);
            List<CartItem> cartItem = cartItemService.selectAllProductInCartOfAccount(account.getId());
            long totalPrice = cartItem.stream()
                    .mapToLong(cart -> (long) (cart.getProduct().getPrice()*cart.getQuantity()))
                    .sum();
            LocalDateTime dateTime = LocalDateTime.now();
            orderDTO.setOrderDate(dateTime);
            orderDTO.setTotalMoney(totalPrice);
            orderDTO.setAccount(account);
            Order order = new Order();
            BeanUtils.copyProperties(orderDTO, order);

            orderRepository.save(order);
            cartItem.stream().forEach(cart -> {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setProduct(cart.getProduct());
                orderDetail.setOrder(order);
                orderDetail.setQuantity(cart.getQuantity());
                orderDetailRepository.save(orderDetail);

            });
            cartItemRepository.deleteAll(cartItem);
            return "redirect:/user";
        }
    }

    @GetMapping("detail")
    public String detail(Model model, Principal principal,
                         @RequestParam(name ="page",defaultValue = "0",required=false) int page){
        Pageable pageable = PageRequest.of(page, 30);

        String userName = principal.getName();
        Account account = accountRepository.findByUsername(userName);

        List<Order> orderListPage = orderService.findByCustomerId(account.getId());

        List<Long> orderListPageId = orderListPage.stream()
                .map(order -> order.getId())
                .collect(Collectors.toList());

        Page<OrderDetail> orderDetailPage = orderDetailRepository.findAll(pageable);

        List<OrderDetail> orderDetailLists = orderDetailPage.getContent().stream()
                .filter(orderdetail -> orderListPageId.stream().anyMatch(id -> id == orderdetail.getOrder().getId()))
                .collect(Collectors.toList());

        Page<OrderDetail> orderDetailList = new PageImpl<>(orderDetailLists,pageable,orderDetailLists.size());
        model.addAttribute("orderDetailList", orderDetailList);
        return "user/order/order-detail";
    }
}
