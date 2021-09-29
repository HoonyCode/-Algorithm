import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ17070 {

    static int N; //집의 크기
    static int cnt; //개수
    static int[][] map; // 집의 상태 //빈 칸은 0 벽은 1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().trim().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(new Pair(0,1,0));
        System.out.println(cnt);

    }

    //1 가로 일때 가로 세로x 대각선
    //2 세로 일때 가로x 세로 대각선
    //3 대각선 일때 가로 세로 대각선
    static int[][] dr = {{0, 0, 1}, {0, 1, 1}, {0, 1, 1}};
    static int[][] dc = {{1, 0, 1}, {0, 0, 1}, {1, 0, 1}};

    static void dfs(Pair cur) {

        if (cur.row == N-1 && cur.col == N-1){
            cnt++;
            return;
        }

        int drow;
        int dcol;
        for (int d = 0; d < 3; d++) {
            if (dr[cur.pos][d] == 0 && dc[cur.pos][d] == 0) continue;
            drow = dr[cur.pos][d] + cur.row;
            dcol = dc[cur.pos][d] + cur.col;

            if (drow < 0 || drow >= N || dcol < 0 || dcol >= N) continue;
            if (map[drow][dcol] != 0) continue;
            if (d == 2) {
                if (map[drow][dcol - 1] != 0 || map[drow - 1][dcol] != 0) continue;
            }
            dfs(new Pair(drow,dcol,d));
        }

    }

    static class Pair {
        int row;
        int col;
        int pos;

        public Pair(int row, int col, int pos) {
            this.row = row;
            this.col = col;
            this.pos = pos;
        }
    }
}
