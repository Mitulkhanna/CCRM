# Campus Course & Records Manager (CCRM)

A comprehensive Java console application for managing students, courses, enrollments, and grades in an educational institution.

## Features

- Student Management (add, update, deactivate, search)
- Course Management (add, update, deactivate, search by various criteria)
- Enrollment Management with credit limit validation
- Grade Recording and GPA Calculation
- Data Import/Export from/to CSV files
- Backup and Restore functionality
- Various reports and statistics

## Technical Requirements Demonstrated

- OOP Principles (Encapsulation, Inheritance, Abstraction, Polymorphism)
- Exception Handling (custom exceptions, try-catch-finally)
- File I/O with NIO.2
- Java Stream API for data processing
- Date/Time API
- Interfaces and Abstract Classes
- Nested Classes (Builder pattern)
- Enums with constructors and fields
- Lambdas and Functional Interfaces
- Design Patterns (Singleton, Builder)
- Recursion

## Evolution of Java

- 1995: Java 1.0 released
- 1997: Java 1.1 introduced inner classes and JDBC
- 2004: Java 5 introduced generics, annotations, autoboxing
- 2014: Java 8 introduced lambdas, streams, and new date/time API
- 2017: Java 9 introduced modules and JShell
- 2021: Java 17 LTS released with sealed classes and pattern matching

## Java Platforms Comparison

| Platform | Purpose | Target Environment |
|----------|---------|-------------------|
| Java SE | Standard Edition | Desktop and server applications |
| Java EE | Enterprise Edition | Large-scale distributed systems |
| Java ME | Micro Edition | Embedded and mobile devices |

## Java Architecture

- **JDK** (Java Development Kit): Development tools including compiler, debugger, and documentation tools
- **JRE** (Java Runtime Environment): Runtime environment for executing Java applications
- **JVM** (Java Virtual Machine): Executes Java bytecode, provides platform independence

## Installation and Setup

### Windows Installation

1. Download JDK from Oracle's website
2. Run the installer and follow the prompts
3. Set JAVA_HOME environment variable to JDK installation path
4. Add %JAVA_HOME%\bin to PATH environment variable

### Eclipse IDE Setup

1. Download Eclipse IDE for Java Developers
2. Extract and run eclipse.exe
3. Create a new Java project
4. Configure build path to use the installed JDK
5. Create packages and classes as per the project structure

## How to Run

1. Clone the repository
2. Open the project in Eclipse or any Java IDE
3. Ensure Java 8 or later is configured
4. Run the `CCRMApplication.java` class

## Sample Commands

The application provides a menu-driven interface. Follow the prompts to:

1. Add students and courses
2. Enroll students in courses
3. Record grades
4. Generate transcripts
5. Import/export data
6. Create backups

## Enabling Assertions

To enable assertions during runtime, use the `-ea` flag:
