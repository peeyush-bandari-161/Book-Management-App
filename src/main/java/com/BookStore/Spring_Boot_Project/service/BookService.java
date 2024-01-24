package com.BookStore.Spring_Boot_Project.service;

import com.BookStore.Spring_Boot_Project.entity.Book;
import com.BookStore.Spring_Boot_Project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public void saveBook(Book book){
        bookRepository.save(book);
    }
    public List<Book> getAllBooks(){
       return bookRepository.findAll();
    }
    public Book getBookById(int id){
        return bookRepository.findById(id).get();
    }
    public void deleteById(int id){
        bookRepository.deleteById(id);
    }

}
