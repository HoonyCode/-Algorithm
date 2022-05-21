package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_동전0_HoonyCode {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, K;

        String[] in = br.readLine().split(" ");

        N = Integer.parseInt(in[0]);
        K = Integer.parseInt(in[1]);

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;

        for (int i = N - 1; i > -1; i--) {
            answer += (K / arr[i]);
            K %= arr[i];
        }

        System.out.println(answer);
    }
}
