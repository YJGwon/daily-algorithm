package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Boj25391 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        final List<int[]> candidates = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            candidates.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        long answer = 0;
        candidates.sort(Collections.reverseOrder(Comparator.comparingInt(a -> a[1])));
        for (int i = 0; i < K; i++) {
            answer += candidates.get(i)[0];
        }

        final List<int[]> specialCandidates = candidates.subList(K, N);
        specialCandidates.sort(Collections.reverseOrder(Comparator.comparingInt(a -> a[0])));
        for (int i = 0; i < M; i++) {
            answer += specialCandidates.get(i)[0];
        }

        bw.write(Long.toString(answer));
        bw.flush();
    }
}
