package edu.ccrm;

import edu.ccrm.cli.CCRMCommandLine;
import edu.ccrm.config.AppConfig;

/**
 * Main application class for Campus Course & Records Manager (CCRM)
 * Entry point demonstrating proper Java application structure
 * 
 * @author CCRM Development Team
 * @version 1.0
 * @since Java SE 11+
 */
public class CCRMApplication {
    
    /**
     * Main method - application entry point
     * Demonstrates proper exception handling and resource management
     * 
     * @param args command line arguments (not used in this application)
     */
    public static void main(String[] args) {
        try {
            // Print application header
            printApplicationHeader();
            
            // Initialize configuration (Singleton pattern)
            AppConfig config = AppConfig.getInstance();
            System.out.println("Application configuration loaded successfully.");
            
            // Validate Java version
            validateJavaVersion();
            
            // Create and run the CLI application
            CCRMCommandLine cli = new CCRMCommandLine();
            cli.run();
            
        } catch (Exception e) {
            System.err.println("Fatal error occurred during application startup:");
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        } finally {
            System.out.println("\nCCRM Application shutdown complete.");
        }
    }
    
    /**
     * Print application header with version information
     */
    private static void printApplicationHeader() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("    CAMPUS COURSE & RECORDS MANAGER (CCRM)");
        System.out.println("         Comprehensive Java SE Application");
        System.out.println("=".repeat(80));
        System.out.println("Version: 1.0");
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Operating System: " + System.getProperty("os.name"));
        System.out.println("User: " + System.getProperty("user.name"));
        System.out.println("Working Directory: " + System.getProperty("user.dir"));
        System.out.println("=".repeat(80));
        
        // Display technical specifications
        printTechnicalSpecs();
    }
    
    /**
     * Display technical specifications and features implemented
     */
    private static void printTechnicalSpecs() {
        System.out.println("\nTechnical Features Implemented:");
        System.out.println("• Object-Oriented Programming (OOP) - All 4 pillars");
        System.out.println("• Design Patterns - Singleton, Builder");
        System.out.println("• Exception Handling - Custom & Standard exceptions");
        System.out.println("• Lambda Expressions & Functional Interfaces");
        System.out.println("• Stream API & Method References");
        System.out.println("• NIO.2 File Operations (Path, Files, Streams)");
        System.out.println("• Date/Time API (LocalDate, LocalDateTime)");
        System.out.println("• Enums with constructors and methods");
        System.out.println("• Recursive Algorithms & Utilities");
        System.out.println("• Immutable Classes & Defensive Copying");
        System.out.println("• Collections Framework & Generic Types");
        System.out.println("• String Processing & Regular Expressions");
        System.out.println("• Multi-catch & Try-with-resources");
        System.out.println("• Enhanced Switch Statements (Java 14+)");
        System.out.println("• Annotations & Assertions");
        System.out.println("• Package Organization & Access Modifiers");
        System.out.println("=".repeat(80) + "\n");
    }
    
    /**
     * Validate Java version and display compatibility information
     */
    private static void validateJavaVersion() {
        String javaVersion = System.getProperty("java.version");
        String[] versionParts = javaVersion.split("\\.");
        
        try {
            int majorVersion = Integer.parseInt(versionParts[0]);
            
            if (majorVersion < 11) {
                System.out.println("WARNING: This application is designed for Java 11+");
                System.out.println("Current version: " + javaVersion);
                System.out.println("Some features may not work properly on older versions.");
            } else {
                System.out.println("Java version check passed: " + javaVersion);
            }
            
            // Display version-specific features
            displayVersionFeatures(majorVersion);
            
        } catch (NumberFormatException e) {
            System.out.println("Unable to parse Java version: " + javaVersion);
        }
    }
    
    /**
     * Display features available in current Java version
     * 
     * @param majorVersion the major Java version number
     */
    private static void displayVersionFeatures(int majorVersion) {
        System.out.println("\nJava Version Features Available:");
        
        if (majorVersion >= 8) {
            System.out.println("✓ Lambda Expressions (Java 8+)");
            System.out.println("✓ Stream API (Java 8+)");
            System.out.println("✓ Date/Time API (Java 8+)");
            System.out.println("✓ Default Methods in Interfaces (Java 8+)");
        }
        
        if (majorVersion >= 9) {
            System.out.println("✓ Module System (Java 9+)");
            System.out.println("✓ Try-with-resources improvements (Java 9+)");
        }
        
        if (majorVersion >= 11) {
            System.out.println("✓ Local Variable Type Inference - var (Java 10+)");
            System.out.println("✓ String methods enhancements (Java 11+)");
            System.out.println("✓ Files.readString/writeString (Java 11+)");
        }
        
        if (majorVersion >= 14) {
            System.out.println("✓ Enhanced Switch Expressions (Java 14+)");
            System.out.println("✓ Pattern Matching for instanceof (Java 14+)");
        }
        
        if (majorVersion >= 17) {
            System.out.println("✓ Sealed Classes (Java 17+)");
            System.out.println("✓ Records (Java 17+)");
        }
        
        System.out.println();
    }
    
    /**
     * Utility method to demonstrate operator precedence
     * This is a simple example for educational purposes
     */
    @SuppressWarnings("unused")
    private static void demonstrateOperatorPrecedence() {
        // Demonstrating operator precedence with comments
        int a = 5, b = 3, c = 2;
        
        // Arithmetic operators: *, /, % have higher precedence than +, -
        int result1 = a + b * c;     // Result: 5 + (3 * 2) = 11
        int result2 = (a + b) * c;   // Result: (5 + 3) * 2 = 16
        
        // Comparison and logical operators
        boolean bool1 = a > b && b > c;  // true && true = true
        boolean bool2 = a > b || b < c;  // true || false = true
        
        // Assignment has lowest precedence
        int result3 = a += b * c;    // a = a + (b * c) = 5 + 6 = 11
        
        // These examples demonstrate precedence but variables are unused
        // This is for educational documentation purposes
    }
    
    /**
     * Static block for class initialization (demonstration)
     */
    static {
        System.setProperty("ccrm.application.name", "Campus Course & Records Manager");
        System.setProperty("ccrm.version", "1.0");
        // Note: This static block runs when the class is first loaded
    }
}