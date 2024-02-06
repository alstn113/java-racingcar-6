package racingcar.domain;

import racingcar.domain.generator.NumberGenerator;
import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public class RacingCar {
    public static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_FORWARD_NUMBER = 4;

    private final String name;
    private int position = 0;
    private final NumberGenerator generator;

    public RacingCar(String name, NumberGenerator generator) {
        validateNameLength(name);
        this.name = name;
        this.generator = generator;
    }

    private void validateNameLength(String name) {
        if (name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new InvalidInputException(ErrorMessage.INVALID_CAR_NAME_LENGTH);
        }
    }

    public void moveOrStop() {
        if (generator.generate() >= MOVE_FORWARD_NUMBER) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
