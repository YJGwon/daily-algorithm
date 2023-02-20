package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj14657 {

    static Map<Integer, List<int[]>> graph = new HashMap<>();
    static boolean[] visited;
    static int maxCount = 0;
    static int maxNode = 0;
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final double T = Double.parseDouble(st.nextToken());

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            final int A = Integer.parseInt(st.nextToken());
            final int B = Integer.parseInt(st.nextToken());
            final int C = Integer.parseInt(st.nextToken());
            graph.get(A).add(new int[]{B, C});
            graph.get(B).add(new int[]{A, C});
        }

        visited = new boolean[N + 1];
        dfs(1, 0, 0);

        visited = new boolean[N + 1];
        dfs(maxNode, 0, 0);

        final double a = minTime / T;
        bw.write(Integer.toString((int) Math.ceil(a)));
        bw.flush();
    }

    private static void dfs(final int root, final int count, final int time) {
        visited[root] = true;

        if (count > maxCount || (count == maxCount && minTime > time)) {
            maxCount = count;
            maxNode = root;
            minTime = time;
        }

        final List<int[]> nodes = graph.get(root);
        for (int[] node : nodes) {
            if (!visited[node[0]]) {
                dfs(node[0], count + 1, time + node[1]);
            }
        }
    }
}
