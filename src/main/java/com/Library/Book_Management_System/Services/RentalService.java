package com.Library.Book_Management_System.Services;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library.Book_Management_System.Exceptions.BookAlreadyRentedException;
import com.Library.Book_Management_System.Exceptions.BookNotFoundException;
import com.Library.Book_Management_System.Models.Book;
import com.Library.Book_Management_System.Repositories.BookRepository;

@Service
public class RentalService {
    @Autowired
    BookRepository bookRepository;

    public String rentABookById(int id) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (!optionalBook.isPresent())
            throw new BookNotFoundException("Book Does not Exist");

        Book book = optionalBook.get();

        if (book.isIsbn())
            throw new BookAlreadyRentedException("Book is Already rented");

        book.setIsbn(true);
        bookRepository.save(book);

        return "Book has been successfully rented by you";
    }

    public String returnBook(int id, Date returnDate) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (!optionalBook.isPresent())
            throw new BookNotFoundException("Book Does not Exist");

        Book book = optionalBook.get();

        book.setIsbn(false);
        bookRepository.save(book);

        LocalDate returnLocalDate = returnDate.toLocalDate();
        LocalDate publicationLocalDate = book.getPublicationYear().toLocalDate();

        long differenceDate = ChronoUnit.DAYS.between(publicationLocalDate, returnLocalDate);

        if(differenceDate>13) return "Book returned with overdue rental fee";

        return "Book returned successfully";
    }
}
