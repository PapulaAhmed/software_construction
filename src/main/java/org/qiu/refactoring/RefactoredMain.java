package org.qiu.refactoring;

import org.qiu.refactoring.refactored.RefactoredLibraryManager;

/**
 * Main class for the refactored Library Management System
 * Demonstrates clean, maintainable code after refactoring
 * 
 * @author Sahand
 */
public class RefactoredMain {

    public static void main(String[] args) {
        System.out.println("=== Library Management System - Refactored Version ===");
        
        // Create refactored library manager
        RefactoredLibraryManager manager = new RefactoredLibraryManager();
        
        // Add some books
        manager.addBook("Java Programming", "John Doe", "123456789", 2020);
        manager.addBook("Python Basics", "Jane Smith", "987654321", 2021);
        manager.addBook("Data Structures", "Bob Johnson", "456789123", 2019);
        
        // Add some members
        manager.addMember("Alice", "alice@email.com", "123-456-7890");
        manager.addMember("Bob", "bob@email.com", "098-765-4321");
        
        // Perform operations
        manager.borrowBook("123456789", "Alice");
        manager.borrowBook("987654321", "Bob");
        
        // Display information
        manager.displayAllBooks();
        manager.displayAllMembers();
        manager.displayStatistics();
        
        // Performance test
        long startTime = System.currentTimeMillis();
        manager.performOptimizedOperations();
        long endTime = System.currentTimeMillis();
        System.out.println("Refactored code execution time: " + (endTime - startTime) + " ms");
        
        // Demonstrate additional functionality
        System.out.println("\n=== Additional Operations ===");
        
        // Try to borrow the same book again (should fail)
        manager.borrowBook("123456789", "Bob");
        
        // Return a book
        manager.returnBook("123456789", "Alice");
        
        // Now Bob can borrow it
        manager.borrowBook("123456789", "Bob");
        
        // Final statistics
        System.out.println("\n=== Final State ===");
        manager.displayStatistics();
    }
}
