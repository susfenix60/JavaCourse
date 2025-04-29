package pl.susfenix.course.backend.game.lotto.object.logic;

import pl.susfenix.course.backend.game.lotto.object.model.LottoGameState;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LottoApi {

    public static LottoGameState startGame(Set<Integer> userNumbers){
        Set<Integer> computerNumbers = retrieveComputerNumbers();
        Set<Integer> hits = extractHits(computerNumbers, userNumbers);
        double wonMoney = determineWinMoney2(hits.size());
        int winRateThree = calculateStatistics(userNumbers, 3);
        int winRateFour = calculateStatistics(userNumbers, 4);


        //return LottoGameState.of(userNumbers, computerNumbers, hits, wonMoney, winRateThree, winRateFour);
        //return new LottoGameState(userNumbers, computerNumbers, hits, wonMoney, winRateThree, winRateFour);
        return LottoGameState.builder()
                .computerNumbers(computerNumbers)
                .winRateThree(winRateThree)
                .userNumbers(userNumbers)
                .wonMoney(wonMoney)
                .hits(hits)
                .winRateFour(winRateFour)
                .build();
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

    private static Set<Integer> extractHits(Set<Integer> computerNumbers, Set<Integer> userNumbers) {

        Set<Integer> hits = new TreeSet<>();

        for (int currentHitCheck : userNumbers) {
            for (int currentComputerNumber : computerNumbers) {
                if (currentComputerNumber == currentHitCheck) {
                    hits.add(currentHitCheck);
                }
            }
        }

        return hits;
    }

    /*
    W Lotto Plus każda wygrana ma stałą wysokość.
    Trafienie 6 z 49 liczb oznacza wygraną 1 000 000 zł.
    „Piątka” to 3500 zł,
    „czwórka” – 100 zł,
    „trójka” – 10 zł.
     */
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
            int hitCounter = extractHits(computerNumbers, userNumbers).size();

            if (hitCounter >= hitRate) {
                winRateCounter++;
            }

        }
        return randomRate;
    }

}
