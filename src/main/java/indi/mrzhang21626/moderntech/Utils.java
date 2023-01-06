package indi.mrzhang21626.moderntech;

public class Utils {
    public static String toCapture(String str) {
        char[] c = str.toCharArray();
        c[0] -= 32;
        return String.valueOf(c);
    }
}
