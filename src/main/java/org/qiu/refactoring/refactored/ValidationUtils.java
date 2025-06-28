package org.qiu.refactoring.refactored;

/**
 * Utility class for common validation operations
 * Eliminates duplicate validation code
 */
public final class ValidationUtils {
    
    // Private constructor to prevent instantiation
    private ValidationUtils() {
        throw new UnsupportedOperationException("ValidationUtils class cannot be instantiated");
    }
    
    /**
     * Validates that a string is not null or empty
     * @param value the string to validate
     * @param fieldName the name of the field for error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            System.out.println("Error: " + fieldName + " cannot be empty");
            return false;
        }
        return true;
    }
    
    /**
     * Validates publication year
     * @param year the year to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidYear(int year) {
        if (year < Constants.MIN_PUBLICATION_YEAR || year > Constants.MAX_PUBLICATION_YEAR) {
            System.out.println(Constants.ERROR_INVALID_YEAR);
            return false;
        }
        return true;
    }
    
    /**
     * Validates book data
     * @param title book title
     * @param author book author
     * @param isbn book ISBN
     * @param year publication year
     * @return true if all fields are valid, false otherwise
     */
    public static boolean isValidBookData(String title, String author, String isbn, int year) {
        return isValidString(title, "Title") &&
               isValidString(author, "Author") &&
               isValidString(isbn, "ISBN") &&
               isValidYear(year);
    }
    
    /**
     * Validates member data
     * @param name member name
     * @param email member email
     * @param phone member phone
     * @return true if all fields are valid, false otherwise
     */
    public static boolean isValidMemberData(String name, String email, String phone) {
        return isValidString(name, "Name") &&
               isValidString(email, "Email") &&
               isValidString(phone, "Phone");
    }
}
