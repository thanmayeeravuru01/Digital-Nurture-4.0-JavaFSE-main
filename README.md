# Microservices for Account and Loan - Spring Boot Project

This hands-on project demonstrates the creation of two simple Spring Boot RESTful microservices for a bank — one for handling accounts and another for handling loans.

Each microservice is a separate Maven project with its own `pom.xml`, running independently without any backend or database. The goal is to understand the basic structure and communication setup for microservices.

## Project Setup Instructions

### Step 1: Create Project Folders

1. Create a folder with your employee ID in the `D:` drive.
2. Inside that folder, create another folder named `microservices`.

Example:
D:\<employee_id>\microservices

### Step 2: Generate Account Microservice

1. Open https://start.spring.io/ in a browser.
2. Fill in the form:
   - Group: com.cognizant
   - Artifact: account
3. Select the following dependencies:
   - Spring Boot DevTools
   - Spring Web
4. Click "Generate" to download the zip file.

### Step 3: Setup Account Microservice

1. Extract the `account` folder from the zip file and place it inside the `microservices` folder created earlier.
2. Open Command Prompt in the `account` folder.
3. Run the following Maven command to build the project:

   mvn clean package

4. Open Eclipse.
5. Import the `account` project:
   - File > Import > Maven > Existing Maven Projects
   - Browse to: D:\<employee_id>\microservices\account

### Step 4: Implement Account Controller

Create a controller class inside `com.cognizant.account.controller` package.

File: AccountController.java

```java
package com.cognizant.account.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @GetMapping("/{number}")
    public Account getAccount(@PathVariable String number) {
        return new Account(number, "savings", 234343);
    }

    record Account(String number, String type, double balance) {}
}
```

### Step 5: Run and Test Account Microservice

1. Run AccountApplication.java from Eclipse.
2. Open a browser and access the following URL:

   http://localhost:8080/accounts/00987987973432

Expected Response:
```json
{
  "number": "00987987973432",
  "type": "savings",
  "balance": 234343
}
```

### Step 6: Generate Loan Microservice

Repeat steps from the Account Microservice setup.

1. Go to https://start.spring.io/
2. Fill in:
   - Group: com.cognizant
   - Artifact: loan
3. Add:
   - Spring Boot DevTools
   - Spring Web
4. Click "Generate" and download the zip.

### Step 7: Setup Loan Microservice

1. Extract the `loan` folder and place it inside the `microservices` folder.
2. Open Command Prompt in the `loan` folder.
3. Run:

   mvn clean package

4. Import the `loan` project into Eclipse.

### Step 8: Change Default Port for Loan Service

Edit `src/main/resources/application.properties` in the `loan` project:

   server.port=8081

### Step 9: Implement Loan Controller

Create a controller class inside `com.cognizant.loan.controller` package.

File: LoanController.java

```java
package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping("/{number}")
    public Loan getLoan(@PathVariable String number) {
        return new Loan(number, "car", 400000, 3258, 18);
    }

    record Loan(String number, String type, double loan, int emi, int tenure) {}
}
```

### Step 10: Run and Test Loan Microservice

1. Start the Account Service if not already running (port 8080).
2. Run LoanApplication.java from Eclipse (port 8081).
3. Open a browser and access:

   http://localhost:8081/loans/H00987987972342

Expected Response:
```json
{
  "number": "H00987987972342",
  "type": "car",
  "loan": 400000,
  "emi": 3258,
  "tenure": 18
}
```

## Final Status

Both microservices are now independently running and accessible on different ports:

- Account Service: http://localhost:8080/accounts/{number}
- Loan Service: http://localhost:8081/loans/{number}
