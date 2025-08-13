package com.example;

public class BookService {
    private BookRepository bookRepository;

    // Constructor injection
    public BookService(BookRepository bookRepository) {
        System.out.println("Constructor injection invoked");
        this.bookRepository = bookRepository;
    }

    // Setter injection
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("Setter injection invoked");
        this.bookRepository = bookRepository;
    }

    public void displayBook() {
        Book book = bookRepository.getBook();
        System.out.println("Book Title: " + book.getTitle());
    }
}
