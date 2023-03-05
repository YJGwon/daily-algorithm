package week5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj3865 {

    static Map<String, Set<String>> map;
    static Set<String> counted;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            final int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            String firstAcademy = "";
            map = new HashMap<>();
            counted = new HashSet<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), ":,.");
                final String academy = st.nextToken();
                if (i == 0) {
                    firstAcademy = academy;
                }
                map.put(academy, new HashSet<>());
                while (st.hasMoreTokens()) {
                    map.get(academy).add(st.nextToken());
                }
            }

            bw.write(Integer.toString(countMembers(firstAcademy)));
            bw.write("\n");
        }
        bw.flush();
    }

    private static int countMembers(final String academy) {
        int count = 0;
        for (String name : map.get(academy)) {
            if (counted.contains(name)) {
                continue;
            }
            if (map.containsKey(name)) {
                count += countMembers(name);
            } else {
                count++;
            }
            counted.add(name);
        }
        return count;
    }
}
