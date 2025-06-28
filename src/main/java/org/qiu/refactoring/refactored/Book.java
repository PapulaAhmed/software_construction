package org.qiu.refactoring.refactored;

import java.util.Objects;

/**
 * Book class - Refactored Version
 * Improved with better encapsulation and validation
 */
public class Book {
    private final String title;
    private final String author;
    private final String isbn;
    private final int year;
    private boolean isAvailable;
    
    /**
     * Constructor with validation
     */
    public Book(String title, String author, String isbn, int year) {
        if (!ValidationUtils.isValidBookData(title, author, isbn, year)) {
            throw new IllegalArgumentException("Invalid book data provided");
        }
        
        this.title = title.trim();
        this.author = author.trim();
        this.isbn = isbn.trim();
        this.year = year;
        this.isAvailable = true;
    }
    
    // Getters only - immutable fields
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public int getYear() {
        return year;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    // Only availability can be changed
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
    
    /**
     * Business method to borrow the book
     */
    public void borrowBook() {
        if (!isAvailable) {
            throw new IllegalStateException("Book is not available for borrowing");
        }
        this.isAvailable = false;
    }
    
    /**
     * Business method to return the book
     */
    public void returnBook() {
        if (isAvailable) {
            throw new IllegalStateException("Book is already available");
        }
        this.isAvailable = true;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Objects.equals(isbn, book.isbn);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
    
    @Override
    public String toString() {
        return String.format("Book{title='%s', author='%s', isbn='%s', year=%d, available=%s}",
                title, author, isbn, year, isAvailable);
    }
}
