import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16432 {
    static int N;
    static int[][] map;
    static int[] v;
    static boolean end = false;
    static boolean never = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            map[i] = new int[Integer.parseInt(input[0])];
            for (int j = 1; j <= map[i].length; j++) {
                map[i][j - 1] = Integer.parseInt(input[j]);
            }
        }

        dfs(0);
        if (!end || never) {
            System.out.println(-1);
        }
    }

    static void dfs(int cnt) {
        if (end || never) return;

        if (cnt == N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N ; i++){
                sb.append(v[i]).append('\n');
            }
            System.out.println(sb.toString());
            end = true;
            return;
        }

        int count = 0;

        if (cnt == 0) {
            for (int i = 0; i < map[cnt].length; i++) {
                v[cnt] = map[cnt][i];
                dfs(cnt + 1);
                count++;
                if (end || never) return;
            }
        } else {
            for (int i = 0; i < map[cnt].length; i++) {
                if (v[cnt - 1] == map[cnt][i]) continue;
                v[cnt] = map[cnt][i];
                dfs(cnt + 1);
                count++;
                if (end || never) return;
            }
        }

        if(count == map[cnt].length)
            never = true;
    }
}
