package com.Library.Book_Management_System.Models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Rental {
    @Id
    int id;
    int bookId;
    String renterName;
    Date rentalDate;
    Date returnDate;
}
