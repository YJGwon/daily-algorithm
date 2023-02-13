package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj21938 {

    static int N;
    static int M;
    static int T;
    static int[][] pixels;
    static boolean[][] visited;
    final static int[] moveN = {1, -1, 0, 0};
    final static int[] moveM = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pixels = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                pixels[i][j] = Integer.parseInt(st.nextToken())
                        + Integer.parseInt(st.nextToken())
                        + Integer.parseInt(st.nextToken());
            }
        }

        T = Integer.parseInt(br.readLine()) * 3;

        visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] || pixels[i][j] < T) {
                    continue;
                }
                dfs(i, j);
                count++;
            }
        }
        bw.write(Integer.toString(count));
        bw.flush();
    }

    private static void dfs(int n, int m) {
        visited[n][m] = true;
        int nextN;
        int nextM;
        for (int i = 0; i < 4; i++) {
            nextN = n + moveN[i];
            nextM = m + moveM[i];
            if (nextN >= N || nextM >= M || nextN < 0 || nextM < 0) {
                continue;
            }
            if (visited[nextN][nextM] || pixels[nextN][nextM] < T) {
                continue;
            }
            dfs(nextN, nextM);
        }
    }
}
