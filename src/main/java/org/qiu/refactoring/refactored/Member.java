package org.qiu.refactoring.refactored;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Member class - Refactored Version
 * Improved with better encapsulation and validation
 */
public class Member {
    private final String name;
    private final String email;
    private final String phone;
    private int borrowedBooksCount;
    private final LocalDate membershipDate;
    
    /**
     * Constructor with validation
     */
    public Member(String name, String email, String phone) {
        if (!ValidationUtils.isValidMemberData(name, email, phone)) {
            throw new IllegalArgumentException("Invalid member data provided");
        }
        
        this.name = name.trim();
        this.email = email.trim().toLowerCase();
        this.phone = phone.trim();
        this.borrowedBooksCount = 0;
        this.membershipDate = LocalDate.now();
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public int getBorrowedBooksCount() {
        return borrowedBooksCount;
    }
    
    public LocalDate getMembershipDate() {
        return membershipDate;
    }
    
    /**
     * Check if member can borrow more books
     */
    public boolean canBorrowMoreBooks() {
        return borrowedBooksCount < Constants.MAX_BORROWING_LIMIT;
    }
    
    /**
     * Business method to borrow a book
     */
    public void borrowBook() {
        if (!canBorrowMoreBooks()) {
            throw new IllegalStateException("Member has reached maximum borrowing limit");
        }
        this.borrowedBooksCount++;
    }
    
    /**
     * Business method to return a book
     */
    public void returnBook() {
        if (this.borrowedBooksCount <= 0) {
            throw new IllegalStateException("Member has no books to return");
        }
        this.borrowedBooksCount--;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Member member = (Member) obj;
        return Objects.equals(email, member.email);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
    
    @Override
    public String toString() {
        return String.format("Member{name='%s', email='%s', phone='%s', borrowedBooks=%d, memberSince=%s}",
                name, email, phone, borrowedBooksCount, membershipDate);
    }
}
