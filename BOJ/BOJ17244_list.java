import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17244_list {

    static int R, C;
    static int[][] map;
    static int item;
    static int[][] dist;
    static Pair[] startList = new Pair[7];
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[7];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        C = Integer.parseInt(input[0]);
        R = Integer.parseInt(input[1]);

        dist = new int[7][7];

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            char[] in = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (in[j] == 'S') {
                    map[i][j] = 7;
                    startList[0] = new Pair(i, j, 0);
                } else if (in[j] == 'X') {
                    map[i][j] = ++item;
                    startList[item] = new Pair(i, j, 0);
                } else if (in[j] == 'E') {
                    map[i][j] = 6;
                    startList[6] = new Pair(i, j, 0);
                } else if (in[j] == '#') {
                    map[i][j] = -1;
                }
            }
        }

        for (int i = 0; i <= item; i++) {
            bfs(startList[i], i);
        }

        dfs(0, 0, 0);

        System.out.println(answer);
    }

    private static void dfs(int dept, int start, int total) {

        if (dept == item) {
            answer = Math.min(total + dist[start][6] , answer);
            return;
        }

        for (int i = 1; i <= item; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(dept + 1, i, total + dist[start][i]);
            visited[i] = false;
        }
    }


    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    private static void bfs(Pair start, int idx) {
        boolean[][] v = new boolean[R][C];
        Queue<Pair> que = new LinkedList<>();
        v[start.r][start.c] = true;
        que.offer(new Pair(start.r, start.c, 0));

        Pair cur;
        int drow, dcol;
        while (!que.isEmpty()) {
            cur = que.poll();

            for (int d = 0; d < 4; d++) {
                drow = dr[d] + cur.r;
                dcol = dc[d] + cur.c;

                if (drow < 0 || drow >= R || dcol < 0 || dcol >= C
                        || map[drow][dcol] == -1
                        || v[drow][dcol]) continue;
                // 방문 체크
                v[drow][dcol] = true;

                if (map[drow][dcol] > 0) {
                    dist[idx][map[drow][dcol] % 7] = cur.cnt + 1;
                }

                que.offer(new Pair(drow, dcol, cur.cnt + 1));
            }
        }

    }

    static class Pair {
        int r, c;
        int cnt;

        public Pair(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

}
