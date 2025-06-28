package org.qiu.refactoring.refactored;

import java.util.*;

/**
 * Service class responsible for member management operations
 * Extracted from the original God Class
 */
public class MemberService {
    private final Map<String, Member> members; // Using Map for O(1) lookup by email
    private final Map<String, Member> membersByName; // Additional index for name lookup
    
    public MemberService() {
        this.members = new HashMap<>();
        this.membersByName = new HashMap<>();
    }
    
    /**
     * Add a new member to the library
     */
    public boolean addMember(String name, String email, String phone) {
        if (!ValidationUtils.isValidMemberData(name, email, phone)) {
            return false;
        }
        
        String normalizedEmail = email.trim().toLowerCase();
        
        if (isDuplicateEmail(normalizedEmail)) {
            System.out.printf(Constants.ERROR_DUPLICATE_EMAIL + "%n", email);
            return false;
        }
        
        Member member = new Member(name, email, phone);
        members.put(normalizedEmail, member);
        membersByName.put(name.trim(), member);
        System.out.printf(Constants.SUCCESS_MEMBER_ADDED + "%n", name);
        return true;
    }
    
    /**
     * Find a member by email
     */
    public Optional<Member> findMemberByEmail(String email) {
        return Optional.ofNullable(members.get(email.toLowerCase()));
    }
    
    /**
     * Find a member by name
     */
    public Optional<Member> findMemberByName(String name) {
        return Optional.ofNullable(membersByName.get(name.trim()));
    }
    
    /**
     * Get all members
     */
    public Collection<Member> getAllMembers() {
        return Collections.unmodifiableCollection(members.values());
    }
    
    /**
     * Check if email already exists
     */
    private boolean isDuplicateEmail(String email) {
        return members.containsKey(email);
    }
    
    /**
     * Get total number of members
     */
    public int getTotalMembers() {
        return members.size();
    }
    
    /**
     * Check if member can borrow more books
     */
    public boolean canMemberBorrowMore(String memberName) {
        return findMemberByName(memberName)
                .map(Member::canBorrowMoreBooks)
                .orElse(false);
    }
}
