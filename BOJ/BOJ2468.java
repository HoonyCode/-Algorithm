import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2468 {

    static int N;
    static int[][] map;
    static int[][] v;
    static int answer = 1;

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<Integer>();
        map = new int[N][N];

        String[] in;
        for (int i = 0; i < N; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(in[j]);
                set.add(map[i][j]);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int cur : set) {
            list.add(cur);
        }
        Collections.sort(list);


        //비의 크기
        for (int size : list) {
            int cnt = 0;
            boolean[][] v = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] <= size || v[i][j]) continue;
                    bfs(new int[]{i, j}, v, size);
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);

    }


    private static void bfs(int[] start, boolean[][] v, int size) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(start);
        v[start[0]][start[1]] = true;

        int[] cur;
        int drow, dcol;
        while (!que.isEmpty()) {
            cur = que.poll();

            for (int d = 0; d < 4; d++) {
                drow = dr[d] + cur[0];
                dcol = dc[d] + cur[1];

                if (drow < 0 || drow >= N || dcol < 0 || dcol >= N) continue;
                if (v[drow][dcol] || map[drow][dcol] <= size) continue;
                v[drow][dcol] = true;

                que.offer(new int[]{drow, dcol});
            }
        }
    }
}
