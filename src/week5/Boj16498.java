package week5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj16498 {

    static StringTokenizer st;
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Card> cards = new PriorityQueue<>(Comparator.comparingInt(o -> o.score));

    public static void main(String[] args) throws IOException {
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        final int A = Integer.parseInt(st.nextToken());
        final int B = Integer.parseInt(st.nextToken());
        final int C = Integer.parseInt(st.nextToken());

        readCards(A, 0);
        readCards(B, 1);
        readCards(C, 2);

        final int[] pickedCards = new int[3];
        Arrays.fill(pickedCards, 100_000_001);
        int answer = Integer.MAX_VALUE;
        while (!cards.isEmpty()) {
            final Card card = cards.poll();
            pickedCards[card.player] = card.score;
            if (pickedCards[0] == 100_000_001 || pickedCards[1] == 100_000_001 || pickedCards[2] == 100_000_001) {
                continue;
            }
            final int min = Math.min(pickedCards[0], Math.min(pickedCards[1], pickedCards[2]));
            final int max = Math.max(pickedCards[0], Math.max(pickedCards[1], pickedCards[2]));
            answer = Math.min(max - min, answer);
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }

    private static void readCards(final int count, final int player) throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            cards.add(new Card(player, Integer.parseInt(st.nextToken())));
        }
    }

    private static class Card {

        int player;
        int score;

        Card(final int player, final int score) {
            this.player = player;
            this.score = score;
        }
    }
}
