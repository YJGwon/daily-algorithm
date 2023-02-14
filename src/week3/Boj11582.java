package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11582 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.parseInt(br.readLine());

        final int[] chickens = new int[N];
        final StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            chickens[i] = Integer.parseInt(st.nextToken());
        }

        final int kDivisor = N / Integer.parseInt(br.readLine());
        int divisor = 2;
        while (kDivisor >= divisor) {
            for (int i = 0; i <= N - divisor; i += divisor) {
                Arrays.sort(chickens, i, i + divisor);
            }
            divisor *= 2;
        }

        for (int i = 0; i < N; i++) {
            bw.write(Integer.toString(chickens[i]));
            if (i < N - 1) {
                bw.write(" ");
            }
        }
        bw.flush();
    }
}
