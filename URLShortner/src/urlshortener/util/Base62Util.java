package urlshortener.util;

public class Base62Util {

    private static final String CHARACTERS =
            "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encode(int number) {

        if (number == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        while (number > 0) {

            int remainder = number % 62;
            result.append(CHARACTERS.charAt(remainder));
            number = number / 62;
        }
        return result.reverse().toString();
    }

    public static int decode(String code) {

        int number = 0;

        for (char character : code.toCharArray()) {
            int value = CHARACTERS.indexOf(character);

            if (value == -1) {
                throw new IllegalArgumentException("Invalid short code.");
            }
            number = number * 62 + value;
        }

        return number;
    }
}