package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14938 {

    static int m;
    static Map<Integer, List<int[]>> graph;
    static int[] items;
    static boolean[] visited;
    static int[] minWeight;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        final int r = Integer.parseInt(st.nextToken());

        items = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            final int a = Integer.parseInt(st.nextToken());
            final int b = Integer.parseInt(st.nextToken());
            final int l = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b, l});
            graph.get(b).add(new int[]{a, l});
        }

        int maxItems = 0;
        minWeight = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            Arrays.fill(minWeight, Integer.MAX_VALUE);
            maxItems = Math.max(maxItems, bfs(i));
        }

        bw.write(Integer.toString(maxItems));
        bw.flush();
    }

    private static int bfs(final int region) {
        final Queue<int[]> queue = new PriorityQueue<>((a, b) -> Arrays.compare(a, 1, 2, b, 1, 2));
        queue.offer(new int[]{region, 0});
        int itemCount = 0;
        while (!queue.isEmpty()) {
            final int[] current = queue.poll();
            if (current[1] > m || current[1] > minWeight[current[0]]) {
                continue;
            }
            if (!visited[current[0]]) {
                itemCount += items[current[0]];
            }
            visited[current[0]] = true;
            minWeight[current[0]] = current[1];
            for (int[] next : graph.get(current[0])) {
                queue.offer(new int[]{next[0], current[1] + next[1]});
            }
        }
        return itemCount;
    }
}
