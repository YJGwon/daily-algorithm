package week5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

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

        readCards(A, 'a');
        readCards(B, 'b');
        readCards(C, 'c');

        final HashMap<Character, Integer> pickedCards = new HashMap<>();
        TreeSet<Integer> pickedScores;
        int answer = Integer.MAX_VALUE;
        while (!cards.isEmpty()) {
            final Card card = cards.poll();
            pickedCards.put(card.player, card.score);
            if (pickedCards.size() < 3) {
                continue;
            }
            pickedScores = new TreeSet<>(pickedCards.values());
            answer = Math.min(pickedScores.last() - pickedScores.first(), answer);
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }

    private static void readCards(final int count, final char player) throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            cards.add(new Card(player, Integer.parseInt(st.nextToken())));
        }
    }

    private static class Card {

        char player;
        int score;

        Card(final char player, final int score) {
            this.player = player;
            this.score = score;
        }
    }
}
