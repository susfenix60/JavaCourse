package pl.susfenix.course.backend.simple_java.bank;

import java.util.Objects;

public class Account {

    private double balance;
    private String name;
    private String accNumber;

    public Account(double balance, String name, String accNumber) {

        assert balance < 0 : "Balance can't be smaller than zero";

        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be smaller than 0");
        }

        if (name.isBlank()){
            throw new IllegalArgumentException("Name cannot be empty");
        }


        this.balance = balance;
        this.name = name;
        this.accNumber = accNumber;

    }

    public Account(Account other) {
        this(other.balance, other.name, other.accNumber);
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", name='" + name + '\'' +
                ", accNumber='" + accNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Account account = (Account) o;
        return account.balance == this.balance
                && account.name.equals(this.name)
                && account.accNumber.equals(this.accNumber);
        //return Double.compare(account.balance, balance) == 0 && name.equals(account.name) && accNumber.equals(account.accNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, name, accNumber);
    }

    public Account withdraw(double amount){

        if (balance < amount){
            throw new IllegalArgumentException("Amount is too big");
        }

        double calculatedBalance = balance - amount;
        return new Account(calculatedBalance, this.name, this.accNumber);


    }

    public void deposit(double amount){

        this.balance = balance + amount;

    }

}
