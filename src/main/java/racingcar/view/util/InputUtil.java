package racingcar.view.util;

import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public class InputUtil {
    private static final String COMMA = ",";

    private InputUtil() {
    }

    public static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new InvalidInputException(ErrorMessage.INPUT_NOT_A_NUMBER);
        }
    }

    public static String[] splitByComma(String input) {
        return input.split(COMMA, -1);
    }
}
