package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1254 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String s = br.readLine();
        final int length = s.length();

        for (int i = 0; i < length; i++) {
            int j = 0;
            while (2 * j + i < length) {
                if (s.charAt(i + j) != s.charAt(length - j - 1)) {
                    break;
                }
                j++;
            }
            if (2 * j + i >= length) {
                System.out.println(length + i);
                return;
            }
        }
    }
}
