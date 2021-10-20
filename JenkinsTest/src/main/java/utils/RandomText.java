package utils;

import java.util.Random;

public class RandomText {
    private static final String KeyGen = "abXY12";
    private static Random random = new Random();

    public static String generateString(int length)
    {
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = KeyGen.charAt(random.nextInt(KeyGen.length()));
        }
        return new String(text);
    }
}