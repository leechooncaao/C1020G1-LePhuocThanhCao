package com.app.controller;

import com.app.model.Book;
import com.app.model.BorrowManager;
import com.app.service.BookBorrowService;
import com.app.service.BookService;
import com.app.service.exception.BookIsNotExisted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookBorrowService bookBorrowService;

    @GetMapping("/")
    public String getHomePage(){
        return "home";
    }

    @GetMapping("/books")
    public String listBooks(Model model){
        List<Book> bookList = bookService.findAll();
        model.addAttribute("books", bookList);

        return "list";
    }

    @GetMapping("/book/{id}/detail")
    public String getDetailPage(@PathVariable Integer id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book", book);

        return "detail";
    }

    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable Integer id, Model model) throws BookIsNotExisted {
        Book book = bookService.findById(id);
        bookService.borrowBook(book);
        String borrowCode = bookBorrowService.getBorrowCode();
        bookBorrowService.save(new BorrowManager(borrowCode, book));
        model.addAttribute("borrowCode", borrowCode);

        return "success-borrow";
    }

    @GetMapping("/return")
    public String getReturnPage(){
//        model.addAttribute("borrowManager", new BorrowManager());
        return "return-book";
    }

    @PostMapping("/book/return")
    public String returnBook(@RequestParam("borrowCode") String borrowCode,RedirectAttributes redirectAttributes){
        BorrowManager borrowManager = bookBorrowService.borrowCodeIsExist(borrowCode);

        if(borrowManager == null){
            redirectAttributes.addFlashAttribute("message", "Borrow Code does not exist !");
            return "redirect:/return";
        }

        bookService.returnBook(borrowManager.getBook().getId());
        return "success-return";
    }

    @ExceptionHandler(BookIsNotExisted.class)
    public ModelAndView showErrorPage(){
        return new ModelAndView("error-out-of-book");
    }
}
