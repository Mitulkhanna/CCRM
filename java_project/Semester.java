package edu.ccrm.domain;

/**
 * Semester enum demonstrating enum with fields and methods
 */
public enum Semester {
    SPRING("Spring", 1),
    SUMMER("Summer", 2), 
    FALL("Fall", 3),
    WINTER("Winter", 4);
    
    private final String displayName;
    private final int order;
    
    // Enum constructor
    Semester(String displayName, int order) {
        this.displayName = displayName;
        this.order = order;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public int getOrder() {
        return order;
    }
    
    // Check if semester comes before another
    public boolean comesBefore(Semester other) {
        return this.order < other.order;
    }
    
    @Override
    public String toString() {
        return displayName;
    }
}