package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj25391 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        final Map<Integer, Integer> candidates = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            final int a = Integer.parseInt(st.nextToken());
            final int b = Integer.parseInt(st.nextToken());
            candidates.put(b, a);
        }

        long answer = 0;
        int count = 0;
        final PriorityQueue<Integer> specialCandidates = new PriorityQueue<>(Comparator.reverseOrder());
        for (Integer b : candidates.keySet()) {
            if (count < K) {
                answer += candidates.get(b);
                count++;
            } else {
                specialCandidates.offer(candidates.get(b));
            }
        }

        for (int i = 0; i < M; i++) {
            answer += specialCandidates.poll();
        }

        bw.write(Long.toString(answer));
        bw.flush();
    }
}
