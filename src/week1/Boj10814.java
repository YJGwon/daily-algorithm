package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj10814 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        final int n = Integer.parseInt(br.readLine());
        final TreeMap<Integer, List<String>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            final int age = Integer.parseInt(st.nextToken());
            final String name = st.nextToken();
            map.putIfAbsent(age, new ArrayList<>());
            map.get(age).add(name);
        }

        for (Entry<Integer, List<String>> entry : map.entrySet()) {
            final Integer age = entry.getKey();
            for (String name : entry.getValue()) {
                bw.write(age + " " + name + "\n");
            }
        }

        bw.flush();
    }
}
