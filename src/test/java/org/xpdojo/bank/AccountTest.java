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
}
