# Library Management System - Constructor & Setter Injection

This project demonstrates how to use both **constructor** and **setter injection** using **Spring XML configuration**.

## Technologies Used:
- Java
- Spring Core (XML-based config)
- Maven

## How to Run:

1. Clone or download the repo.
2. Open terminal in project root.
3. Run the command:
   ```bash
   mvn clean compile exec:java

# Output
   Constructor Injected Book Title: Effective Java
   Setter Injected Book Repository Title: Spring in Action

# Directory Structure

src/
├── main/
│   ├── java/com/example/
│   │   ├── Book.java
│   │   ├── BookRepository.java
│   │   ├── BookService.java
│   │   └── LibraryManagementApplication.java
│   └── resources/applicationContext.xml
