package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj13905 {

    static int s;
    static int e;
    static Map<Integer, List<int[]>> map;
    static int[] max;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            final int h1 = Integer.parseInt(st.nextToken());
            final int h2 = Integer.parseInt(st.nextToken());
            final int k = Integer.parseInt(st.nextToken());
            map.get(h1).add(new int[]{h2, k});
            map.get(h2).add(new int[]{h1, k});
        }

        max = new int[N + 1];
        bfs();
        bw.write(Integer.toString(max[e]));
        bw.flush();
    }

    private static void bfs() {
        final Queue<int[]> queue = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(a -> a[1])));
        queue.offer(new int[]{s, 1000001});
        while (!queue.isEmpty()) {
            final int[] home = queue.poll();
            if (home[0] == e) {
                continue;
            }
            for (int[] bridge : map.get(home[0])) {
                final int weight = Math.min(home[1], bridge[1]);
                if (max[bridge[0]] < weight) {
                    max[bridge[0]] = weight;
                    queue.offer(new int[]{bridge[0], weight});
                }
            }
        }
    }
}
