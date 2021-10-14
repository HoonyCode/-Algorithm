import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16932 {

    static int R, C;
    static int[][] map;
    static int res = 0;
    static List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 섬나누기
        list.add(0);
        list.add(0);
        int check = 2;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 1) {
                    bfs(new Pair(i, j), check);
                    check++;
                }
            }
        }

        //계산하기
        int drow, dcol;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0) {
                    int sum = 1;
                    HashSet<Integer> hashSet = new HashSet<>();
                    for (int d = 0; d < 4; d++) {
                        drow = dr[d] + i;
                        dcol = dc[d] + j;

                        if (drow < 0 || drow >= R || dcol < 0 || dcol >= C || map[drow][dcol] == 0) continue;
                        hashSet.add(map[drow][dcol]);
                    }
                    if (hashSet.isEmpty()) continue;
                    for (int a : hashSet)
                        sum += list.get(a);
                   res = Math.max(res, sum);
                }
            }
        }

        System.out.println(res);
    }

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};


    static void bfs(Pair start, int check) {
        int cnt = 0;
        Queue<Pair> que = new LinkedList<>();
        que.offer(start);
        map[start.row][start.col] = check;

        Pair cur;
        int drow, dcol;

        while (!que.isEmpty()) {
            cur = que.poll();
            cnt++;

            for (int d = 0; d < 4; d++) {
                drow = dr[d] + cur.row;
                dcol = dc[d] + cur.col;

                if (drow < 0 || drow >= R || dcol < 0 || dcol >= C || map[drow][dcol] != 1) continue;
                que.offer(new Pair(drow, dcol));
                map[drow][dcol] = check;
            }

        }

        list.add(cnt);
        res = Math.max(res, cnt);
    }


    static class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
