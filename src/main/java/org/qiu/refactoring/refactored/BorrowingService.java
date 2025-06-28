package org.qiu.refactoring.refactored;

import java.util.*;

/**
 * Service class responsible for borrowing operations
 * Extracted from the original God Class
 */
public class BorrowingService {
    private final Set<String> borrowedBooks; // Using Set for O(1) lookup
    private final BookService bookService;
    private final MemberService memberService;
    
    public BorrowingService(BookService bookService, MemberService memberService) {
        this.borrowedBooks = new HashSet<>();
        this.bookService = bookService;
        this.memberService = memberService;
    }
    
    /**
     * Process book borrowing operation
     */
    public boolean borrowBook(String isbn, String memberName) {
        // Validate inputs
        if (!ValidationUtils.isValidString(isbn, "ISBN") || 
            !ValidationUtils.isValidString(memberName, "Member name")) {
            return false;
        }
        
        // Find book
        Optional<Book> bookOpt = bookService.findBookByIsbn(isbn);
        if (bookOpt.isEmpty()) {
            System.out.println(Constants.ERROR_BOOK_NOT_FOUND);
            return false;
        }
        
        // Find member
        Optional<Member> memberOpt = memberService.findMemberByName(memberName);
        if (memberOpt.isEmpty()) {
            System.out.println(Constants.ERROR_MEMBER_NOT_FOUND);
            return false;
        }
        
        Book book = bookOpt.get();
        Member member = memberOpt.get();
        
        // Check if book is already borrowed
        if (isBookBorrowed(isbn)) {
            System.out.println(Constants.ERROR_BOOK_ALREADY_BORROWED);
            return false;
        }
        
        // Check borrowing limit
        if (!member.canBorrowMoreBooks()) {
            System.out.println(Constants.ERROR_MAX_BORROWING_LIMIT);
            return false;
        }
        
        // Process borrowing
        return processBorrowing(book, member);
    }
    
    /**
     * Process the actual borrowing operation
     */
    private boolean processBorrowing(Book book, Member member) {
        try {
            book.borrowBook();
            member.borrowBook();
            borrowedBooks.add(book.getIsbn());
            
            System.out.printf(Constants.SUCCESS_BOOK_BORROWED + "%n", 
                            book.getTitle(), member.getName());
            return true;
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Process book return operation
     */
    public boolean returnBook(String isbn, String memberName) {
        if (!isBookBorrowed(isbn)) {
            System.out.println("Error: Book is not currently borrowed");
            return false;
        }
        
        Optional<Book> bookOpt = bookService.findBookByIsbn(isbn);
        Optional<Member> memberOpt = memberService.findMemberByName(memberName);
        
        if (bookOpt.isEmpty() || memberOpt.isEmpty()) {
            System.out.println("Error: Book or member not found");
            return false;
        }
        
        Book book = bookOpt.get();
        Member member = memberOpt.get();
        
        try {
            book.returnBook();
            member.returnBook();
            borrowedBooks.remove(isbn);
            
            System.out.printf("Book returned successfully: %s by %s%n", 
                            book.getTitle(), member.getName());
            return true;
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Check if a book is currently borrowed
     */
    public boolean isBookBorrowed(String isbn) {
        return borrowedBooks.contains(isbn);
    }
    
    /**
     * Get all borrowed book ISBNs
     */
    public Set<String> getBorrowedBooks() {
        return Collections.unmodifiableSet(borrowedBooks);
    }
    
    /**
     * Get total number of borrowed books
     */
    public int getTotalBorrowedBooks() {
        return borrowedBooks.size();
    }
}
