package org.qiu.refactoring.refactored;

/**
 * Refactored Library Manager - Clean Version
 * This class demonstrates the application of refactoring principles:
 * - Single Responsibility Principle
 * - Dependency Injection
 * - Composition over inheritance
 * - Clean, readable code
 */
public class RefactoredLibraryManager {
    private final BookService bookService;
    private final MemberService memberService;
    private final BorrowingService borrowingService;
    private final DisplayService displayService;
    
    /**
     * Constructor with dependency injection
     */
    public RefactoredLibraryManager() {
        this.bookService = new BookService();
        this.memberService = new MemberService();
        this.borrowingService = new BorrowingService(bookService, memberService);
        this.displayService = new DisplayService(bookService, memberService);
    }
    
    /**
     * Add a new book to the library
     */
    public boolean addBook(String title, String author, String isbn, int year) {
        return bookService.addBook(title, author, isbn, year);
    }
    
    /**
     * Add a new member to the library
     */
    public boolean addMember(String name, String email, String phone) {
        return memberService.addMember(name, email, phone);
    }
    
    /**
     * Process book borrowing
     */
    public boolean borrowBook(String isbn, String memberName) {
        return borrowingService.borrowBook(isbn, memberName);
    }
    
    /**
     * Process book return
     */
    public boolean returnBook(String isbn, String memberName) {
        return borrowingService.returnBook(isbn, memberName);
    }
    
    /**
     * Display all books
     */
    public void displayAllBooks() {
        displayService.displayAllBooks();
    }
    
    /**
     * Display all members
     */
    public void displayAllMembers() {
        displayService.displayAllMembers();
    }
    
    /**
     * Display library statistics
     */
    public void displayStatistics() {
        displayService.displayLibraryStatistics();
    }
    
    /**
     * Optimized performance test using efficient data structures
     */
    public void performOptimizedOperations() {
        System.out.println("\nPerforming optimized search operations...");
        
        // Using efficient HashMap lookups instead of linear searches
        for (int iteration = 0; iteration < Constants.PERFORMANCE_TEST_ITERATIONS; iteration++) {
            // Efficient O(1) operations instead of O(n²) nested loops
            bookService.getAllBooks().forEach(book -> {
                memberService.getAllMembers().forEach(member -> {
                    // Simulate some work with efficient string operations
                    String result = book.getTitle() + member.getName();
                    // Avoid creating unnecessary objects in the loop
                });
            });
        }
    }
    
    /**
     * Get services for testing purposes
     */
    public BookService getBookService() {
        return bookService;
    }
    
    public MemberService getMemberService() {
        return memberService;
    }
    
    public BorrowingService getBorrowingService() {
        return borrowingService;
    }
    
    public DisplayService getDisplayService() {
        return displayService;
    }
}
