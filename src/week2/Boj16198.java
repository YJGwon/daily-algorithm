package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj16198 {

    static int N;
    static int[] energy;
    static boolean[] visited;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine());

        energy = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            energy[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N - 1; i++) {
            visited[i] = true;
            dfs(i, 0, 0);
            visited[i] = false;
        }
        bw.write(String.valueOf(max + energy[0] * energy[N - 1]));
        bw.flush();
    }

    private static void dfs(int index, int sum, int count) {
        if (count == N - 3) {
            max = Math.max(sum, max);
            return;
        }

        int left = index - 1;
        int right = index + 1;
        while (visited[left]) {
            left--;
        }
        while (visited[right]) {
            right++;
        }

        for (int i = 1; i < N - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, sum + energy[left] * energy[right], count + 1);
                visited[i] = false;
            }
        }
    }
}
