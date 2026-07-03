package com.exceptions;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== Q2 EXCEPTIONS DEMO ==========\n");

        ExceptionDemo.main(args);

        System.out.println("\n=== Part (c): PaymentSystem & InsufficientFundsException ===");
        PaymentSystem ps = new PaymentSystem(500);
        try {
            ps.withdraw(600);
        } catch (InsufficientFundsException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println("\n=== Part (d): Try-with-resources ===");
        TryWithResourcesDemo.main(args);

        System.out.println("\n========== END ==========");
    }
}
