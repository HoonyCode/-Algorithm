import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ4485 {

    static int[][] map, tmp;
    static int N;
    static int Min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = 0;
        while ((N = Integer.parseInt(br.readLine().trim())) != 0) {
            t++;
            map = new int[N][N];
            tmp = new int[N][N];

            for (int i = 0; i < N; i++) { // map 채우기
                String[] input = br.readLine().trim().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                    tmp[i][j] = Integer.MAX_VALUE;
                }
            }

            // start - > 0 , 0 -> N-1, N-1 이동
            Min = Integer.MAX_VALUE;

            bfs();

            sb.append("Problem " + t + ": " + Min).append('\n');
        }

        System.out.println(sb.toString());
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void bfs() {
        PriorityQueue<Element> pque = new PriorityQueue<>();
        pque.offer(new Element(0, 0, map[0][0]));
        tmp[0][0] = map[0][0];

        Element cur;
        int drow, dcol;
        while (!pque.isEmpty()) {
            cur = pque.poll();

            if (cur.row == N-1 && cur.col == N-1){
                Min = tmp[cur.row][cur.col];
                return;
            }

            for (int d = 0; d < 4; d++) {
                drow = dr[d] + cur.row;
                dcol = dc[d] + cur.col;

                if (drow < 0 || drow >= N || dcol < 0 || dcol >= N) continue;

                if (tmp[drow][dcol] > tmp[cur.row][cur.col] + map[drow][dcol]) {
                    tmp[drow][dcol] = tmp[cur.row][cur.col] + map[drow][dcol];
                    pque.offer(new Element(drow, dcol, tmp[drow][dcol]));
                }
            }
        }

    }

    static class Element implements Comparable<Element> {
        int row;
        int col;
        int weight;

        public Element(int row, int col, int weight) {
            this.row = row;
            this.col = col;
            this.weight = weight;
        }

        @Override
        public int compareTo(Element o) {
            return this.weight - o.weight;
        }
    }


}
