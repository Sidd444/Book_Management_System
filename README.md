# Book Management System

This project is a Book Management System implemented using Spring Boot. It allows users to manage books by performing CRUD operations through RESTful APIs.

# Sample API Testing Using Swagger (Video Link):

## [Click Here](https://drive.google.com/file/d/1kHMBQzVjLS4lOhE_DYXbD0Ccxq6-nUQ6/view?usp=drive_link)

## Installation

### Prerequisites
- Java Development Kit (JDK) installed (version 8 or later)
- Maven installed
- MySQL installed and running

### Steps
1. **Clone the repository:**
   
   git clone <repository_url>
  
2. **Navigate to the project directory:**
   
   cd Book_Management_System
   
3. **Build the project using Maven:**
   
   mvn clean package
   
4. **Run the application:**
   
   java -jar target/Book_Management_System-0.0.1-SNAPSHOT.jar
   

## Usage

### Using Postman
You can use Postman to interact with the RESTful APIs provided by the application. Import the provided Postman collection to get started.

### Using Swagger
Swagger is integrated into the application, allowing you to explore and interact with the APIs through a user-friendly interface. Once the application is running, navigate to the following URL in your web browser:

http://localhost:8080/swagger-ui.html

You will see the Swagger UI, where you can browse the available endpoints and make requests.

## Dependencies used
- Spring Boot Starter Web
- MySQL Driver
- Spring Data JPA
- Lombok
- Swagger


# Usage

## APIs Available

### Book Controller
Add Book (POST): /api/books/add-book

Adds a new book to the system.

### Get All Books (GET): /api/books/get-all-books

Retrieves all books stored in the system.

### Get All Books by Author Name (GET): /api/books/get-all-books-by-author-name?authorName={authorName}

Retrieves all books written by a specific author.

### Books Rented (GET): /api/books/books-rented

Retrieves all books that are currently rented.

### Books Available for Rent (GET): /api/books/books-available-for-rent

Retrieves all books that are available for rent.

## Rental Controller

### Rent a Book (PUT): /api/rentals/rent-a-book/{id}

Rents a book by its ID. If the book is already rented, it returns "Book is already rented" exception.

### Return a Book (PUT): /api/rentals/return-a-book/{id}

Returns a rented book by its ID.

## Exception Handling

Book Already Rented Exception: Thrown when trying to rent a book that is already rented.

No Books Available by Author Exception: Thrown when trying to get all books by author name, but no books are found for that author.

Book Not Found Exception: Thrown when trying to rent or return a book by its ID, but the book does not exist.
