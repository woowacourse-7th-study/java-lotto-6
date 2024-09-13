package lotto.validator;

import java.util.Arrays;

import static lotto.constants.ErrorMessage.ENTER_INTEGER;
import static lotto.constants.ErrorMessage.ENTER_NUMBERS_WITH_COMMA;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_WHITESPACE;
import static lotto.constants.Symbol.COMMA;

public class UserInputValidator {
    private UserInputValidator() {
    }

    public static void validateStrip(final String input) {
        String stripped = input.strip();
        if (input.equals(stripped)) {
            return;
        }
        throw new IllegalArgumentException(NOT_ALLOWED_WHITESPACE.toString());
    }

    public static void validateInteger(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ENTER_INTEGER.toString());
        }
    }

    public static void validateInteger(final String[] numbers) {
        try {
            Arrays.stream(numbers)
                    .forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ENTER_INTEGER.toString());
        }
    }

    public static void validateComma(final String input) {
        if (input.contains(COMMA.toString())) {
            return;
        }
        throw new IllegalArgumentException(ENTER_NUMBERS_WITH_COMMA.toString());
    }
}
