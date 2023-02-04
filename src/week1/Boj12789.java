package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj12789 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        final StringTokenizer st = new StringTokenizer(br.readLine());
        final Stack<Integer> waitingLine = new Stack<>();

        int order = 1;
        for (int i = 0; i < N; i++) {
            final int ticket = Integer.parseInt(st.nextToken());
            if (ticket != order) {
                waitingLine.push(ticket);
                continue;
            }
            order++;
            while (!waitingLine.isEmpty() && waitingLine.peek() == order) {
                waitingLine.pop();
                order++;
            }
        }

        while (!waitingLine.isEmpty()) {
            if (waitingLine.pop() == order) {
                order++;
            } else {
                System.out.println("Sad");
                return;
            }
        }

        System.out.println("Nice");
    }
}
