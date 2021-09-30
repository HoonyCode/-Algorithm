import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SW1249 {

    //녹색 젤다지 같은 문제유형
    //다익스트라 로 쉽게 풀 수 있다.
    static int N;
    static int[][] map;
    static int[][] v;
    static int Min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            v = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                    v[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs();


            sb.append("#" + t + " " + Min + "\n");
        }

        System.out.println(sb.toString());
    }

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {-1, 1, 0, 0};

    static void bfs() {
        PriorityQueue<Pair> que = new PriorityQueue<>();
        que.offer(new Pair(0, 0, map[0][0]));
        v[0][0] = map[0][0];

        int drow;
        int dcol;
        Pair cur;
        while (!que.isEmpty()) {
            cur = que.poll();
            if (cur.row == N - 1 && cur.col == N - 1) {
                Min = v[N-1][N-1];
                return;
            }

            for (int d = 0; d < 4; d++) {
                drow = cur.row + dr[d];
                dcol = cur.col + dc[d];

                if (drow < 0 || drow >= N || dcol < 0 || dcol >= N) continue;
                if (v[drow][dcol] > v[cur.row][cur.col] + map[drow][dcol]) {
                    v[drow][dcol] = v[cur.row][cur.col] + map[drow][dcol];
                    que.offer(new Pair(drow, dcol, v[drow][dcol]));
                }
            }
        }

    }

    static class Pair implements Comparable<Pair> {
        int row;
        int col;
        int weight;

        public Pair(int row, int col, int weight) {
            this.row = row;
            this.col = col;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }

}
