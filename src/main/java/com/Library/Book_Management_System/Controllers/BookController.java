package com.Library.Book_Management_System.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Library.Book_Management_System.Models.Book;
import com.Library.Book_Management_System.Services.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add-book")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("get-all-books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("get-all-books-by-author-name")
    public ResponseEntity bookByAuthorName(@RequestParam String author){
        try{
        return new ResponseEntity<>(bookService.getBooksByAuthor(author),HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/books-available-for-rent")
    public List<Book> availableForRent(){
        return bookService.getBooksAvavilableForRent();
    }

    @GetMapping("/books-rented")
    public List<Book> rented(){
        return bookService.BooksCurrentlyRented();
    }
}
