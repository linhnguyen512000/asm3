package vn.funix.fx20512.java.asm02.models;

import vn.funix.fx20512.java.asm03.models.Transaction;

import java.util.ArrayList;

public class Account {
    private String accountNumber;
    private double balance;
    private ArrayList<Transaction> transaction;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transaction = new ArrayList<Transaction>();
    }

    public void setTransaction() {
        this.transaction = new ArrayList<Transaction>();
    }

    public ArrayList<Transaction> getTransaction() {
        return transaction;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isPremium() {
        if (this.balance >= 10_000_000) {
            return true;
        }
        return false;
    }

//    Hàm toString bị conflict với hàm toString của Java nên em đổi tên
    public void toStringAccount() {
        System.out.println(this.accountNumber + " |           " + this.balance);
    }

}
