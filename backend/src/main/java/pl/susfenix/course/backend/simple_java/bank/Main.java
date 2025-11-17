package pl.susfenix.course.backend.simple_java.bank;

public class Main {

    public static void main(String[] args) {

        Account account1 = new Account(12, "x", "m");
        Account account2 = new Account(177, "y", "z");
        Account account3 = new Account(account1);
        //Account account3 = account1;

        account1.setBalance(15.6);
        account3.setBalance(45.9);

        account1.withdraw(67);

        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3);

    }

}
