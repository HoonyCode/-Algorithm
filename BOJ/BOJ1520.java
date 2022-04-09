import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1520 {

    static int R,C;
    static int[][] map;
    static int[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        R = Integer.parseInt(in[0]);
        C = Integer.parseInt(in[1]);

        map = new int[R][C];
        dp = new int[R][C];

        for (int i = 0 ; i < R ; i++){
            in = br.readLine().split(" ");
            for (int j = 0 ; j <C ;j++){
                map[i][j] = Integer.parseInt(in[j]);
                dp[i][j] = -1;
            }
        }

        int answer = dfs(0,0);
        System.out.println(answer);
    }

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    private static int dfs(int r, int c) {
        if (r == R-1 && c == C-1) return 1;
        if (dp[r][c] != -1) return dp[r][c];
        dp[r][c] = 0;
        int row, col;
        for (int d = 0 ; d < 4 ; d++){
            row = r + dr[d];
            col = c + dc[d];
            if (row < 0 || row >= R || col < 0 || col >= C) continue;
            if (map[row][col] < map[r][c]){
                dp[r][c] += dfs(row,col);
            }
        }
        return dp[r][c];
    }
}
