package pl.susfenix.course.backend.game.lotto.object.model;

import java.util.Set;

public class LottoGameState {

    private final Set<Integer> userNumbers;
    private final Set<Integer> computerNumbers;
    private final Set<Integer> hits;
    private final double wonMoney;
    private final int winRateThree;
    private final int winRateFour;

    public LottoGameState(Set<Integer> userNumbers, Set<Integer> computerNumbers, Set<Integer> hits, double wonMoney, int winRateThree, int winRateFour) {
        this.userNumbers = userNumbers;
        this.computerNumbers = computerNumbers;
        this.hits = hits;
        this.wonMoney = wonMoney;
        this.winRateThree = winRateThree;
        this.winRateFour = winRateFour;
    }

    public Set<Integer> getUserNumbers() {
        return userNumbers;
    }

    public Set<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public Set<Integer> getHits() {
        return hits;
    }

    public double getWonMoney() {
        return wonMoney;
    }

    public int getWinRateThree() {
        return winRateThree;
    }

    public int getWinRateFour() {
        return winRateFour;
    }

    @Override
    public String toString() {
        return "LottoGameState{" +
                "userNumbers=" + userNumbers +
                ", computerNumbers=" + computerNumbers +
                ", hits=" + hits +
                ", wonMoney=" + wonMoney +
                ", winRateThree=" + winRateThree +
                ", winRateFour=" + winRateFour +
                '}';
    }
}
