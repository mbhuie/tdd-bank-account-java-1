package org.xpdojo.bank;

public class NotEnoughBalance extends RuntimeException {

    public NotEnoughBalance() {}
    public NotEnoughBalance(String s) {
        super(s);
    }
}
