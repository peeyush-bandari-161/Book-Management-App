package com.BookStore.Spring_Boot_Project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MyBooks")
public class MyBookList {
    @Id
    private int id;
    private String name;
    private String author;
    private String price;
}
