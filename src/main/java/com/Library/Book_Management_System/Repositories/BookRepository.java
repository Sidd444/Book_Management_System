package com.Library.Book_Management_System.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Library.Book_Management_System.Models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{
    public List<Book> findByAuthor(String author);
}
