package org.qiu.refactoring.refactored;

import java.util.Collection;

/**
 * Service class responsible for display operations
 * Extracted from the original God Class
 */
public class DisplayService {
    private final BookService bookService;
    private final MemberService memberService;
    
    public DisplayService(BookService bookService, MemberService memberService) {
        this.bookService = bookService;
        this.memberService = memberService;
    }
    
    /**
     * Display all books in a formatted manner
     */
    public void displayAllBooks() {
        System.out.println("\n=== All Books ===");
        Collection<Book> books = bookService.getAllBooks();
        
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        
        int bookIndex = 1;
        for (Book currentBook : books) {
            displayBookInfo(bookIndex, currentBook);
            bookIndex++;
        }
    }
    
    /**
     * Display individual book information
     */
    private void displayBookInfo(int index, Book book) {
        System.out.printf("%d. %s by %s (ISBN: %s, Year: %d, Available: %s)%n",
                index, 
                book.getTitle(), 
                book.getAuthor(),
                book.getIsbn(), 
                book.getYear(),
                book.isAvailable() ? "Yes" : "No");
    }
    
    /**
     * Display all members in a formatted manner
     */
    public void displayAllMembers() {
        System.out.println("\n=== All Members ===");
        Collection<Member> members = memberService.getAllMembers();
        
        if (members.isEmpty()) {
            System.out.println("No members registered in the library.");
            return;
        }
        
        int memberIndex = 1;
        for (Member currentMember : members) {
            displayMemberInfo(memberIndex, currentMember);
            memberIndex++;
        }
    }
    
    /**
     * Display individual member information
     */
    private void displayMemberInfo(int index, Member member) {
        System.out.printf("%d. %s (%s, Phone: %s, Borrowed: %d/%d)%n",
                index,
                member.getName(),
                member.getEmail(),
                member.getPhone(),
                member.getBorrowedBooksCount(),
                Constants.MAX_BORROWING_LIMIT);
    }
    
    /**
     * Display library statistics
     */
    public void displayLibraryStatistics() {
        System.out.println("\n=== Library Statistics ===");
        System.out.printf("Total Books: %d%n", bookService.getTotalBooks());
        System.out.printf("Total Members: %d%n", memberService.getTotalMembers());
        
        long availableBooks = bookService.getAllBooks().stream()
                .mapToLong(book -> book.isAvailable() ? 1 : 0)
                .sum();
        
        System.out.printf("Available Books: %d%n", availableBooks);
        System.out.printf("Borrowed Books: %d%n", bookService.getTotalBooks() - availableBooks);
    }
}
