package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.*;

/**
 * Student class extending Person
 * Demonstrates inheritance, encapsulation, and polymorphism
 */
public class Student extends Person {
    private String regNo;
    private StudentStatus status;
    private Set<String> enrolledCourses; // Course codes
    private LocalDate enrollmentDate;
    private Map<String, Grade> courseGrades; // Course code -> Grade
    
    // Inner enum for student status
    public enum StudentStatus {
        ACTIVE, INACTIVE, GRADUATED, SUSPENDED
    }
    
    // Constructor using super
    public Student(String id, String regNo, Name name, String email, LocalDate dateOfBirth) {
        super(id, name, email, dateOfBirth);
        this.regNo = Objects.requireNonNull(regNo, "Registration number cannot be null");
        this.status = StudentStatus.ACTIVE;
        this.enrolledCourses = new HashSet<>();
        this.enrollmentDate = LocalDate.now();
        this.courseGrades = new HashMap<>();
    }
    
    // Overridden abstract methods
    @Override
    public String getPersonType() {
        return "Student";
    }
    
    @Override
    public void displayProfile() {
        System.out.println("========== STUDENT PROFILE ==========");
        System.out.println("ID: " + getId());
        System.out.println("Registration No: " + regNo);
        System.out.println("Name: " + getName().getFullName());
        System.out.println("Email: " + getEmail());
        System.out.println("Age: " + getAge() + " years");
        System.out.println("Status: " + status);
        System.out.println("Enrollment Date: " + enrollmentDate);
        System.out.println("Enrolled Courses: " + enrolledCourses.size());
        System.out.println("Current GPA: " + String.format("%.2f", calculateGPA()));
        System.out.println("=====================================");
    }
    
    // Getters and setters demonstrating encapsulation
    public String getRegNo() {
        return regNo;
    }
    
    public StudentStatus getStatus() {
        return status;
    }
    
    public void setStatus(StudentStatus status) {
        this.status = Objects.requireNonNull(status);
        updateLastModified();
    }
    
    public Set<String> getEnrolledCourses() {
        return new HashSet<>(enrolledCourses); // Defensive copy
    }
    
    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }
    
    // Course enrollment methods
    public boolean enrollInCourse(String courseCode) {
        if (courseCode == null || courseCode.trim().isEmpty()) {
            return false;
        }
        boolean added = enrolledCourses.add(courseCode.trim().toUpperCase());
        if (added) {
            updateLastModified();
        }
        return added;
    }
    
    public boolean unenrollFromCourse(String courseCode) {
        if (courseCode == null) return false;
        boolean removed = enrolledCourses.remove(courseCode.trim().toUpperCase());
        if (removed) {
            courseGrades.remove(courseCode.trim().toUpperCase());
            updateLastModified();
        }
        return removed;
    }
    
    public boolean isEnrolledIn(String courseCode) {
        return courseCode != null && enrolledCourses.contains(courseCode.trim().toUpperCase());
    }
    
    // Grade management
    public void recordGrade(String courseCode, Grade grade) {
        if (courseCode != null && grade != null && isEnrolledIn(courseCode)) {
            courseGrades.put(courseCode.trim().toUpperCase(), grade);
            updateLastModified();
        }
    }
    
    public Grade getGrade(String courseCode) {
        return courseCode != null ? courseGrades.get(courseCode.trim().toUpperCase()) : null;
    }
    
    public Map<String, Grade> getAllGrades() {
        return new HashMap<>(courseGrades); // Defensive copy
    }
    
    // GPA calculation using streams
    public double calculateGPA() {
        if (courseGrades.isEmpty()) return 0.0;
        
        return courseGrades.values().stream()
                .mapToDouble(Grade::getGradePoints)
                .average()
                .orElse(0.0);
    }
    
    // Get total credits (assuming each course is 3 credits)
    public int getTotalCredits() {
        return enrolledCourses.size() * 3;
    }
    
    // Check if student can enroll in more courses (max 24 credits per semester)
    public boolean canEnrollInMoreCourses() {
        return getTotalCredits() < 24;
    }
    
    // Generate transcript string
    public String generateTranscript() {
        StringBuilder transcript = new StringBuilder();
        transcript.append("OFFICIAL TRANSCRIPT\n");
        transcript.append("==================\n");
        transcript.append("Student: ").append(getName().getFullName()).append("\n");
        transcript.append("ID: ").append(getId()).append("\n");
        transcript.append("Reg No: ").append(regNo).append("\n");
        transcript.append("\nCourse Grades:\n");
        
        if (courseGrades.isEmpty()) {
            transcript.append("No grades recorded.\n");
        } else {
            courseGrades.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> 
                        transcript.append(entry.getKey())
                                 .append(": ")
                                 .append(entry.getValue())
                                 .append("\n"));
        }
        
        transcript.append("\nOverall GPA: ").append(String.format("%.2f", calculateGPA()));
        transcript.append("\nTotal Credits: ").append(getTotalCredits());
        transcript.append("\n==================\n");
        
        return transcript.toString();
    }
    
    @Override
    public String toString() {
        return "Student{" +
               "id='" + getId() + "', " +
               "regNo='" + regNo + "', " +
               "name=" + getName() +
               ", status=" + status +
               ", courses=" + enrolledCourses.size() +
               ", gpa=" + String.format("%.2f", calculateGPA()) +
               "}";
    }
}