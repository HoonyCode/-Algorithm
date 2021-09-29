import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW6026 {

    private static final int _mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        String[] input;
        int M;
        int N;

        for (int t = 1; t <= T; t++) {
            input = br.readLine().trim().split(" ");
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            long res = power(M, N, _mod) - (M * power(M - 1, N, _mod))%_mod;

            if (res < 0)
                res += _mod;

            res %= _mod;

            sb.append("#" + t + " " + res + "\n");
        }
        System.out.println(sb.toString());
    }

    static long power(long x, long y, long p) {
        long res = 1L;
        x = x % p;
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
}
