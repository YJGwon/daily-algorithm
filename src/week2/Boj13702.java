package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj13702 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        final int[] kettles = new int[N];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            kettles[i] = Integer.parseInt(br.readLine());
            sum += kettles[i];
        }

        long max = sum / K;
        long min = 0;
        while (min <= max) {
            if (max == 0) {
                System.out.println(0);
                return;
            }

            long middle = (max + min) / 2;
            if (max == 1) {
                middle = 1;
            }
            int count = 0;
            for (int kettle : kettles) {
                count += kettle / middle;
            }

            if (count >= K) {
                min = middle + 1;
            } else {
                max = middle - 1;
            }
        }

        System.out.println(max);
    }

}
