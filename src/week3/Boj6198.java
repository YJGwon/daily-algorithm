package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Boj6198 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> H = new Stack<>();
        long count = 0;
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            while (!H.isEmpty() && H.peek() <= h) {
                H.pop();
            }
            count += H.size();
            H.push(h);
        }
        bw.write(Long.toString(count));
        bw.flush();
    }
}
