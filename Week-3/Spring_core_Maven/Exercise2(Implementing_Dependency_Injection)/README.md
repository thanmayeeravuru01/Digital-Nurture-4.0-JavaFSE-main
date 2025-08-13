# Exercise 2: Implementing Dependency Injection

This project demonstrates how to implement **Dependency Injection** using **Spring Framework with XML-based configuration**.

---

## Project Folder

Exercise2(Implementing_Dependency_Injection)/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/example/library/
│ │ │ ├── Book.java
│ │ │ ├── BookRepository.java
│ │ │ ├── BookService.java
│ │ │ └── LibraryManagementApplication.java
│ │ └── resources/
│ │ └── applicationContext.xml
├── pom.xml
├── README.md


---

## Technologies Used

- Java 8+
- Spring Core (spring-context 5.3.30)
- Maven
- VS Code

---

## How to Run the Project

Open the terminal in the project root and execute:

```bash
mvn clean compile
mvn exec:java

----

## OUTPUT

Book Title: Spring in Action
