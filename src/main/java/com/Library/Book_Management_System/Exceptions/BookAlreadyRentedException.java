package com.Library.Book_Management_System.Exceptions;

public class BookAlreadyRentedException extends RuntimeException {
    public BookAlreadyRentedException(String message){
        super(message);
    }
}
