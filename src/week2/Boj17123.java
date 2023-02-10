package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Boj17123 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringJoiner sj;

        final int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            final int N = Integer.parseInt(st.nextToken());
            final int M = Integer.parseInt(st.nextToken());

            int[][] sum = new int[N][2];
            for (int n1 = 0; n1 < N; n1++) {
                st = new StringTokenizer(br.readLine());
                for (int n2 = 0; n2 < N; n2++) {
                    final int element = Integer.parseInt(st.nextToken());
                    sum[n1][0] += element;
                    sum[n2][1] += element;
                }
            }

            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                final int r1 = Integer.parseInt(st.nextToken());
                final int c1 = Integer.parseInt(st.nextToken());
                final int r2 = Integer.parseInt(st.nextToken());
                final int c2 = Integer.parseInt(st.nextToken());
                final int v = Integer.parseInt(st.nextToken());

                int add = v * (c2 - c1 + 1);
                for (int i = r1 - 1; i < r2; i++) {
                    sum[i][0] += add;
                }

                add = v * (r2 - r1 + 1);
                for (int i = c1 - 1; i < c2; i++) {
                    sum[i][1] += add;
                }
            }

            for (int i = 0; i < 2; i++) {
                sj = new StringJoiner(" ");
                for (int j = 0; j < N; j++) {
                    sj.add(String.valueOf(sum[j][i]));
                }
                bw.write(sj.toString());
                bw.write("\n");
            }
        }
        bw.flush();
    }
}
