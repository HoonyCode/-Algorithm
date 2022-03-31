package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_21938 {

    static int[][] map;
    static int N;
    static int M;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        N = Integer.parseInt(in[0]);
        M = Integer.parseInt(in[1]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int sum = 0;
                for (int k = j * 3; k < (j + 1) * 3; k++) {
                    sum += Integer.parseInt(in[k]);
                }
                map[i][j] = sum / 3;
            }
        }
        int T = Integer.parseInt(br.readLine());

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] >= T) {
                    bfs(new int[]{i, j}, T);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};


    private static void bfs(int[] start, int t) {
        Queue<int[]> queue = new LinkedList<>();
        map[start[0]][start[1]] = -1;
        queue.offer(start);

        int[] cur;
        int row, col;
        while (!queue.isEmpty()) {
            cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                row = dr[d] + cur[0];
                col = dc[d] + cur[1];

                if (row < 0 || row >= N || col < 0 || col >= M) continue;
                if (map[row][col] < t) continue;
                map[row][col] = -1;
                queue.offer(new int[]{row, col});
            }
        }

    }

}
