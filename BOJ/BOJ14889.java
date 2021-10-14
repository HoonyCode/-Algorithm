import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ14889 {

    static int N;
    static int[][] arr;
    static boolean[] flag;
    static int res = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        flag = new boolean[N];

        dfs(0, 0);

        System.out.print(res);


    }

    static void dfs(int satrt, int cnt) {
        if (res == 0) return;

        if (cnt == N / 2) {
            // 계산하기
            int SumA = 0;
            int SumB = 0;
            // 둘다 true일 때 계산
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (flag[i] && flag[j]) {
                        SumA += arr[i][j] + arr[j][i];
                    } else if (!flag[i] && !flag[j]) {
                        SumB += arr[i][j] + arr[j][i];
                    }
                }
            }
            res = Math.min(res, Math.abs(SumA - SumB));
            return;
        }

        for (int i = satrt; i < N; i++) {
            if (flag[i]) continue;
            flag[i] = true;
            dfs(i + 1, cnt + 1);
            flag[i] = false;
        }

    }
}
