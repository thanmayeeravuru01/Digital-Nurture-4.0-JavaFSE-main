# ORM-Learn Project

## Objective

A Spring Boot + Spring Data JPA application to fetch and display country data from a MySQL database.

---

## Technologies

- Java 22  
- Spring Boot 2.7  
- Spring Data JPA  
- Hibernate  
- MySQL 9.3  
- Maven  
- Eclipse IDE  

---

## Setup Steps

### 1. MySQL Setup

- Start MySQL.
- Create a schema: `CREATE DATABASE ormlearn;`
- Create `country` table with columns: `code (PK)`, `name`.
- Insert sample rows like:  
  `('IN', 'India'), ('US', 'United States of America')`

### 2. Project Setup in Eclipse

- Create a Maven project `orm-learn`.
- Add dependencies in `pom.xml`:
  - spring-context, spring-orm, spring-boot-starter-data-jpa, hibernate-core, mysql-connector-java, commons-logging

### 3. Package Structure

- `com.ormlearn.model` – Country entity  
- `com.ormlearn.repository` – Repository interface  
- `com.ormlearn.service` – Service layer  
- `com.ormlearn` – Main application  

### 4. Configuration

- Create `application.properties` in `src/main/resources` with:
  - DB URL
  - Username & password
  - JPA properties (ddl-auto, show-sql, etc.)

### 5. Execution

- Fetch Spring Bean for `CountryService` in `OrmLearnApplication.java`
- Call method to retrieve and print all countries
- Run the app → Right-click > Run As > Java Application

---

## Output

Check the **console**:
Start
Code: IN, Name: India
Code: US, Name: United States of America
End

---

## Directory Structure

orm-learn/
├── model/
├── repository/
├── service/
├── OrmLearnApplication.java
├── application.properties
├── pom.xml


