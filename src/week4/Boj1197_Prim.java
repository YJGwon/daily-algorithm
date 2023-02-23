package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1197_Prim {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        final int V = Integer.parseInt(st.nextToken());
        final int E = Integer.parseInt(st.nextToken());

        final Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= V; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            final int A = Integer.parseInt(st.nextToken());
            final int B = Integer.parseInt(st.nextToken());
            final int weight = Integer.parseInt(st.nextToken());
            graph.get(A).add(new int[]{B, weight});
            graph.get(B).add(new int[]{A, weight});
        }

        final Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int count = 0;
        final boolean[] visited = new boolean[V + 1];

        for (int[] edge : graph.get(1)) {
            queue.offer(edge);
        }
        visited[1] = true;

        int answer = 0;
        while (count < V - 1) {
            final int[] edge = queue.poll();
            if (visited[edge[0]]) {
                continue;
            }
            answer += edge[1];
            visited[edge[0]] = true;
            count++;
            for (int[] next : graph.get(edge[0])) {
                if (visited[next[0]]) {
                    continue;
                }
                queue.offer(next);
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }
}
