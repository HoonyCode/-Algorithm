package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_스티커_HoonyCode {

    static int[][] map = new int[2][100_001];

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            int n = Integer.parseInt(br.readLine());


            for (int i = 0; i < 2; i++) {
                String[] in = br.readLine().split(" ");
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Integer.parseInt(in[j - 1]);
                }
            }


            for (int i = 2; i <= n; i++) {
                map[0][i] = Math.max(map[1][i - 1] + map[0][i], map[1][i - 2] + map[0][i]);
                map[1][i] = Math.max(map[0][i - 1] + map[1][i], map[0][i - 2] + map[1][i]);
            }


            sb.append(Math.max(map[0][n], map[1][n])).append('\n');
        }

        System.out.print(sb.toString());
    }
}
