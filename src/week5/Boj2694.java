package week5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj2694 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int M;
    static int[] sequence;
    static int maxElement;
    static int total;
    static int min;
    static int start;

    public static void main(String[] args) throws IOException {
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            maxElement = 0;
            total = 0;
            min = 0;
            start = 0;
            readSequence();
            if (maxElement > Math.floorDiv(total, 2)) {
                bw.write(Integer.toString(total));
                bw.write("\n");
                continue;
            }
            while (min < maxElement) {
                increaseMin();
            }
            solution(0, 0);
            bw.write(Integer.toString(min));
            bw.write("\n");
        }
        bw.flush();
    }

    private static void readSequence() throws IOException {
        M = Integer.parseInt(br.readLine());
        sequence = new int[M];

        StringTokenizer st;
        for (int i = 0; i < Math.floorDiv(M, 10); i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = i * 10; j < (i + 1) * 10; j++) {
                readNumber(st.nextToken(), j);
            }
        }
        if (M % 10 > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = M - (M % 10); i < M; i++) {
                readNumber(st.nextToken(), i);
            }
        }
    }

    private static void readNumber(final String rawNumber, final int index) {
        final int n = Integer.parseInt(rawNumber);
        sequence[index] = n;
        maxElement = Math.max(maxElement, n);
        total += n;
    }

    private static void solution(int index, int sum) {
        if (min == total) {
            return;
        }

        if (index == M) {
            if (sum != 0) {
                increaseMin();
                solution(start, 0);
            }
            return;
        }

        if (sequence[index] + sum > min) {
            increaseMin();
            solution(start, 0);
            return;
        }
        if (sequence[index] + sum == min) {
            solution(index + 1, 0);
        } else {
            solution(index + 1, sum + sequence[index]);
        }
    }

    private static void increaseMin() {
        min += sequence[start];
        start++;
        if (min > Math.floorDiv(total, 2)) {
            min = total;
            return;
        }
        if (total % min != 0) {
            increaseMin();
        }
    }
}
