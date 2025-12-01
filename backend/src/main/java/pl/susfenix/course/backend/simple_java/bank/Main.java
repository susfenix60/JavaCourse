package pl.susfenix.course.backend.simple_java.bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Account account1 = new Account(12, "x", "m");
        Account account2 = new Account(177, "y", "z");
        Account account3 = new Account(account1);
        Account account4 = new Account(-1, "tt", "vv");
        //Account account3 = account1;

        account1.setBalance(15.6);
        account3.setBalance(45.9);

        account1.withdraw(2.7);
        account1.withdraw(3.5);

        account2 = account2.withdraw(2.3)
                .withdraw(8);

        Account[] accounts = new Account[2];
        accounts[0] = new Account(15, "Tymek", "xx");
        accounts[1] = new Account(153, "Tymel", "xy");
        //accounts[2] = new Account(473, "Thn", "po");

        List<Account>accountList = new ArrayList<>();
        accountList.add(new Account(11,"a","x"));
        accountList.add(new Account(12,"b","y"));
        accountList.add(new Account(13,"c","z"));


        //account1.withdraw(67);

        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3);
        System.out.println(account1.equals(account3));
        System.out.println(Arrays.toString(accounts));
        System.out.println(accountList);

    }

}
