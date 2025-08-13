# Library Management - Spring IoC XML Configuration

This project demonstrates how to configure the Spring IoC container using XML for a simple library management application.

## Features

- Defines beans using `applicationContext.xml`
- Injects dependencies using Spring's XML configuration
- Demonstrates Spring Context loading and usage

## Project Structure

src/
├── main/
│ ├── java/com/example/
│ │ ├── Book.java
│ │ ├── BookRepository.java
│ │ ├── BookService.java
│ │ └── MainApp.java
│ └── resources/
│ └── applicationContext.xml


## 🚀 How to Run

1. Compile and install dependencies:
   ```bash
   mvn clean install

2. Run the application:
   ```bash
   mvn exec:java -Dexec.mainClass="com.example.MainApp"