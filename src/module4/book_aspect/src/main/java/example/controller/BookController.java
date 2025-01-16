package example.controller;

import example.model.Book;
import example.model.BookValidate;
import example.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("")
    public String index(Model model, @RequestParam(value = "page",defaultValue  ="0",required = false) int page) {
        Sort sort = Sort.by(Sort.Direction.ASC,"name");
        Pageable pageable = PageRequest.of(page,1,sort);

        model.addAttribute("books",bookService.findAll(pageable));
        return "index";
    }

    @GetMapping("/book/create")
    public String create(Model model) {
        model.addAttribute("bookValidate", new BookValidate());
        return "create";
    }

    @PostMapping("/book/save")
    public String save(@Valid @ModelAttribute BookValidate bookValidate, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult",bindingResult);
            return "create";
        }
        Book book = new Book();
        BeanUtils.copyProperties(bookValidate, book);
        bookService.save(book);
        return "redirect:/";
    }

    @GetMapping("/book/view/{id}")
    public String view(@PathVariable long id, Model model) {
        Book book = bookService.findById(id);
//        BookValidate bookValidate = new BookValidate();
//        BeanUtils.copyProperties(book, bookValidate);
        model.addAttribute("book", book);
        return "view";
    }

    @GetMapping("/book/brrown/{id}")
    public String brrown(@PathVariable long id, Model model) {
        Book book = bookService.findById(id);
        if(book.getQuantity() <= 0){

            return "error";
        }
        book.setQuantity(book.getQuantity() - 1);
        bookService.save(book);
        return "redirect:/";
    }

    @GetMapping("/book/pay/{id}")
    public String pay(@PathVariable long id, Model model) {
        Book book = bookService.findById(id);
        book.setQuantity(book.getQuantity() + 1);
        bookService.save(book);
        return "redirect:/";
    }


}
