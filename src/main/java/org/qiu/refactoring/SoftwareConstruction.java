/*
 * Library Management System - Original Version with Code Smells
 * This code intentionally contains multiple code smells for educational purposes
 */

package org.qiu.refactoring;

import java.util.ArrayList;
import java.util.List;

/**
 * Library Management System - Original Version (WITH CODE SMELLS)
 * @author Sahand Nasr Mohammed
 * @author Papula Fouad Ahmed
 * @author Elaf Chatin Khalid
 * @author Meer Hoshyar Ahmed
 */

public class SoftwareConstruction {

    public static void main(String[] args) {
        System.out.println("=== Library Management System - Original Version ===");

        // Create library managerJira Auto-Update.
        LibraryManager manager = new LibraryManager();

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

        // Performance test
        System.out.println("\n=== PERFORMANCE TEST ===");
        long startTime = System.currentTimeMillis();
        manager.performanceTest();
        long endTime = System.currentTimeMillis();
        System.out.println("=== EXECUTION TIME RESULT ===");
        System.out.println("Original code execution time: " + (endTime - startTime) + " ms");
        System.out.println("==============================");
    }
}

// CODE SMELL 1: God Class - This class does too many things
// CODE SMELL 2: Long Method - Methods are too long and complex
// CODE SMELL 3: Duplicate Code - Repeated validation logic
// CODE SMELL 4: Magic Numbers - Hard-coded values without explanation

class LibraryManager {
    final List<Book> books;
    final List<Member> members;
    final List<String> borrowedBooks;

    public LibraryManager() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        borrowedBooks = new ArrayList<>();
    }

    // CODE SMELL: Long Method - This method does too many things
    public void addBook(String title, String author, String isbn, int year) {
        // CODE SMELL: Duplicate Code - Same validation pattern repeated
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Error: Title cannot be empty");
            return;
        }
        if (author == null || author.trim().isEmpty()) {
            System.out.println("Error: Author cannot be empty");
            return;
        }
        if (isbn == null || isbn.trim().isEmpty()) {
            System.out.println("Error: ISBN cannot be empty");
            return;
        }
        // CODE SMELL: Magic Number - What does 1900 represent?
        if (year < 1900 || year > 2024) {
            System.out.println("Error: Invalid year");
            return;
        }

        // Check for duplicate ISBN
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                System.out.println("Error: Book with ISBN " + isbn + " already exists");
                return;
            }
        }

        Book book = new Book(title, author, isbn, year);
        books.add(book);
        System.out.println("Book added successfully: " + title);
    }

    // CODE SMELL: Long Method and Duplicate Code
    public void addMember(String name, String email, String phone) {
        // CODE SMELL: Duplicate validation pattern
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Name cannot be empty");
            return;
        }
        if (email == null || email.trim().isEmpty()) {
            System.out.println("Error: Email cannot be empty");
            return;
        }
        if (phone == null || phone.trim().isEmpty()) {
            System.out.println("Error: Phone cannot be empty");
            return;
        }

        // Check for duplicate email
        for (Member member : members) {
            if (member.getEmail().equals(email)) {
                System.out.println("Error: Member with email " + email + " already exists");
                return;
            }
        }

        Member member = new Member(name, email, phone);
        members.add(member);
        System.out.println("Member added successfully: " + name);
    }

    // CODE SMELL: Long Method with complex logic
    public void borrowBook(String isbn, String memberName) {
        Book bookToBorrow = null;
        Member borrower = null;

        // Find book
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                bookToBorrow = book;
                break;
            }
        }

        if (bookToBorrow == null) {
            System.out.println("Error: Book not found");
            return;
        }

        // Find member
        for (Member member : members) {
            if (member.getName().equals(memberName)) {
                borrower = member;
                break;
            }
        }

        if (borrower == null) {
            System.out.println("Error: Member not found");
            return;
        }

        // Check if book is already borrowed
        for (String borrowedIsbn : borrowedBooks) {
            if (borrowedIsbn.equals(isbn)) {
                System.out.println("Error: Book is already borrowed");
                return;
            }
        }

        // CODE SMELL: Magic Number - What does 5 represent?
        if (borrower.getBorrowedBooksCount() >= 5) {
            System.out.println("Error: Member has reached maximum borrowing limit");
            return;
        }

        borrowedBooks.add(isbn);
        borrower.incrementBorrowedBooks();
        System.out.println("Book borrowed successfully: " + bookToBorrow.getTitle() + " by " + memberName);
    }

    public void displayAllBooks() {
        System.out.println("\n=== All Books ===");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println((i + 1) + ". " + book.getTitle() + " by " + book.getAuthor() +
                             " (ISBN: " + book.getIsbn() + ", Year: " + book.getYear() + ")");
        }
    }

    public void displayAllMembers() {
        System.out.println("\n=== All Members ===");
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            System.out.println((i + 1) + ". " + member.getName() + " (" + member.getEmail() +
                             ", Phone: " + member.getPhone() + ", Borrowed: " + member.getBorrowedBooksCount() + ")");
        }
    }

    // CODE SMELL: Inefficient algorithm for performance testing
    public void performanceTest() {
        System.out.println("\nPerforming inefficient search operations...");
        // CODE SMELL: Magic Number and inefficient nested loops
        for (int i = 0; i < 1000; i++) {
            for (Book book : books) {
                for (Member member : members) {
                    // Simulate some work
                    @SuppressWarnings("unused")
                    String result = book.getTitle() + member.getName();
                }
            }
        }
    }
}
