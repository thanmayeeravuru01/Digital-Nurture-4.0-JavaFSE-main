package com.example.library;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBook() {
        Book book = bookRepository.getBook();
        System.out.println("Book Title: " + book.getTitle());
    }
}
