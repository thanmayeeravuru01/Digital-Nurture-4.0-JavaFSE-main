package exercise6;

import java.util.Arrays;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

public class LibraryManagementSystem {

    // Linear Search by Title
    public static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    // Binary Search by Title (array must be sorted)
    public static Book binarySearch(Book[] books, String title) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) return books[mid];
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Java Basics", "John Doe"),
            new Book(2, "Python Guide", "Jane Smith"),
            new Book(3, "Data Structures", "Alice Brown")
        };

        // Linear Search
        System.out.println("Linear Search Result: " + linearSearch(books, "Python Guide"));

        // Sort books for Binary Search
        Arrays.sort(books, (a, b) -> a.title.compareToIgnoreCase(b.title));

        // Binary Search
        System.out.println("Binary Search Result: " + binarySearch(books, "Python Guide"));
    }
}
