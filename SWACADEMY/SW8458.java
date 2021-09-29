import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW8458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            int evenCnt = 0;
            int Max = 0;
            int num;

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().trim().split(" ");
                num = Math.abs(Integer.parseInt(input[0])) + Math.abs(Integer.parseInt(input[1]));
                if (num % 2 == 0) {
                    evenCnt++;
                }
                Max = Math.max(Max, num);
            }

            if (!(evenCnt == N || evenCnt == 0)) {
                sb.append("#" + t + " -1\n");
                continue;
            }

            int i;
            for (i = 0; ; i++) {
                Max -= i;
                if (Max <= 0) {
                    if (Math.abs(Max) % 2 == 0) {
                        break;
                    }
                }
            }
            sb.append("#" + t + " " + i + "\n");
        }
        System.out.println(sb.toString());

    }
}