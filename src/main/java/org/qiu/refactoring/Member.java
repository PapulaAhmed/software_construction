package org.qiu.refactoring;

import java.time.LocalDate;

/**
 * Member class - Original Version (WITH CODE SMELLS)
 */
public class Member {
    private String name;
    private String email;
    private String phone;
    private int borrowedBooksCount;
    private LocalDate membershipDate;
    
    public Member(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
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
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setBorrowedBooksCount(int borrowedBooksCount) {
        this.borrowedBooksCount = borrowedBooksCount;
    }
    
    public void setMembershipDate(LocalDate membershipDate) {
        this.membershipDate = membershipDate;
    }
    
    // Business methods
    public void incrementBorrowedBooks() {
        this.borrowedBooksCount++;
    }
    
    public void decrementBorrowedBooks() {
        if (this.borrowedBooksCount > 0) {
            this.borrowedBooksCount--;
        }
    }
    
    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", borrowedBooksCount=" + borrowedBooksCount +
                ", membershipDate=" + membershipDate +
                '}';
    }
}
