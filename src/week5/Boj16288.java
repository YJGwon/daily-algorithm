package week5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj16288 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int k = Integer.parseInt(st.nextToken());

        final int[] ports = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            final int n = Integer.parseInt(st.nextToken());
            int port = -1;
            int max = -1;
            for (int j = 0; j < k; j++) {
                if (ports[j] < n && ports[j] > max) {
                    max = ports[j];
                    port = j;
                }
            }
            if (port == -1) {
                bw.write("NO");
                bw.flush();
                return;
            }
            ports[port] = n;
        }
        bw.write("YES");
        bw.flush();
    }
}
