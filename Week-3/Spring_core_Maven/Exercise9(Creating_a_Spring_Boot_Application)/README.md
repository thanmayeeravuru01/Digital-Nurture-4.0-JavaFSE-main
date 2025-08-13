# Exercise 9 : Creating_a_Spring_Boot_Application

This is a Spring Boot application developed as part of Exercise 9 to manage books in a library system. It uses Spring Boot, Spring Data JPA, and H2 in-memory database to demonstrate backend CRUD operations.

## Technologies Used

- Java 17 / Java 22
- Spring Boot 3.5.3
- Spring Data JPA
- H2 Database
- Maven
- Visual Studio Code 

## Project Structure

src  
└── main  
  ├── java  
  │  └── com.example.library  
  │    ├── LibraryApplication.java (Main Spring Boot app)  
  │    ├── model  
  │    │  └── Book.java (Book entity)  
  │    ├── repository  
  │    │  └── BookRepository.java (JPA repository)  
  │    └── controller  
  │      └── BookController.java (REST API controller)  
  └── resources  
    └── application.properties (DB and server config)  

## How to Run

1. Open terminal and navigate to the project folder:

   ```bash
   cd Exercise9(Creating_a_Spring_Boot_Application)

2. Run the application:

   ./mvnw spring-boot:run

3. Access in browser:

   H2 Console: http://localhost:8080/h2-console

   REST API: http://localhost:8080/books