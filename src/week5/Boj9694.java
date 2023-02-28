package week5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj9694 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        final int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            final int N = Integer.parseInt(st.nextToken());
            final int M = Integer.parseInt(st.nextToken());

            final Map<Integer, List<int[]>> graph = new HashMap<>();
            for (int i = 0; i < M; i++) {
                graph.put(i, new ArrayList<>());
            }
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                final int x = Integer.parseInt(st.nextToken());
                final int y = Integer.parseInt(st.nextToken());
                final int z = Integer.parseInt(st.nextToken());
                graph.get(x).add(new int[]{y, z});
                graph.get(y).add(new int[]{x, z});
            }

            final int[] minWeight = new int[M];
            Arrays.fill(minWeight, Integer.MAX_VALUE);
            final int[] before = new int[M];
            Arrays.fill(before, -1);
            final boolean[] visited = new boolean[M];

            final Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(array -> array[1]));
            queue.offer(new int[]{0, 0});
            while (!queue.isEmpty()) {
                final int[] current = queue.poll();
                if (visited[current[0]]) {
                    continue;
                }
                visited[current[0]] = true;

                if (current[0] == M - 1) {
                    break;
                }
                for (int[] next : graph.get(current[0])) {
                    if (minWeight[next[0]] < current[1] + next[1]) {
                        continue;
                    }
                    minWeight[next[0]] = current[1] + next[1];
                    before[next[0]] = current[0];
                    queue.offer(new int[]{next[0], current[1] + next[1]});
                }
            }

            bw.write("Case #");
            bw.write(Integer.toString(t));
            bw.write(":");

            if (before[M - 1] == -1) {
                bw.write(" -1\n");
                continue;
            }

            final Stack<Integer> result = new Stack<>();
            int node = M - 1;
            result.push(node);
            while (node != 0) {
                node = before[node];
                result.push(node);
            }
            while (!result.isEmpty()) {
                bw.write(" ");
                bw.write(Integer.toString(result.pop()));
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
