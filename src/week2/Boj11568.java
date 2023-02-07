package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11568 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine());

        final int[] picked = new int[N];
        int first = Integer.parseInt(st.nextToken());
        picked[0] = first;

        int count = 1;
        for (int i = 1; i < N; i++) {
            int element = Integer.parseInt(st.nextToken());
            if (picked[count - 1] < element) {
                picked[count] = element;
                count++;
                continue;
            }
            for (int j = 0; j < count; j++) {
                if (picked[j] >= element) {
                    picked[j] = element;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
