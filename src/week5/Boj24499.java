package week5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj24499 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        final int[] pies = new int[N];
        for (int i = 0; i < N; i++) {
            pies[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += pies[i];
        }
        int max = sum;
        for (int i = 1; i < N; i++) {
            sum -= pies[i - 1];
            sum += pies[(i + K - 1) % N];
            max = Math.max(sum, max);
        }
        bw.write(Integer.toString(max));
        bw.flush();
    }
}
