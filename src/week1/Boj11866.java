package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj11866 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        final LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int target = k - 1;

        bw.write("<");
        while (true) {
            bw.write(String.valueOf(queue.remove(target)));
            if (queue.isEmpty()) {
                break;
            }
            bw.write(", ");
            target = target + k - 1;
            if (target >= queue.size()) {
                target = target % queue.size();
            }
        }
        bw.write(">");

        bw.flush();
    }
}
