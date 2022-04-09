import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+2];
        int[] profit = new int[N+2];
        int[] date = new int[N+2];
        String[] input;
        int max = 0;
        for (int i = 1; i <= N; i++){
            input = br.readLine().split(" ");
            date[i] = new Integer(input[0]);
            profit[i] = new Integer(input[1]);
        }

        for (int i = N ; i >= 1 ; i--){
            if (i + date[i] > N+1){
                dp[i] = dp[i+1];
            }else{
                dp[i] = Math.max(dp[i+1], dp[i+date[i]] + profit[i]);
            }

        }


        System.out.println(dp[1]);
    }

}
