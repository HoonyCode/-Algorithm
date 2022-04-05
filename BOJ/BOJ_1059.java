package BOJ;

import java.io.*;

public class BOJ_1059 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String input[] = br.readLine().split(" ");

        for (int i = 0 ; i < N ; i++)
            arr[i] = Integer.parseInt(input[i]);

        int M = Integer.parseInt(br.readLine());

        boolean check = false;

        int left = 0;
        int right = 1001;

        for (int i = 0 ; i < N ; i++){
            if (arr[i] > M){
                right = Math.min(right, arr[i]);
            }else if(arr[i] < M){
                left = Math.max(left, arr[i]);
            }else {
                check = true;
            }
        }

        int L = M - left - 1;
        int R = right - M - 1;
        int answer = L + R + L * R;

        if (check) {
            System.out.println(0);
        }else
            System.out.println(answer);

    }

}
