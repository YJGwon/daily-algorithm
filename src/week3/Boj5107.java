package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Boj5107 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 1;
        HashSet<String> names;
        while (N != 0) {
            int chain = 0;
            names = new HashSet<>();
            for (int i = 0; i < N; i++) {
                final String[] pair = br.readLine().split(" ");
                if (names.contains(pair[0]) && names.contains(pair[1])) {
                    chain++;
                }
                names.add(pair[0]);
                names.add(pair[1]);
            }
            bw.write(Integer.toString(count));
            bw.write(" ");
            bw.write(Integer.toString(chain));
            bw.write("\n");
            count++;
            N = Integer.parseInt(br.readLine());
        }
        bw.flush();
    }
}
