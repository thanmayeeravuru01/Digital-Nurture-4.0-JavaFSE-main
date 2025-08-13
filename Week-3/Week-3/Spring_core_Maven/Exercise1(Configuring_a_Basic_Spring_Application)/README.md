# Configuring a Basic Spring Application

A basic Java Spring application for managing a library's backend operations using Spring Core (XML-based configuration).

## Project Structure

Exercise1(Configuring_a_Basic_Spring_Application)/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── library/
│ │ │ ├── MainApp.java
│ │ │ ├── service/
│ │ │ │ └── BookService.java
│ │ │ └── repository/
│ │ │ └── BookRepository.java
│ │ └── resources/
│ │ └── applicationContext.xml
├── pom.xml


## Technologies Used

- Java 8+
- Spring Core (XML Configuration)
- Maven
- Eclipse IDE

## How It Works

- `BookService` calls `BookRepository` to simulate storing a book.
- Spring manages dependencies via `applicationContext.xml`.

## How to Run

1. Open the project in **Eclipse**.
2. Ensure `spring-context` dependency is present in `pom.xml`.
3. Right-click `MainApp.java` → **Run As → Java Application**
4. Console should output:
   **Book 'The Great Gatsby' saved to the database.**

## Maven Dependencies

Add this to your `pom.xml`:

```xml
<dependencies>
 <dependency>
     <groupId>org.springframework</groupId>
     <artifactId>spring-context</artifactId>
     <version>5.3.32</version>
 </dependency>
</dependencies>


