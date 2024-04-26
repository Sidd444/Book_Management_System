package com.Library.Book_Management_System.Exceptions;

public class NoBooksWrittenByAuthorException extends RuntimeException {
    public NoBooksWrittenByAuthorException(String message){
        super(message);
    }
}
