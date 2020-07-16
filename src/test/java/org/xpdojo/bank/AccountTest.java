package org.xpdojo.bank;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
	public void newAccountHasZeroBalanceByDefault() {
        Account account = new Account();
        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    public void newAccountHasBalanceWhenSpecifiedOnOpening() {
        Account account = new Account(100);
        assertThat(account.getBalance()).isEqualTo(100);
    }

    @Test
    public void depositingMoneyIntoAccountIncreasesBalance() {
        Account account = new Account(100);
        account.deposit(10);
        assertThat(account.getBalance()).isEqualTo(110);
    }

    @Test
    public void withdrawMoneyFromAccountReducesBalance() {
        Account account = new Account(100);
        int withdrawnMoney = account.withdraw(10);
        assertThat(account.getBalance()).isEqualTo(90);
        assertThat(withdrawnMoney).isEqualTo(10);
    }

    @Test
    public void transferMoneyBetweenAccounts() {
        Account account1 = new Account(100);
        Account account2 = new Account(50);
        account1.transferMoneyTo(account2, 30);
        assertThat(account1.getBalance()).isEqualTo(70);
        assertThat(account2.getBalance()).isEqualTo(80);
    }
}
