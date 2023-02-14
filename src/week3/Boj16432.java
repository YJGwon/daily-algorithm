package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj16432 {

    static int N;
    static boolean[][] donghee;
    static int[] tiger;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        donghee = new boolean[N][10];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < Integer.parseInt(st.nextToken()); j++) {
                donghee[i][Integer.parseInt(st.nextToken())] = true;
            }
        }

        tiger = new int[N];
        dfs(0, 0);
        if (tiger[N - 1] == 0) {
            bw.write("-1");
        } else {
            for (int i = 0; i < N; i++) {
                bw.write(Integer.toString(tiger[i]));
                bw.write("\n");
            }
        }
        bw.flush();
    }

    private static void dfs(int day, int yesterday) {
        if (day < 0 || day >= N) {
            return;
        }
        for (int j = 1; j <= 9; j++) {
            if (donghee[day][j] && j != yesterday) {
                tiger[day] = j;
                donghee[day][j] = false;
                dfs(day + 1, j);
                return;
            }
        }
        if (day < 2) {
            dfs(day - 1, 0);
        } else {
            dfs(day - 1, tiger[day - 2]);
        }
    }
}
