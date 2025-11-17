package pl.susfenix.course.backend.simple_java.extra;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BlackJackRemastered {

    public static void main(String[] args){

        retrieveComputerNumbers();
        int playerSum = 0;

        System.out.println("Lets play Blackjack");
        System.out.println(" ");

        System.out.println("Your first card: " + retrieveComputerNumbers());

        System.out.println(" ");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you hit or stand");

        String yourPlay = scanner.next();
        if (yourPlay == "stand"){



        }


    }

    private static int drawCards(){

        Random randomNumbers = new Random();
        return 0;

    }


    private static Set<Integer> retrieveComputerNumbers() {
        Random random = new Random();
        Set<Integer> computerNumbers = new TreeSet<>();
        while (computerNumbers.size() < 1) {
            int currentRandomNumber = random.nextInt(10) + 1;
            computerNumbers.add(currentRandomNumber);
        }


        return computerNumbers;
    }

}
