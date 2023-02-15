package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj20922 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        final int[] sequence = new int[N];
        final int[] count = new int[100_001];
        int start = 0;
        int temp = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            final int n = Integer.parseInt(st.nextToken());
            sequence[i] = n;
            count[n]++;
            temp++;
            if (count[n] > K) {
                while (count[n] > K) {
                    count[sequence[start]]--;
                    start++;
                    temp--;
                }
            } else {
                max = Math.max(temp, max);
            }
        }
        bw.write(Integer.toString(max));
        bw.flush();
    }
}
