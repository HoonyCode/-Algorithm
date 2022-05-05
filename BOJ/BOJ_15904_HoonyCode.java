package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15904_HoonyCode {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chars = br.readLine().toCharArray();


        int cnt = 0;
        for (int i = 0; i < chars.length; i++) {

            if (cnt == 4) break;

            if (cnt == 0) {
                if (chars[i] == 'U') {
                    cnt++;
                    continue;
                }
            } else if (cnt == 1) {
                if (chars[i] == 'C') {
                    cnt++;
                    continue;
                }

            } else if (cnt == 2) {
                if (chars[i] == 'P') {
                    cnt++;
                    continue;
                }
            } else {
                if (chars[i] == 'C') {
                    cnt++;
                    continue;
                }
            }
        }

        if (cnt == 4) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }

    }
}
