package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj24229 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        final List<int[]> boards = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            final int r = Integer.parseInt(st.nextToken());
            final int l = Integer.parseInt(st.nextToken());
            boards.add(new int[]{r, l});
        }

        boards.sort(Comparator.comparingInt(it -> it[0]));
        final Map<Integer, Integer> mappedBoards = new TreeMap<>();
        int prevR = 0;
        int prevL = -1;
        for (int[] board : boards) {
            if (board[0] <= prevL) {
                final int l = Math.max(board[1], prevL);
                mappedBoards.put(prevR, l);
                prevL = l;
            } else {
                mappedBoards.put(board[0], board[1]);
                prevR = board[0];
                prevL = board[1];
            }
        }

        int reachable = 0;
        int max = 0;
        for (Integer boardR : mappedBoards.keySet()) {
            if (boardR <= reachable) {
                final Integer boardL = mappedBoards.get(boardR);
                reachable = Math.max(reachable, boardL * 2 - boardR);
                max = boardL;
            } else {
                break;
            }
        }
        bw.write(Integer.toString(max));
        bw.flush();
    }
}
