package com.BookStore.Spring_Boot_Project.controller;

import com.BookStore.Spring_Boot_Project.entity.Book;
import com.BookStore.Spring_Boot_Project.entity.MyBookList;
import com.BookStore.Spring_Boot_Project.service.BookService;
import com.BookStore.Spring_Boot_Project.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private MyBookListService myBookListService;

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home(){

        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister(){

        return "bookRegister";
    }
    @GetMapping("/available_books")
    public ModelAndView getAllBooks(){
        List<Book> list=bookService.getAllBooks();
        return new ModelAndView("bookList","book",list);
    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book){
        bookService.saveBook(book);
        return "redirect:/available_books";
    }
    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBookList> list=myBookListService.getAllMyBooks();
        model.addAttribute("book",list);
        return "myBooks";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable int id){
        Book b=bookService.getBookById(id);
        MyBookList list=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookListService.saveMyBook(list);

        return "redirect:/my_books";
    }
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model){
        Book b=bookService.getBookById(id);
        model.addAttribute("book",b);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteById(id);
        return "redirect:/available_books";
    }
}
