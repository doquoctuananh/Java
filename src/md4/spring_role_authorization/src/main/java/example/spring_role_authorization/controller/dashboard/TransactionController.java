package example.spring_role_authorization.controller.dashboard;

import example.spring_role_authorization.model.Account;
import example.spring_role_authorization.model.Order;
import example.spring_role_authorization.model.OrderDetail;
import example.spring_role_authorization.repository.IAccountRepository;
import example.spring_role_authorization.repository.IOrderDetailRepository;
import example.spring_role_authorization.repository.IOrderRepository;
import example.spring_role_authorization.service.Impl.OrderDetailService;
import example.spring_role_authorization.service.Impl.OrderService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("dashboard/transaction")
public class TransactionController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private IAccountRepository accountRepository;

    @GetMapping("")
    public String transaction(Model model,
                              @RequestParam(name ="page",defaultValue="0",required = false)int page) {
        Pageable pageable = PageRequest.of(page,5);
        Page<OrderDetail> orderDetailList = orderDetailService.findOrderDetailByOrderStatus("pending",pageable);

        model.addAttribute("orderDetailList", orderDetailList);
        return "dashboard/transaction/transaction";
    }

    @GetMapping("confirm")
    public String deliver(@RequestParam(name = "orderId") Long orderId,
                          Model model,
//                          @RequestParam(name ="page", defaultValue = "0",required = false) int page,
                          @RequestParam(name ="status") String status) {
        Order orders = orderService.finfById(orderId);
//        Pageable pageable = PageRequest.of(page,10);
//        Page<Order> orderList = orderService.findAll(pageable);
        LocalDateTime dateTimeDeliver = LocalDateTime.now();
        orders.setDeliveryDate(dateTimeDeliver);
        orders.setOrderStatus(status);
        orderService.save(orders);
        return "redirect:/dashboard/transaction";
    }

    @GetMapping("deliver")
    public String deliver(Model model,
                          @RequestParam(name ="page",defaultValue = "0",required = false) int page) {
        Pageable pageable = PageRequest.of(page,3);
        Page<OrderDetail> orderDetailList = orderDetailService.findOrderDetailByOrderStatus("deliver", pageable);
        model.addAttribute("orderDetailList", orderDetailList);
        return "dashboard/transaction/transaction-deliver";
    }

    @GetMapping("cancel")
    public String cancel(Model model,
                          @RequestParam(name ="page",defaultValue = "0",required = false) int page) {
        Pageable pageable = PageRequest.of(page,2);
        Page<OrderDetail> orderDetailList = orderDetailService.findOrderDetailByOrderStatus("cancel", pageable);
        model.addAttribute("orderDetailList", orderDetailList);
        return "dashboard/transaction/transaction-cancel";
    }
}
