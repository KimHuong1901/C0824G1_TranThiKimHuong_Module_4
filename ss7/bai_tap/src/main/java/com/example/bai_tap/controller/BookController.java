package com.example.bai_tap.controller;

import com.example.bai_tap.model.Book;
import com.example.bai_tap.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/home")
public class BookController {
    @Autowired
    private IBookService bookService;
    @GetMapping("")
    public ModelAndView listBook(Model model) {
        return new ModelAndView("manager/list", "books", bookService.getAll());
    }
    @GetMapping("/show-add")
    public String showAdd(Model model) {
        model.addAttribute("book", new Book());
        return "manager/add";
    }
    @PostMapping("/add")
    public String addBook(@Validated @ModelAttribute("book") Book book,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes,
                          Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getAllErrors());
            return "manager/add";
        }
        if(book.getId() == null || bookService.findById(book.getId()) == null) {
            bookService.addBook(book);
        }else{
            throw new DuplicateKeyException("Book already exists");
        }
        redirectAttributes.addFlashAttribute("message", "Book added successfully");
            return "redirect:/home";
    }
    @GetMapping("/{id}")
    public String detailBook(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "manager/detail";
    }
    @GetMapping("/{id}/show_confirm")
    public String showConfirmBorrow(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "borrow/confirm";
    }

    @GetMapping("/{id}/show-return")
    public String showConfirmReturn(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "borrow/confirm_return";
    }
@PostMapping("/{id}/borrow")
public String borrowBook(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
    int borrowCode = bookService.borrowBook(id);
    redirectAttributes.addFlashAttribute("message", "Book borrowed successfully! Borrow code: " + borrowCode);
    return "redirect:/home";
}

@PostMapping("/{id}/return")
public String returnBook(@PathVariable("id") int id, @RequestParam("code") int code, RedirectAttributes redirectAttributes) {
    boolean isReturned = bookService.returnBook(id, code);
    if (isReturned) {
        redirectAttributes.addFlashAttribute("message", "Book returned successfully!");
    } else {
        redirectAttributes.addFlashAttribute("error", "Failed to return book.");
    }

    return "redirect:/home";
}

}


