package org.xpdojo.bank;

import java.text.NumberFormat;
import java.time.LocalDate;

public class Account {
    private int balance;
    public Account() {}

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }
    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) throws NumberFormatException {
        if(amount < 0) {
            throw new NumberFormatException("Amount can not be negative when depositing");
        }
        this.balance += amount;
    }

    public int withdraw(int amount) {
        if(amount < 0) {
            throw new NumberFormatException("Amount can not be negative when withdrawing");
        }
        this.balance -= amount;
        return amount;
    }

    public void transferMoneyTo(Account account2, int amount) throws NumberFormatException {
        int money = this.withdraw(amount);
        account2.deposit(money);
    }

    public void printBalanceSlip() {
        System.out.println(LocalDate.now() + " " + balance);
    }
}
