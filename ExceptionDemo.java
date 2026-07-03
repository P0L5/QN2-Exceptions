package com.exceptions;

public class ExceptionDemo {

    static int mystery() {
        try {
            System.out.println("A");
            return 1;
        } catch (Exception e) {
            System.out.println("B");
            return 2;
        } finally {
            System.out.println("C");
            return 3;
        }
    }

    static int risky(int x) {
        try {
            if (x == 0) throw new ArithmeticException();
            return 10 / x;
        } catch (ArithmeticException e) {
            System.out.println("caught");
            return -1;
        } finally {
            System.out.println("done");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Part (a): mystery() ===");
        System.out.println("Caller prints: " + mystery());

        System.out.println("\n=== Part (b): risky(0) ===");
        System.out.println("Returned: " + risky(0));

        System.out.println("\n=== Part (b): risky(2) ===");
        System.out.println("Returned: " + risky(2));
    }
}
