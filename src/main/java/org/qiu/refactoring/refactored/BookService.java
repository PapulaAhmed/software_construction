package org.qiu.refactoring.refactored;

import java.util.*;

/**
 * Service class responsible for book management operations
 * Extracted from the original God Class
 */
public class BookService {
    private final Map<String, Book> books; // Using Map for O(1) lookup by ISBN
    
    public BookService() {
        this.books = new HashMap<>();
    }
    
    /**
     * Add a new book to the library
     */
    public boolean addBook(String title, String author, String isbn, int year) {
        if (!ValidationUtils.isValidBookData(title, author, isbn, year)) {
            return false;
        }
        
        if (isDuplicateIsbn(isbn)) {
            System.out.printf(Constants.ERROR_DUPLICATE_ISBN + "%n", isbn);
            return false;
        }
        
        Book book = new Book(title, author, isbn, year);
        books.put(isbn, book);
        System.out.printf(Constants.SUCCESS_BOOK_ADDED + "%n", title);
        return true;
    }
    
    /**
     * Find a book by ISBN
     */
    public Optional<Book> findBookByIsbn(String isbn) {
        return Optional.ofNullable(books.get(isbn));
    }
    
    /**
     * Get all books
     */
    public Collection<Book> getAllBooks() {
        return Collections.unmodifiableCollection(books.values());
    }
    
    /**
     * Check if ISBN already exists
     */
    private boolean isDuplicateIsbn(String isbn) {
        return books.containsKey(isbn);
    }
    
    /**
     * Get total number of books
     */
    public int getTotalBooks() {
        return books.size();
    }
    
    /**
     * Check if book is available for borrowing
     */
    public boolean isBookAvailable(String isbn) {
        return findBookByIsbn(isbn)
                .map(Book::isAvailable)
                .orElse(false);
    }
}
