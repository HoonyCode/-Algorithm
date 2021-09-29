import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW7699 {
    static int R, C;
    static char[][] map;
    static boolean[][] v;
    static boolean[] check = new boolean['Z' - 'A' + 1];
    static int res = -1;
    private static final int finish = 'Z'-'A' + 1;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            String[] input = br.readLine().split(" ");
            R = Integer.parseInt(input[0]);
            C = Integer.parseInt(input[1]);
            map = new char[R][C];

            for (int i = 0; i < R; i++) {
                map[i] = br.readLine().toCharArray();
            }
            //statr 여행지 0, 0;
            //dfs 문제 가지치기

            v = new boolean[R][C];
            v[0][0] = true;
            Arrays.fill(check,  false);
            res = 0;
            check[map[0][0] - 'A'] = true;
            flag = false;
            dfs(0, 0, 1);

            sb.append("#" + t + " " + res + "\n");
        }

        System.out.println(sb.toString());
    }

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static void dfs(int row, int col, int cnt) {
        res = Math.max(cnt, res);
        if (flag) return;

        if (cnt == finish){
            flag = true;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int drow = dr[d] + row;
            int dcol = dc[d] + col;

            if (drow < 0 || drow >= R || dcol < 0 || dcol >= C || v[drow][dcol]) continue;
            if (check[map[drow][dcol] - 'A']) continue;

            check[map[drow][dcol] - 'A'] = true;
            v[row][col] = true;
            dfs(drow, dcol, cnt+1);
            check[map[drow][dcol] - 'A'] = false;
            v[row][col] = false;
        }


    }
}
