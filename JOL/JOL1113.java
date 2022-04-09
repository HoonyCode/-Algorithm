import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class JOL1113 {

    static int M, N;
    static int m, n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().trim().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        input = br.readLine().trim().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            input = br.readLine().trim().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs();
        return;
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void bfs() {
        boolean v[][] = new boolean[M][N];
        int[][] temp = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(temp[i], Integer.MAX_VALUE);
        }
        v[0][0] = true;
        PriorityQueue<Data> que = new PriorityQueue<>();
        if (map[0][1] == 1) {
            que.offer(new Data(0, 1, 3, 0));
            temp[0][1] = 0;
        }
        if (map[1][0] == 1) {
            que.offer(new Data(1, 0, 1, 0));
            temp[1][0] = 0;
        }


        int drow;
        int dcol;
        Data cur;

        while (!que.isEmpty()){
            cur = que.poll();
            if (cur.row == m && cur.col == n) {
                System.out.println(cur.cnt);
                break;
            }

            if (v[cur.row][cur.col]) continue;
            v[cur.row][cur.col] = true;

            for (int d = 0; d < 4; d++) {
                drow = cur.row + dr[d];
                dcol = cur.col + dc[d];

                if (drow < 0 || drow >= M || dcol < 0 || dcol >= N || map[drow][dcol] == 0) continue;

                int nowcurv = 0;
                if (cur.dir != d) nowcurv++;

                if (temp[drow][dcol] > temp[cur.row][cur.col] + nowcurv) {
                    temp[drow][dcol] = temp[cur.row][cur.col] + nowcurv;
                    que.offer(new Data(drow, dcol, d, temp[drow][dcol]));
                }
            }

        }
    }

    static class Data implements Comparable<Data> {
        int row;
        int col;
        int dir;
        int cnt;

        public Data(int row, int col, int dir, int cnt) {
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Data o) {
            return this.cnt - o.cnt;
        }
    }

    static void PrintMap(int[][] arr){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M ; i++){
            for (int j = 0; j < N ; j++){
                if(arr[i][j] == Integer.MAX_VALUE){
                    sb.append("MAX ");
                    continue;
                }
                sb.append(arr[i][j] + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

}
