package racingcar.exception;

import racingcar.domain.RacingCar;

public enum ErrorMessage {
    INPUT_NOT_A_NUMBER("입력값은 숫자여야 합니다."),
    INVALID_RACE_COUNT("시도 횟수는 1이상이어야 합니다."),

    INVALID_CAR_NAME_LENGTH(String.format("자동차 이름은 %d이하여야 합니다.", RacingCar.MAX_NAME_LENGTH));

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
