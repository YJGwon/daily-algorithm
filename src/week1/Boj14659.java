package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj14659 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        final int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int dealer = Integer.parseInt(st.nextToken());
        int count = 0;
        int maxCount = 0;
        for (int i = 1; i < n; i++) {
            int peek = Integer.parseInt(st.nextToken());
            if (peek > dealer) {
                maxCount = Math.max(count, maxCount);
                dealer = peek;
                count = 0;
            } else {
                count++;
            }
        }
        maxCount = Math.max(count, maxCount);

        bw.write(maxCount + "");
        bw.flush();
    }
}
