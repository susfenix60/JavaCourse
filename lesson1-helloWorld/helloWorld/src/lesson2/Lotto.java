package lesson2;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Lotto {

    public static void main(String[] args) {

        startGame();
    }

    private static void startGame() {

        System.out.println("The lotto game has started");

        Set<Integer> userNumbers = retrieveUserNumbers();
        Set<Integer> computerNumbers = retrieveComputerNumbers();
        System.out.println("COMPUTER NUMBERS: " + computerNumbers);
        // 3. countHits();
        // 4. determineWinMoney();
        // 5. calculateStatistics();
        System.out.println("The Lotto game has ended");
    }


    private static Set<Integer> retrieveUserNumbers() {

        Set<Integer> userNumbers = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        while (userNumbers.size() < 6) {

            System.out.printf("Podaj %d liczbę: ", userNumbers.size() + 1);
            int currentUserInput = scanner.nextInt();
            if (currentUserInput >= 1 && currentUserInput <= 49) {
                userNumbers.add(currentUserInput);
            } else {
                System.out.println("You have chosen a number out of range 1-49");
            }

        }

        scanner.close();
        return userNumbers;
    }

    private static Set<Integer> retrieveComputerNumbers() {
        Random random = new Random();
        Set<Integer> computerNumbers = new HashSet<>();
        while (computerNumbers.size() < 6) {
            int currentRandomNumber = random.nextInt(49) + 1;
            computerNumbers.add(currentRandomNumber);
        }

        return computerNumbers;
    }


}
