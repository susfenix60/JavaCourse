package pl.susfenix.course.frontend.console.game.lotto;

import pl.susfenix.course.backend.game.lotto.object.logic.LottoApi;
import pl.susfenix.course.backend.game.lotto.object.model.LottoGameState;
import pl.susfenix.course.frontend.console.layout.ScannerHolder;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LottoConsole {

    public static void start() {

        System.out.println("The lotto lesson3.game has started");

        Set<Integer> userNumbers = retrieveUserNumbers();
        LottoGameState gameState = LottoApi.startGame(userNumbers);
        System.out.println("User numbers: " + userNumbers);

        System.out.println("COMPUTER NUMBERS: " + gameState.getComputerNumbers());
        System.out.println("Right guessed hits: " + gameState.getHits().size());
        System.out.println("Won money: " + gameState.getWonMoney());
        System.out.println("winRateThree: " + gameState.getWinRateThree());
        System.out.println("winRateFour: " + gameState.getWinRateFour());
        System.out.println("The Lotto game has ended");
    }

    private static Set<Integer> retrieveUserNumbers() {

        Set<Integer> userNumbers = new TreeSet<>();
        Scanner scanner = ScannerHolder.getScanner();

        while (userNumbers.size() < 6) {

            System.out.printf("Podaj %d liczbę: ", userNumbers.size() + 1);
            int currentUserInput = scanner.nextInt();
            if (currentUserInput >= 1 && currentUserInput <= 49) {
                userNumbers.add(currentUserInput);
            } else {
                System.out.println("You have chosen a number out of range 1-49");
            }

        }

        return userNumbers;
    }
}
