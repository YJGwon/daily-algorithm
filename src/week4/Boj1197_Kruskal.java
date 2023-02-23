package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1197_Kruskal {

    static int[] roots;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        final int V = Integer.parseInt(st.nextToken());
        final int E = Integer.parseInt(st.nextToken());

        final Queue<Edge> queue = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            final int A = Integer.parseInt(st.nextToken());
            final int B = Integer.parseInt(st.nextToken());
            final int weight = Integer.parseInt(st.nextToken());
            queue.offer(new Edge(A, B, weight));
        }

        roots = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            roots[i] = i;
        }

        int count = 0;
        int answer = 0;
        while (count < V - 1) {
            final Edge edge = queue.poll();
            final int rootA = findRoot(edge.A);
            final int rootB = findRoot(edge.B);
            if (rootA != rootB) {
                roots[rootB] = rootA;
                answer += edge.weight;
                count++;
            }
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }

    private static int findRoot(final int vertex) {
        if (roots[vertex] == vertex) {
            return vertex;
        }
        return roots[vertex] = findRoot(roots[vertex]);
    }

    private static class Edge implements Comparable<Edge> {
        int A;
        int B;
        int weight;

        Edge(final int a, final int b, final int weight) {
            A = a;
            B = b;
            this.weight = weight;
        }

        @Override
        public int compareTo(final Edge o) {
            return this.weight - o.weight;
        }
    }
}
