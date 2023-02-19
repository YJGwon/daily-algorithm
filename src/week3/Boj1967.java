package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1967 {

    static HashMap<Integer, List<int[]>> graph;
    static boolean[] visited;
    static int maxWeight = 0;
    static int maxNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        graph = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.putIfAbsent(p, new ArrayList<>());
            graph.putIfAbsent(c, new ArrayList<>());
            graph.get(p).add(new int[] {c, w});
            graph.get(c).add(new int[] {p, w});
        }

        visited = new boolean[n + 1];
        dfs(1, 0);
        visited = new boolean[n + 1];
        dfs(maxNode, 0);

        bw.write(Integer.toString(maxWeight));
        bw.flush();
    }

    private static void dfs(int node, int weight) {
        visited[node] = true;

        if (maxWeight < weight) {
            maxWeight = weight;
            maxNode = node;
        }

        List<int[]> edges = graph.get(node);
        if (edges == null) {
            return;
        }
        for (int[] edge : edges) {
            if (!visited[edge[0]]) {
                dfs(edge[0], weight + edge[1]);
            }
        }
    }
}
