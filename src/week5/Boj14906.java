package week5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj14906 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("SLURPYS OUTPUT\n");
        final int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            final String s = br.readLine();
            if (isSlurpy(s)) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.write("END OF OUTPUT\n");
        bw.flush();
    }

    private static boolean isSlurpy(final String s) {
        int lastIndexOfSlimp = Math.max(s.lastIndexOf('C'), s.lastIndexOf('H'));
        if (lastIndexOfSlimp == -1 || lastIndexOfSlimp >= s.length() - 3) {
            return false;
        }
        return isSlimp(s.substring(0, lastIndexOfSlimp + 1)) && isSlump(s.substring(lastIndexOfSlimp + 1));
    }

    private static boolean isSlimp(final String s) {
        if (!s.startsWith("A")) {
            return false;
        }
        if (s.length() == 2) {
            return s.endsWith("H");
        }
        if (!s.endsWith("C")) {
            return false;
        }
        final int b = s.indexOf('B');
        if (b == -1) {
            return isSlump(s.substring(1, s.length() - 1));
        }
        if (b == 1) {
            return isSlimp(s.substring(2, s.length() - 1));
        }
        return false;
    }

    private static boolean isSlump(final String s) {
        if (!s.startsWith("D") && !s.startsWith("E")) {
            return false;
        }
        if (!s.endsWith("G")) {
            return false;
        }
        if (!s.contains("F")) {
            return false;
        }
        int index = 1;
        while (s.charAt(index) == 'F') {
            index++;
        }
        if (index == s.length() - 1) {
            return true;
        }
        return isSlump(s.substring(index));
    }
}
