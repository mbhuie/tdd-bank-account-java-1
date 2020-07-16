package org.xpdojo.bank;

public class Account {
    private int balance;
    public Account() {}

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }
    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }
}
