# QN2 Exceptions

A comprehensive Java educational project demonstrating exception handling best practices, custom exceptions, and try-with-resources patterns.

## Overview

This project showcases key Java exception handling concepts through practical examples and demonstrations:

- **Try-Catch-Finally Behavior** – Understanding control flow in exception handling
- **Custom Exceptions** – Creating domain-specific exceptions
- **Try-With-Resources** – Automatic resource management and preventing resource leaks

## Project Structure

```
QN2-Exceptions/
├── src/main/java/com/exceptions/
│   ├── Main.java                      # Entry point coordinating all demos
│   ├── ExceptionDemo.java             # Part (a) & (b): Try-catch-finally flow
│   ├── PaymentSystem.java             # Part (c): Business logic with custom exception
│   ├── InsufficientFundsException.java # Part (c): Custom exception class
│   └── TryWithResourcesDemo.java       # Part (d): Resource management patterns
├── pom.xml                             # Maven configuration
└── README.md                           # This file
```

## Prerequisites

- **Java 17** or higher
- **Maven 3.6+**

## Features

### Part (a): Mystery Method
Demonstrates the execution order of `try`, `catch`, and `finally` blocks:
- `finally` blocks always execute, even when a `return` statement is present
- The return value can be overridden by `finally` block statements

```java
mystery() // Returns 3 (from finally block)
// Prints: A C
```

### Part (b): Risky Method
Illustrates exception handling in arithmetic operations:
- Catches `ArithmeticException` when dividing by zero
- `finally` block executes regardless of exception occurrence

```java
risky(0)  // Catches exception, returns -1
risky(2)  // Normal execution, returns 5
// Both print "done" from finally block
```

### Part (c): Payment System
Demonstrates custom exception handling:
- Throws `InsufficientFundsException` for invalid withdrawal requests
- Custom exception message includes balance and requested amount
- Real-world use case for exception handling

```java
PaymentSystem ps = new PaymentSystem(500);
ps.withdraw(600); // Throws InsufficientFundsException
```

### Part (d): Try-With-Resources
Shows automatic resource management:
- **Before:** Manual resource closing (resource leak if exception occurs)
- **After:** Try-with-resources automatically closes resources

```java
// Safely handles resources with automatic cleanup
try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
    String line = br.readLine();
}
```

## Building the Project

### Using Maven

```bash
# Compile the project
mvn clean compile

# Run the application
mvn exec:java -Dexec.mainClass="com.exceptions.Main"

# Package into JAR
mvn package
```

### Using IDE

1. Open the project in your IDE (IntelliJ IDEA, Eclipse, VSCode)
2. Right-click on `Main.java` → Run as Java Application

## Running the Application

### From Command Line

```bash
# After compilation
java -cp target/classes com.exceptions.Main
```

### Expected Output

```
========== Q2 EXCEPTIONS DEMO ==========

=== Part (a): mystery() ===
A
C
Caller prints: 3

=== Part (b): risky(0) ===
caught
done
Returned: -1

=== Part (b): risky(2) ===
done
Returned: 5

=== Part (c): PaymentSystem & InsufficientFundsException ===
Caught: Insufficient funds: balance = UGX 500, requested = UGX 600

=== Part (d): Try-with-resources ===
=== Leaky version (before) ===
If readLine() throws, close() is never called.

=== Try-with-resources (after) ===
BufferedReader is auto-closed even if readLine() throws.
IOException caught (expected since data.txt may not exist)

========== END ==========
```

## Key Concepts Covered

### Exception Handling Basics
- `try-catch-finally` block execution order
- Exception propagation and catching
- Finally block guarantees

### Custom Exceptions
- Extending the `Exception` class
- Creating meaningful exception messages
- Using custom exceptions for domain-specific errors

### Resource Management
- Traditional resource closing pattern (error-prone)
- Try-with-resources pattern (Java 7+)
- Automatic resource cleanup (implements `AutoCloseable`)

### Best Practices
- Always use try-with-resources for `AutoCloseable` resources
- Create custom exceptions for domain-specific errors
- Understand finally block behavior when returning values
- Never suppress `finally` block returns

## Technologies Used

- **Java** 17
- **Maven** 3.6+
- **Core Java Libraries** (java.io, java.lang)

## Usage Examples

```java
// Example 1: Custom Exception Usage
try {
    paymentSystem.withdraw(1000);
} catch (InsufficientFundsException e) {
    System.err.println("Transaction failed: " + e.getMessage());
}

// Example 2: Try-With-Resources
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    System.err.println("File reading error: " + e.getMessage());
}
```

## Learning Objectives

After exploring this project, you will understand:

✓ How `try-catch-finally` blocks execute in Java  
✓ The purpose and implementation of custom exceptions  
✓ Best practices for resource management  
✓ Why finally blocks always execute  
✓ The limitations and gotchas of exception handling  
✓ Modern Java patterns for safe resource handling  

## License

This project is provided for educational purposes.

## Author

Educational Java Exception Handling Project

## Contributing

This is an educational project. Feel free to fork and experiment with the code.

## Related Resources

- [Java Exception Handling - Oracle Docs](https://docs.oracle.com/javase/tutorial/essential/exceptions/)
- [Try-With-Resources - Oracle Docs](https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html)
- [Custom Exceptions - Best Practices](https://www.baeldung.com/java-custom-exception)
