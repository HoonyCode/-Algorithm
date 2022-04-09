import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10971 {

    static boolean[] visit; //방문체크 배열
    static int N; //갯수
    static int[][] map; //
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(in[j]);
            }
        }

        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            visit[i] = true;
            dfs(i, i, 0, 0);
            visit[i] = false;
        }


        System.out.println(answer);
    }

    private static void dfs(int cur, int end, int dept, int total) {

        if (answer <= total) return;

        if (dept == N-1) {
            if (map[cur][end] == 0) return;
            answer = Math.min(answer, total + map[cur][end]);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;
            if (map[cur][i] == 0) continue;

            visit[i] = true;
            dfs(i, end, dept + 1, total + map[cur][i]);
            visit[i] = false;
        }

    }
}
