package com.BookStore.Spring_Boot_Project.service;

import com.BookStore.Spring_Boot_Project.entity.MyBookList;
import com.BookStore.Spring_Boot_Project.repository.MyBookListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {
    @Autowired
    private MyBookListRepository myBookListRepository;
    public void saveMyBook(MyBookList myBookList){
        myBookListRepository.save(myBookList);
    }
    public List<MyBookList> getAllMyBooks(){
        return myBookListRepository.findAll();
    }
    public void deleteById(int id){
        myBookListRepository.deleteById(id);
    }
}
