package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj18232 {

    static int S;
    static int E;
    static HashMap<Integer, Set<Integer>> teleports = new HashMap<>();
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 2; i < N; i++) {
            teleports.put(i, new HashSet<>());
            teleports.get(i).add(i - 1);
            teleports.get(i).add(i + 1);
        }
        teleports.put(1, new HashSet<>());
        teleports.get(1).add(2);
        teleports.put(N, new HashSet<>());
        teleports.get(N).add(N - 1);

        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            final int x = Integer.parseInt(st.nextToken());
            final int y = Integer.parseInt(st.nextToken());
            teleports.get(x).add(y);
            teleports.get(y).add(x);
        }

        bw.write(Integer.toString(bfs()));
        bw.flush();
    }

    private static int bfs() {
        queue.add(S);
        int sec = 0;
        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                final int port = queue.poll();
                if (port == E) {
                    return sec;
                }
                addNext(port);
            }
            sec++;
        }
        return sec;
    }

    private static void addNext(int port) {
        for (int connectedPort : teleports.get(port)) {
            if (visited[connectedPort]) {
                continue;
            }
            visited[connectedPort] = true;
            queue.add(connectedPort);
        }
    }
}
