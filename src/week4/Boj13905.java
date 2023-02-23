package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj13905 {

    static int[] roots;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        final int s = Integer.parseInt(st.nextToken());
        final int e = Integer.parseInt(st.nextToken());

        final Queue<Bridge> queue = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            final int h1 = Integer.parseInt(st.nextToken());
            final int h2 = Integer.parseInt(st.nextToken());
            final int k = Integer.parseInt(st.nextToken());
            queue.offer(new Bridge(h1, h2, k));
        }

        roots = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            roots[i] = i;
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            final Bridge bridge = queue.poll();
            final int root1 = findRoot(bridge.h1);
            final int root2 = findRoot(bridge.h2);
            if (root1 != root2) {
                roots[root2] = root1;
                if (findRoot(s) == findRoot(e)) {
                    answer = bridge.k;
                    break;
                }
            }
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }

    private static int findRoot(final int h) {
        if (roots[h] == h) {
            return h;
        }
        return roots[h] = findRoot(roots[h]);
    }

    private static class Bridge implements Comparable<Bridge> {
        int h1;
        int h2;
        int k;

        Bridge(final int h1, final int h2, final int k) {
            this.h1 = h1;
            this.h2 = h2;
            this.k = k;
        }

        @Override
        public int compareTo(Bridge o) {
            return o.k - this.k;
        }
    }
}
