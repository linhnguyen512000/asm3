package vn.funix.fx20512.java.asm03.models;

import vn.funix.fx20512.java.asm02.models.Account;

public class SavingAccount extends Account implements ReportService, Withdraw {
    private static final double SAVING_ACCOUNT_MAX_WITHDRAW = 5_000_000;

    public SavingAccount(String accNum, double balance) {
        super(accNum, balance);
    }

    public boolean isAccepted(double amount) {
        if ((this.getBalance() - amount) >= 50000) {
            if (amount >= 50000 && amount%10000 == 0) {
                if(!isPremium() && amount <= SAVING_ACCOUNT_MAX_WITHDRAW) {
                    return true;
                } else if (isPremium()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void log(double amount) {
        System.out.println(Utils.getDivider());
        System.out.printf("%30s%n", "BIEN LAI GIAO DICH SAVINGS");
        System.out.printf("NGAY G/D: %28s%n", Utils.getDateTime());
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2023");
        System.out.printf("SO TK: %31s%n", this.getAccountNumber());
        System.out.printf("SO TIEN: %29s%n", Utils.formatBalance(amount));
        System.out.printf("SO DU: %31s%n", Utils.formatBalance(this.getBalance()));
        System.out.printf("PHI + VAT: %27s%n", "0đ");
        System.out.println(Utils.getDivider());
    }

    public boolean withdraw(double amount) {
        if (isAccepted(amount)) {
            setBalance(getBalance() - amount);
            log(amount);
            Transaction a = new Transaction(getAccountNumber(), amount, Utils.getDateTime(), true);
            getTransaction().add(a);
            return true;
        } else {
            Transaction a = new Transaction(getAccountNumber(), amount, Utils.getDateTime(), false);
            getTransaction().add(a);
            System.out.println("So tien rut khong hop le!");
        }
        return false;
    }

}
