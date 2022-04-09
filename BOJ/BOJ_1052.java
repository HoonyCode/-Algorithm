package BOJ;

import java.io.*;

public class BOJ_1052 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");

        int N = Integer.parseInt(in[0]);
        int K = Integer.parseInt(in[1]);

        int[] arr = new int[27];

        arr[0] = 0;

        // 10000000 만들기
        for (int i = 0; i < 26; i++) {
            arr[i + 1] = (int) Math.pow(2, i);
        }


        while (K > 1) {
            for (int i = 26; i > -1; i--) {
                if (N >= arr[i]) {
                    N -= arr[i];
                    K--;
                    break;
                }
            }
        }

        if (N == 0) {
            System.out.println(0);
        } else {
            for (int i = 26; i > -1; i--) {
                if (N > arr[i]) {
                    System.out.println(arr[i + 1] - N);
                    break;
                }
            }
        }

    }
}
