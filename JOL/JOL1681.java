import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JOL1681 {
    static int N;
    static int[][] map;
    static boolean[] v;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        String[] input;

        for (int i = 0; i < N; i++) {
            input = br.readLine().trim().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        v = new boolean[N];
        v[0] = true;
        dfs(0, 0, 0); // 출발지는 1번이다 -> 0에서 시작
        System.out.println(min);

    }

    static void dfs(int start, int cnt, int cost) { //출발지 카운트 비용

        if (min <= cost) return; // 지금 비용이 min 보다 커지면 볼 필요가 없다.

        if (cnt == N - 1) {
            if (map[start][0] == 0) return;
            min = Math.min(cost + map[start][0], min);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (v[i] || map[start][i] == 0) continue; // 비용이 0 -> 이동할 수 없다.
            v[i] = true;
            dfs(i, cnt + 1, cost + map[start][i]);
            v[i] = false;
        }
    }
}
