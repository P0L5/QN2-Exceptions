package com.exceptions;

public class PaymentSystem {
    private double balance;

    public PaymentSystem(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(
                "Insufficient funds: balance = UGX " + balance + ", requested = UGX " + amount
            );
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
