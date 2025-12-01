package pl.susfenix.course.backend.simple_java.bank;

public class Bank {

    /*Write a Java program to create a class called "Bank" with a collection of accounts and methods to add and remove accounts, and to deposit and withdraw money.
     Also define a class called "Account" to maintain account details of a particular customer.
    */

    private String name;
    private Account[] accounts;

    private Bank(){

        this.accounts = new Account[2];
        this.accounts[0] = new Account(15, "Tymek", "xx");

    }

    public void withdraw(double amount, Account account) {

        account.withdraw(amount);

    }


}
