package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj22941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int heroHP = Integer.parseInt(st.nextToken());
        int heroATK = Integer.parseInt(st.nextToken());
        long enemyHP = Integer.parseInt(st.nextToken());
        int enemyATK = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        long remaining = enemyHP % heroATK;
        if ((remaining >= 1 && remaining <= P) || (remaining == 0 && heroATK <= P)) {
            enemyHP += S;
        }

        final double heroDefenceCount = Math.ceil(heroHP / (double) enemyATK);
        final double enemyDefenceCount = Math.ceil(enemyHP / (double) heroATK);

        if (enemyDefenceCount <= heroDefenceCount) {
            System.out.println("Victory!");
        } else {
            System.out.println("gg");
        }
    }
}
