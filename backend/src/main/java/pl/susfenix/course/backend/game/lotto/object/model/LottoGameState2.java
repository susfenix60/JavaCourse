package pl.susfenix.course.backend.game.lotto.object.model;

import java.util.Set;

public class LottoGameState2 {

    private final Set<Integer> userNumbers;
    private final Set<Integer> computerNumbers;
    private final Set<Integer> hits;
    private final double wonMoney;
    private final int winRateThree;
    private final int winRateFour;

    private LottoGameState2(Set<Integer> userNumbers, Set<Integer> computerNumbers, Set<Integer> hits, double wonMoney, int winRateThree, int winRateFour) {
        this.userNumbers = userNumbers;
        this.computerNumbers = computerNumbers;
        this.hits = hits;
        this.wonMoney = wonMoney;
        this.winRateThree = winRateThree;
        this.winRateFour = winRateFour;
    }

    public static LottoGameState2 of(Set<Integer> userNumbers,
                                     Set<Integer> computerNumbers,
                                     Set<Integer> hits,
                                     double wonMoney,
                                     int winRateThree,
                                     int winRateFour) {
        return new LottoGameState2(userNumbers, computerNumbers, hits, wonMoney, winRateThree, winRateFour);
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


    public static final class Builder {
        private Set<Integer> userNumbers;
        private Set<Integer> computerNumbers;
        private Set<Integer> hits;
        private double wonMoney;
        private int winRateThree;
        private int winRateFour;

        private Builder() {
        }

        public static Builder aLottoGameState2() {
            return new Builder();
        }

        public Builder userNumbers(Set<Integer> userNumbers) {
            this.userNumbers = userNumbers;
            return this;
        }

        public Builder computerNumbers(Set<Integer> computerNumbers) {
            this.computerNumbers = computerNumbers;
            return this;
        }

        public Builder hits(Set<Integer> hits) {
            this.hits = hits;
            return this;
        }

        public Builder wonMoney(double wonMoney) {
            this.wonMoney = wonMoney;
            return this;
        }

        public Builder winRateThree(int winRateThree) {
            this.winRateThree = winRateThree;
            return this;
        }

        public Builder winRateFour(int winRateFour) {
            this.winRateFour = winRateFour;
            return this;
        }

        public LottoGameState2 build() {
            return new LottoGameState2(userNumbers, computerNumbers, hits, wonMoney, winRateThree, winRateFour);
        }
    }
}
