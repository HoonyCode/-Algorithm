import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2234 {

    static int R, C;
    static int[][] map;
    static int[][] checkmap;
    static List<Integer> mapSizeList = new ArrayList<>();
    static int maxSize = 0;
    static Set<Integer> sizeSet = new HashSet<>();


    //서 북 동 남
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        C = Integer.parseInt(in[0]);
        R = Integer.parseInt(in[1]);

        map = new int[R][C];
        checkmap = new int[R][C];

        for (int i = 0; i < R; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(in[j]);
            }
        }


        int cnt = 1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (checkmap[i][j] != 0) continue;
                bfs(new int[]{i, j}, cnt);
                cnt++;
            }
        }

        System.out.println(mapSizeList.size());
        System.out.println(maxSize);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (checkmap[i][j] == 0) continue;
                bfs2(new int[]{i, j}, checkmap[i][j]);
            }
        }

        int answer = 0;
        for (int size : sizeSet){
            answer = Math.max(size, answer);
        }

        System.out.println(answer);

    }

    private static void bfs2(int[] start, int now) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(start);
        checkmap[start[0]][start[1]] = 0;

        int[] cur;
        int drow, dcol;
        while (!que.isEmpty()) {
            cur = que.poll();

            for (int d = 0; d < 4; d++) {
                drow = cur[0] + dr[d];
                dcol = cur[1] + dc[d];

                if (drow < 0 || drow >= R || dcol < 0 || dcol >= C) continue;
                if (checkmap[drow][dcol] != now) {
                    if (checkmap[drow][dcol] != 0)
                        sizeSet.add(mapSizeList.get(now - 1) + mapSizeList.get(checkmap[drow][dcol] - 1));
                    continue;
                }
                checkmap[drow][dcol] = 0;
                que.offer(new int[]{drow, dcol});

            }
        }

    }

    private static void bfs(int[] start, int cnt) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(start);
        checkmap[start[0]][start[1]] = cnt;

        int[] cur;
        int drow, dcol;
        int size = 0;
        while (!que.isEmpty()) {
            cur = que.poll();
            size++;

            for (int d = 0; d < 4; d++) {
                if ((map[cur[0]][cur[1]] & (1 << d)) != 0) continue;

                drow = cur[0] + dr[d];
                dcol = cur[1] + dc[d];

                if (checkmap[drow][dcol] != 0) continue;
                checkmap[drow][dcol] = cnt;
                que.offer(new int[]{drow, dcol});
            }
        }
        mapSizeList.add(size);
        maxSize = Math.max(maxSize, size);
    }
}
