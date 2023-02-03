package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj17362 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final int result = n % 8;
        if (result == 6) {
            System.out.println("4");
        } else if (result == 7) {
            System.out.println("3");
        } else if (result == 0) {
            System.out.println("2");
        } else {
            System.out.println(result);
        }
    }
}
