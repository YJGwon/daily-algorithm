package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj4796 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int L;
        int P;
        int V;
        int count = 1;
        int result;

        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            if (L == 0) {
                break;
            }
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            result = (V / P * L) + Math.min(V % P, L);
            sb.append("Case ")
                    .append(count)
                    .append(": ")
                    .append(result)
                    .append("\n");
            count++;
        }
        sb.delete(sb.lastIndexOf("\n"), sb.length());

        bw.write(sb.toString());
        bw.flush();
    }
}
