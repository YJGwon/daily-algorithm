package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj23827 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine());

        final int[] sequence = new int[N];
        long total = 0;
        for (int i = 0; i < N; i++) {
            final int element = Integer.parseInt(st.nextToken());
            sequence[i] = element;
            total += element;
        }

        long remainder = 0;
        for (int i = 0; i < N; i++) {
            final int element = sequence[i];
            total -= element;
            remainder += (element * total % 1_000_000_007);
        }
        System.out.println(remainder % 1_000_000_007);
    }
}
