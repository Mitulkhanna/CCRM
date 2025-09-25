
import java.util.Objects;

/**
 * Immutable value class demonstrating final fields and defensive copying
 */
public final class Name {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    
    // Constructor with defensive copying
    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName != null ? firstName.trim() : "";
        this.middleName = middleName != null ? middleName.trim() : "";
        this.lastName = lastName != null ? lastName.trim() : "";
    }
    
    // Constructor without middle name
    public Name(String firstName, String lastName) {
        this(firstName, "", lastName);
    }
    
    // Getters return defensive copies (though String is immutable)
    public String getFirstName() {
        return firstName;
    }
    
    public String getMiddleName() {
        return middleName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getFullName() {
        StringBuilder sb = new StringBuilder();
        sb.append(firstName);
        if (!middleName.isEmpty()) {
            sb.append(" ").append(middleName);
        }
        sb.append(" ").append(lastName);
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Name name = (Name) obj;
        return Objects.equals(firstName, name.firstName) &&
               Objects.equals(middleName, name.middleName) &&
               Objects.equals(lastName, name.lastName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName);
    }
    
    @Override
    public String toString() {
        return getFullName();
    }
}