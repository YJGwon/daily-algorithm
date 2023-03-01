package week5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj10258 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++) {
            final String rawBits = br.readLine();
            int count = 0;
            char current = '0';
            for (int i = 0; i < rawBits.length(); i++) {
                if (rawBits.charAt(i) != current) {
                    count += Math.pow(2, rawBits.length() - i - 1);
                    current = '1';
                } else {
                    current = '0';
                }
            }
            bw.write(Integer.toString(count));
            bw.write("\n");
        }
        bw.flush();
    }
}
