package lotto.domain.rating;

import java.util.Objects;

public class LottoResult {
    private final int matchedCount;
    private final boolean isSecond;
    private static final int SECOND_MATCHED_COUNT = 5;

    public LottoResult(int matchedCount, boolean hasBonusBall) {
        this.matchedCount = matchedCount;
        boolean isSecond = false;
        if (matchedCount == SECOND_MATCHED_COUNT) {
            isSecond = hasBonusBall;
        }
        this.isSecond = isSecond;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public boolean isSecond() {
        return isSecond;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return matchedCount == that.matchedCount && isSecond == that.isSecond;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchedCount, isSecond);
    }
}