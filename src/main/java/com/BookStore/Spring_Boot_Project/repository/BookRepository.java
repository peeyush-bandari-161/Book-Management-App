package com.BookStore.Spring_Boot_Project.repository;

import com.BookStore.Spring_Boot_Project.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
