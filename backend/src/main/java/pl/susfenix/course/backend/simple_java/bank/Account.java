package pl.susfenix.course.backend.simple_java.bank;

public class Account {

    private double balance;
    private String name;
    private String accNumber;

    public Account(double balance, String name, String accNumber) {

        this.balance = balance;
        this.name = name;
        this.accNumber = accNumber;

    }

    public Account(Account other) {
        this.balance = other.balance;
        this.name = other.name;
        this.accNumber = other.accNumber;
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

    public void withdraw(double amount){

        if (balance < amount){
            throw new IllegalArgumentException("Amount is too big");
        }

        this.balance = balance - amount;

    }

    public void deposit(double amount){

        this.balance = balance + amount;

    }

}
