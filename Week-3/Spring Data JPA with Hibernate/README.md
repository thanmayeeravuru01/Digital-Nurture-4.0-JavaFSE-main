# Difference between JPA, Hibernate, and Spring Data JPA

## Overview

This project demonstrates the difference between:

- *Java Persistence API (JPA)* – A specification for data persistence in Java.
- *Hibernate* – An Object-Relational Mapping (ORM) tool and JPA implementation.
- *Spring Data JPA* – A higher abstraction built on JPA that simplifies CRUD operations.

---

## Tools and Technologies Used

- Java SDK 8+
- Eclipse IDE
- Maven
- MySQL Database
- Hibernate (5.6.15)
- Spring Boot (for Spring Data JPA)

---

## Project Structure

The project is split into two main parts:

1. *Hibernate Implementation*
2. *Spring Data JPA Implementation*

---

## Part 1: Hibernate Implementation

### Step 1: Create a Maven project in Eclipse

### Step 2: Add Dependencies in pom.xml

- Hibernate Core
- MySQL JDBC Driver
- JPA API

### Step 3: Create the following files

- Employee.java (Entity class)
- HibernateUtil.java (SessionFactory configuration)
- MainApp.java (Main class with employee insert code)

### Step 4: Configure hibernate.cfg.xml

- Database connection
- Dialect
- Mapping file

### Step 5: Run MainApp.java

### Step 6: Verify MySQL

- Check if employee table is created and row inserted.

### Output Files:

- hibernate_output_console.png
- hibernate_output_mysql.png

---

## Part 2: Spring Data JPA Implementation

### Step 1: Create a Spring Boot project using Spring Initializr

- Add dependencies: Spring Web, Spring Data JPA, MySQL Driver

### Step 2: Configure application.properties

- Database URL
- Username/password
- Dialect and JPA properties

### Step 3: Create the following files

- Employee.java (Entity class)
- EmployeeRepository.java (Repository interface)
- SpringDataDemoApplication.java (Main class with insert logic)

### Step 4: Run the application

### Step 5: Verify MySQL

- Check if employee table is created and row inserted.

### Output Files:

- springdata_output_console.png
- springdata_output_mysql.png

---

## Summary of Code Comparison

| Feature            | Hibernate                          | Spring Data JPA                        |
|--------------------|------------------------------------|----------------------------------------|
| Session Management | Manual                             | Auto-managed by Spring Boot            |
| Transaction        | Manually handled                   | Annotated with @Transactional        |
| DAO Implementation | Requires full method implementation| Auto-generated via JpaRepository     |
| Boilerplate Code   | High                               | Very minimal                           |

---

