package pl.susfenix.course.backend.game.lotto;


import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Lotto_old {

    public static void main(String[] args) {

        startGame();
    }

    private static void startGame() {

        System.out.println("The lotto lesson3.game has started");

        Set<Integer> userNumbers = retrieveUserNumbers();
        Set<Integer> computerNumbers = retrieveComputerNumbers();
        System.out.println("User numbers: " + userNumbers);

        System.out.println("COMPUTER NUMBERS: " + computerNumbers);
        int hitsCounter = countHits(computerNumbers, userNumbers);
        System.out.println("Right guessed hits: " + hitsCounter);
        double wonMoney = determineWinMoney2(hitsCounter);
        System.out.println("Won money: " + wonMoney);
        int winRateThree = calculateStatistics(userNumbers, 3);
        int winRateFour = calculateStatistics(userNumbers, 4);
        System.out.println("winRateThree: " + winRateThree);
        System.out.println("winRateFour: " + winRateFour);
        System.out.println("The Lotto lesson3.game has ended");
    }

    private static Set<Integer> retrieveUserNumbers() {

        Set<Integer> userNumbers = new TreeSet<>();
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

        //scanner.close();
        return userNumbers;
    }

    private static Set<Integer> retrieveComputerNumbers() {
        Random random = new Random();
        Set<Integer> computerNumbers = new TreeSet<>();
        while (computerNumbers.size() < 6) {
            int currentRandomNumber = random.nextInt(49) + 1;
            computerNumbers.add(currentRandomNumber);
        }


        return computerNumbers;
    }

    private static int countHits(Set<Integer> computerNumbers, Set<Integer> userNumbers) {

        int rightHits = 0;

        for (int currentHitCheck : userNumbers) {
            for (int currentComputerNumber : computerNumbers) {
                if (currentComputerNumber == currentHitCheck) {
                    rightHits++;
                }
            }
        }

        return rightHits;
    }

    private static int countHits2(Set<Integer> computerNumbers, Set<Integer> userNumbers) {

        int rightHits = 0;

        for (int currentHitCheck : userNumbers) {
            if (computerNumbers.contains(currentHitCheck)) {
                rightHits++;
            }
        }

        return rightHits;
    }

    //W Lotto Plus każda wygrana ma stałą wysokość. Trafienie 6 z 49 liczb oznacza wygraną 1 000 000 zł. „Piątka” to 3500 zł, „czwórka” – 100 zł, a „trójka” – 10 zł.
    private static double determineWinMoney(int hitsCounter) {

        double win = 0;

        if (hitsCounter == 6) {
            win = 1_000_000;
        } else if (hitsCounter == 5) {
            win = 3500;
        } else if (hitsCounter == 4) {
            win = 100;
        } else if (hitsCounter == 3) {
            win = 10;
        }

        return win;
    }

    private static double determineWinMoney2(int hitsCounter) {
        switch (hitsCounter) {
            case 6:
                return 1_000_000;
            case 5:
                return 3500;
            case 4:
                return 100;
            case 3:
                return 10;

            default:
                return 0;
        }
    }

    private static int calculateStatistics(Set<Integer> userNumbers, int hitRate) {
        int winRateCounter = 0;
        int randomRate = 0;

        while (winRateCounter < hitRate) {
            randomRate++;
            Set<Integer> computerNumbers = retrieveComputerNumbers();
            int hitCounter = countHits(computerNumbers, userNumbers);

            if (hitCounter >= hitRate) {
                winRateCounter++;
            }

        }
        return randomRate;
    }
}