import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ14442 {
    static int col, row, K; // 가로 세로
    static int[][] map;
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        row = Integer.parseInt(input[0]);
        col = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        map = new int[row][col];

        for (int i = 0; i < row; i++) {
            String in = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = in.charAt(j) - '0';
            }
        }

        bfs();

        if(res == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(res);

    }

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    static void bfs() {
        Queue<Data> que = new LinkedList<>();
        boolean[][][] v = new boolean[K + 1][row][col];

        que.offer(new Data(0, 0, 1, 0));
        v[0][0][0] = true;

        Data cur;
        while (!que.isEmpty()) {
            cur = que.poll();

            if (cur.row == row - 1 && cur.col == col - 1) {
                res = Math.min(res, cur.cnt);
                return;
            }

            int drow, dcol;
            for (int d = 0; d < 4; d++) {
                drow = dr[d] + cur.row;
                dcol = dc[d] + cur.col;

                if(drow < 0 || drow >= row || dcol < 0 || dcol >= col)
                    continue;
                if(!v[cur.skill][drow][dcol] && map[drow][dcol] != 1){
                    que.offer(new Data(drow,dcol,cur.cnt+1, cur.skill));
                    v[cur.skill][drow][dcol] = true;
                }
                if(cur.skill+1 <= K){
                    if(v[cur.skill+1][drow][dcol]) continue;
                    que.offer(new Data(drow,dcol,cur.cnt+1, cur.skill+1));
                    v[cur.skill+1][drow][dcol] = true;
                }
            }
        }
    }


    static class Data {
        int row;
        int col;
        int cnt;
        int skill;

        public Data(int row, int col, int cnt, int skill) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.skill = skill;
        }
    }

    static void Print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
