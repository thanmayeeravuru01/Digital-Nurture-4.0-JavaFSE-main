package com.example;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBook() {
        String title = bookRepository.findBookTitle();
        System.out.println("Book Title: " + title);
    }
}
