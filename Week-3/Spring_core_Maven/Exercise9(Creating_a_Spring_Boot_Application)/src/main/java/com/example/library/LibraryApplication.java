package com.example.library;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(BookRepository bookRepository) {
		return (args) -> {
			bookRepository.save(new Book("Clean Code", "Robert C. Martin", "9780132350884"));
			bookRepository.save(new Book("Effective Java", "Joshua Bloch", "9780134685991"));
			bookRepository.save(new Book("Spring in Action", "Craig Walls", "9781617294945"));
		};
	}
}
