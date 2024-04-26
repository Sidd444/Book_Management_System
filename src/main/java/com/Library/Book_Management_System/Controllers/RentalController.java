package com.Library.Book_Management_System.Controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Library.Book_Management_System.Services.RentalService;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/rental")
public class RentalController {
    @Autowired
    RentalService rentalService;

    @PutMapping("/rent-a-book")
    public String rentById(@RequestParam int id) {
        try{
            return rentalService.rentABookById(id);
        }catch(Exception e){
            return e.getMessage();
        }
    }

    @PutMapping("/return-a-book")
    public String returnById(@RequestParam int id, @RequestParam Date returnDate) {
        try{
            return rentalService.returnBook(id,returnDate);
        }catch(Exception e){
            return e.getMessage();
        }
    }
}
