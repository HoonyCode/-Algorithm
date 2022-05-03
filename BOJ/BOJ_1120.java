package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1120 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");

        char[] A = in[0].toCharArray();

        char[] B = in[1].toCharArray();


        int lenB = B.length;
        int lenA = A.length;

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= lenB - lenA; i++) {

            int idx = 0;
            int cnt = 0;

            while (idx < lenA) {
                if (A[idx] != B[i + idx]) cnt++;
                idx++;
            }
            answer = Math.min(answer, cnt);
        }
        System.out.println(answer);
    }

}
