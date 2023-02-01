package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj10814 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        final int n = Integer.parseInt(br.readLine());
        final StringBuilder[] memory = new StringBuilder[200];
        for (int i = 0; i < n; i++) {
            final String line = br.readLine();
            st = new StringTokenizer(line);
            final int age = Integer.parseInt(st.nextToken());

            final int index = age - 1;
            if (memory[index] == null) {
                memory[index] = new StringBuilder();
            }
            memory[index].append(line).append("\n");
        }

        for (StringBuilder line : memory) {
            if (line != null) {
                bw.write(line.toString());
            }
        }

        bw.flush();
    }
}
