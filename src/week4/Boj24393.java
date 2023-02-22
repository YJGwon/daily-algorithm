package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj24393 {

    static StringTokenizer st;
    static int joker = 1;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            move(joker <= 13);
        }
        bw.write(Integer.toString(joker));
        bw.flush();
    }

    private static void move(final boolean isLeft) {
        int total = 0;
        int jokerInDeck = joker;
        if (isLeft) {
            total = Integer.parseInt(st.nextToken());
        } else {
            jokerInDeck -= 13;
        }
        int moved = 0;
        int i = 1;
        while (total <= 27) {
            final int a = Integer.parseInt(st.nextToken());
            if (i % 2 == 1) {
                if (moved + a >= jokerInDeck) {
                    joker = total + jokerInDeck - moved;
                    return;
                }
                moved += a;
            }
            total += a;
            i++;
        }
    }
}
