package org.example;
public class AccountTest {
    public static void main(String[] args) {
        CheckingAccount account = new CheckingAccount(270.000, "Shefira Marizcha");
        SavingBonds bonds = new SavingBonds();

        System.out.println("Account Holder: " + account.getName());
        System.out.println("Initial Balance: $" + account.getBalance() + "\n");

        account.withdraw(200); //should be okay
        account.withdraw(-100); //should be shown warning
        account.withdraw(700); //should be shown warning
        account.addBalance(2000);

        bonds.showInterest(1000, 3, account.getBalance());
    }
}