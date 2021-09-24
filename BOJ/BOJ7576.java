import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ7576 {
    static int col, row;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int res = -1;
    static int total;
    static int cnt;
    static ArrayList<Pair> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        col = Integer.parseInt(input[0]);
        row = Integer.parseInt(input[1]);

        total = row * col;

        map = new int[row][col];

        for (int i = 0; i < row; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 1) arr.add(new Pair(i, j, 0));
                if (map[i][j] == -1) total--;
            }
        }
        total -= arr.size();
        bfs();

        System.out.println(res);

    }

    static void bfs() {
        Queue<Pair> que = new LinkedList<>();
        for (int i = 0; i < arr.size(); i++) {
            que.offer(arr.get(i));
        }

        while (!que.isEmpty()) {
            Pair temp = que.poll();
            if (total == cnt)
                res = temp.time;

            for (int d = 0; d < 4; d++) {
                int drow = dr[d] + temp.row;
                int dcol = dc[d] + temp.col;

                if (drow < 0 || drow >= row || dcol < 0 || dcol >= col || map[drow][dcol] != 0)
                    continue;

                cnt++;
                que.offer(new Pair(drow, dcol, temp.time + 1));
                map[drow][dcol] = 1;
            }
        }

        return;
    }

    static class Pair {
        int row;
        int col;
        int time;

        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}
