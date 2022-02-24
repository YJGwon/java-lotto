package lotto;

import java.util.List;

public class PrizeInformation {
    private final Prize prize;
    private final int count;

    //todo: public -> private
    public PrizeInformation(Prize prize, int count) {
        this.prize = prize;
        this.count = count;
    }

    public static PrizeInformation of(List<MatchResult> matchResults, Prize prize) {
        int count = (int) matchResults.stream()
                .filter(matchResult -> Prize.getPrize(matchResult) == prize)
                .count();
        return new PrizeInformation(prize, count);
    }

    public int pickAmount() {
        return this.prize.pickAmount(count);
    }
}
