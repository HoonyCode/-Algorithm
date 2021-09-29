import org.omg.CORBA.MARSHAL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16236 {

    static int N;
    static int[][] map;
    static int sharkSize = 2;
    static int eatCnt = 0;
    static Pair shark;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 9) {
                    shark = new Pair(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }

        while (bfs());
        System.out.println(shark.time);
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    static boolean bfs() {
        Queue<Pair> que = new LinkedList<>();
        boolean[][] v = new boolean[N][N];
        v[shark.row][shark.col] = true;
        que.offer(shark);

        Pair cur = null;
        int drow;
        int dcol;
        int minTime = Integer.MAX_VALUE;
        ArrayList<Pair> list = new ArrayList<>();
        while (!que.isEmpty()) {
            cur = que.poll();

            if (minTime < cur.time)
                break;

            if (map[cur.row][cur.col] > 0 && map[cur.row][cur.col] < sharkSize) {
                list.add(new Pair(cur.row, cur.col, cur.time));
                minTime = cur.time;
            }

            for (int d = 0; d < 4; d++) {
                drow = dr[d] + cur.row;
                dcol = dc[d] + cur.col;
                if (drow < 0 || drow >= N || dcol < 0 || dcol >= N || map[drow][dcol] > sharkSize || v[drow][dcol])
                    continue;
                v[drow][dcol] = true;
                que.offer(new Pair(drow, dcol, cur.time + 1));
            }
        }

        //상어 찾기
        if (list.isEmpty())
            return false;
        Collections.sort(list);
        shark = list.get(0);
        map[shark.row][shark.col] = 0;
        Eat();
        return true;
    }


    static class Pair implements Comparable<Pair> {
        int row;
        int col;
        int time;

        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.row == o.row)
                return this.col - o.col;
            return this.row - o.row;
        }
    }

    static void Eat() {
        eatCnt++;
        if (eatCnt == sharkSize) {
            eatCnt = 0;
            sharkSize++;
        }
    }

}
