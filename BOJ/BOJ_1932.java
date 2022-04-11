package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1932 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][];



        for (int i = 1 ; i <= N ; i++){
            arr[i] = new int[i+1];
            String[] in  = br.readLine().split(" ");
            for (int j = 1 ; j <= i ; j++){
                arr[i][j] = Integer.parseInt(in[j-1]);
            }
        }


        for (int i = N ; i > 1 ; i--){
            for (int j = 1 ; j < i ; j++){
                arr[i-1][j] += Math.max(arr[i][j], arr[i][j+1]);
            }
        }

        System.out.println(arr[1][1]);

    }
}
