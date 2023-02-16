package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj5904 {
    static int N;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int length = 0;
        int k = 0;
        while (true) {
            length = length * 2 + k + 3;
            if (length >= N) {
                break;
            }
            k++;
        }

        bw.write(solution(k + 3, length));
        bw.flush();
    }

    private static String solution(final int centerLength, final int length) {
        if (N == 1 || N == length - 2) {
            return "m";
        }
        if (N < 3 || N == length - 1 || N == length) {
            return "o";
        }

        final int prevLength = (length - centerLength) / 2;
        int m = prevLength + 1;
        int o = m + centerLength - 1;

        if (N == m) {
            return "m";
        }
        if (N <= o && N > m) {
            return "o";
        }
        if (N > o) {
            N -= (centerLength + prevLength);
        }
        return solution(centerLength - 1, prevLength);
    }
}
