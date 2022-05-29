package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_나누기_HoonyCode {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        N = N / 100;
        int start = N * 100;
        int end = (N + 1) * 100;

        int answer = -1;

        for (int i = start; i < end; i++) {
            if (i % F == 0) {
                answer = i % 100;
                break;
            }
        }

        System.out.printf("%02d", answer);
    }
}
