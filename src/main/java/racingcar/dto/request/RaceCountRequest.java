package racingcar.dto.request;

import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;
import racingcar.view.util.InputUtil;

public record RaceCountRequest(String input) {
    private static final int MIN_COUNT = 1;

    public int toInt() {
        int count = InputUtil.parseToInt(input);
        if (count < MIN_COUNT) {
            throw new InvalidInputException(ErrorMessage.INVALID_RACE_COUNT);
        }
        return count;
    }
}
