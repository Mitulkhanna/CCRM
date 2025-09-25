package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Course class demonstrating Builder design pattern
 * Uses nested static Builder class
 */
public class Course {
    private final String code;
    private final String title;
    private final int credits;
    private String instructorId;
    private Semester semester;
    private String department;
    private int maxEnrollment;
    private int currentEnrollment;
    private boolean isActive;
    private LocalDate createdDate;
    private LocalDate lastModified;
    
    // Private constructor - forces use of Builder
    private Course(Builder builder) {
        this.code = builder.code;
        this.title = builder.title;
        this.credits = builder.credits;
        this.instructorId = builder.instructorId;
        this.semester = builder.semester;
        this.department = builder.department;
        this.maxEnrollment = builder.maxEnrollment;
        this.currentEnrollment = 0;
        this.isActive = true;
        this.createdDate = LocalDate.now();
        this.lastModified = LocalDate.now();
    }
    
    // Static nested Builder class
    public static class Builder {
        // Required parameters
        private final String code;
        private final String title;
        private final int credits;
        
        // Optional parameters - initialized to default values
        private String instructorId = "";
        private Semester semester = Semester.FALL;
        private String department = "";
        private int maxEnrollment = 50;
        
        // Builder constructor with required parameters
        public Builder(String code, String title, int credits) {
            this.code = Objects.requireNonNull(code, "Course code cannot be null");
            this.title = Objects.requireNonNull(title, "Course title cannot be null");
            if (credits <= 0) {
                throw new IllegalArgumentException("Credits must be positive");
            }
            this.credits = credits;
        }
        
        // Fluent setter methods
        public Builder instructorId(String instructorId) {
            this.instructorId = instructorId != null ? instructorId : "";
            return this;
        }
        
        public Builder semester(Semester semester) {
            this.semester = semester != null ? semester : Semester.FALL;
            return this;
        }
        
        public Builder department(String department) {
            this.department = department != null ? department : "";
            return this;
        }
        
        public Builder maxEnrollment(int maxEnrollment) {
            if (maxEnrollment <= 0) {
                throw new IllegalArgumentException("Max enrollment must be positive");
            }
            this.maxEnrollment = maxEnrollment;
            return this;
        }
        
        // Build method to create Course instance
        public Course build() {
            return new Course(this);
        }
    }
    
    // Getters
    public String getCode() {
        return code;
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getCredits() {
        return credits;
    }
    
    public String getInstructorId() {
        return instructorId;
    }
    
    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId != null ? instructorId : "";
        updateLastModified();
    }
    
    public Semester getSemester() {
        return semester;
    }
    
    public void setSemester(Semester semester) {
        this.semester = semester != null ? semester : Semester.FALL;
        updateLastModified();
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department != null ? department : "";
        updateLastModified();
    }
    
    public int getMaxEnrollment() {
        return maxEnrollment;
    }
    
    public void setMaxEnrollment(int maxEnrollment) {
        if (maxEnrollment <= 0) {
            throw new IllegalArgumentException("Max enrollment must be positive");
        }
        this.maxEnrollment = maxEnrollment;
        updateLastModified();
    }
    
    public int getCurrentEnrollment() {
        return currentEnrollment;
    }
    
    public void setCurrentEnrollment(int currentEnrollment) {
        if (currentEnrollment < 0) {
            throw new IllegalArgumentException("Current enrollment cannot be negative");
        }
        this.currentEnrollment = currentEnrollment;
        updateLastModified();
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    public void setActive(boolean active) {
        this.isActive = active;
        updateLastModified();
    }
    
    public LocalDate getCreatedDate() {
        return createdDate;
    }
    
    public LocalDate getLastModified() {
        return lastModified;
    }
    
    private void updateLastModified() {
        this.lastModified = LocalDate.now();
    }
    
    // Business methods
    public boolean canEnrollStudent() {
        return isActive && currentEnrollment < maxEnrollment;
    }
    
    public boolean enrollStudent() {
        if (canEnrollStudent()) {
            currentEnrollment++;
            updateLastModified();
            return true;
        }
        return false;
    }
    
    public boolean unenrollStudent() {
        if (currentEnrollment > 0) {
            currentEnrollment--;
            updateLastModified();
            return true;
        }
        return false;
    }
    
    public double getEnrollmentPercentage() {
        return maxEnrollment == 0 ? 0.0 : (double) currentEnrollment / maxEnrollment * 100;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return Objects.equals(code, course.code);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
    
    @Override
    public String toString() {
        return "Course{" +
               "code='" + code + "', " +
               "title='" + title + "', " +
               "credits=" + credits +
               ", instructor='" + instructorId + "', " +
               "semester=" + semester +
               ", dept='" + department + "', " +
               "enrollment=" + currentEnrollment + "/" + maxEnrollment +
               ", active=" + isActive +
               "}";
    }
}