import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14578 {

    static long[] fn = new long[100001];
    static long mod = 1_000_000_007;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        fn[1] = 0L;
        fn[0] = 1L;

        // fn = (n - 1) (fn-1 + fn-2)
        // Sn = n! fn;
        for (int i = 2; i <= N; i++){
            fn[i] = (i-1)*(fn[i-1] + fn[i-2]);
            fn[i] %= mod;
        }
        long temp = 1;
        for (int i = 2 ; i <= N ; i++){
            temp *= i;
            temp %= mod;
        }

        long answer = temp * fn[N] % mod;

        System.out.println(answer);

    }

}
