package org.qiu.refactoring.refactored;

/**
 * Constants class to replace magic numbers
 */
public final class Constants {
    // Private constructor to prevent instantiation
    private Constants() {
        throw new UnsupportedOperationException("Constants class cannot be instantiated");
    }
    
    // Book-related constants
    public static final int MIN_PUBLICATION_YEAR = 1900;
    public static final int MAX_PUBLICATION_YEAR = 2024;
    
    // Member-related constants
    public static final int MAX_BORROWING_LIMIT = 5;
    
    // Performance test constants
    public static final int PERFORMANCE_TEST_ITERATIONS = 1000;
    
    // Validation messages
    public static final String ERROR_EMPTY_TITLE = "Error: Title cannot be empty";
    public static final String ERROR_EMPTY_AUTHOR = "Error: Author cannot be empty";
    public static final String ERROR_EMPTY_ISBN = "Error: ISBN cannot be empty";
    public static final String ERROR_INVALID_YEAR = "Error: Invalid year";
    public static final String ERROR_EMPTY_NAME = "Error: Name cannot be empty";
    public static final String ERROR_EMPTY_EMAIL = "Error: Email cannot be empty";
    public static final String ERROR_EMPTY_PHONE = "Error: Phone cannot be empty";
    public static final String ERROR_DUPLICATE_ISBN = "Error: Book with ISBN %s already exists";
    public static final String ERROR_DUPLICATE_EMAIL = "Error: Member with email %s already exists";
    public static final String ERROR_BOOK_NOT_FOUND = "Error: Book not found";
    public static final String ERROR_MEMBER_NOT_FOUND = "Error: Member not found";
    public static final String ERROR_BOOK_ALREADY_BORROWED = "Error: Book is already borrowed";
    public static final String ERROR_MAX_BORROWING_LIMIT = "Error: Member has reached maximum borrowing limit";
    
    // Success messages
    public static final String SUCCESS_BOOK_ADDED = "Book added successfully: %s";
    public static final String SUCCESS_MEMBER_ADDED = "Member added successfully: %s";
    public static final String SUCCESS_BOOK_BORROWED = "Book borrowed successfully: %s by %s";
}
