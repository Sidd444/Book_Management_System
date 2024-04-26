package com.Library.Book_Management_System.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library.Book_Management_System.Exceptions.NoBooksWrittenByAuthorException;
import com.Library.Book_Management_System.Models.Book;
import com.Library.Book_Management_System.Repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public List<Book> getBooksByAuthor(String author){
        List<Book> authorsBooks= bookRepository.findByAuthor(author);

        if(authorsBooks.isEmpty()) throw new NoBooksWrittenByAuthorException("No Books Available By This Author");

        return authorsBooks;
    }

    public List<Book> getBooksAvavilableForRent(){
        List<Book> allBooks=bookRepository.findAll();
        List<Book> availableBooks=new ArrayList<>();
        for(Book book:allBooks){
            if(!book.isIsbn()) availableBooks.add(book);
        }
        return availableBooks;
    }

    public List<Book> BooksCurrentlyRented(){
        List<Book> allBooks=bookRepository.findAll();
        List<Book> booksRented=new ArrayList<>();
        for(Book book:allBooks){
            if(book.isIsbn()) booksRented.add(book);
        }
        return booksRented;
    }
}
