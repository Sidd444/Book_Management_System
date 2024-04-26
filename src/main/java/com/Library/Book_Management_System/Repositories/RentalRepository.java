package com.Library.Book_Management_System.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Library.Book_Management_System.Models.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental,Integer>{
    
}
