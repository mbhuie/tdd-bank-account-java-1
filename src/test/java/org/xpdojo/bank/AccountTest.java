package org.xpdojo.bank;

import org.assertj.core.condition.Negative;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void depositingMoneyIntoAccountIncreasesBalance() throws NumberFormatException {
        Account account = new Account(100);
        account.deposit(10);
        assertThat(account.getBalance()).isEqualTo(110);
    }

    @Test
    public void shouldNotBeAbleToDepositNegativeAmount(){
        Account account = new Account(100);
        Exception exception = assertThrows(NumberFormatException.class, () -> account.deposit(-10));
        String expectedMessage  = "Amount can not be negative when depositing";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void withdrawMoneyFromAccountReducesBalance() {
        Account account = new Account(100);
        int withdrawnMoney = account.withdraw(10);
        assertThat(account.getBalance()).isEqualTo(90);
        assertThat(withdrawnMoney).isEqualTo(10);
    }

    @Test
    public void transferMoneyBetweenAccounts() throws NumberFormatException {
        Account account1 = new Account(100);
        Account account2 = new Account(50);
        account1.transferMoneyTo(account2, 30);
        assertThat(account1.getBalance()).isEqualTo(70);
        assertThat(account2.getBalance()).isEqualTo(80);
    }

    @Test
    public void printAcocuntBalanceSlip() throws IOException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Account account = new Account(100);
        account.printBalanceSlip();

        outputStream.flush();
        String message = new String(outputStream.toByteArray());
        assertTrue(message.contains(LocalDate.now() + " " + "100"));
    }
}
