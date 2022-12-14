package ir.maktab74.util;

import java.util.Random;

public class RandomUtil {

    private static final Random random = new Random();

    public static String getRandomNumeric(int length) {
        int start = 48;
        int end = 57;
        String code = "";
        while (code.length() != length) {
            code = code.concat(
                    String.valueOf(
                            (char) random.nextInt(end - start) + start
                    )
            );
        }
        return code;
    }

}
