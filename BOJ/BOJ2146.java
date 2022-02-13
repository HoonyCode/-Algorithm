import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ2146 {

    static int N;
    static int[][] map;
    static List<List<Pair>> maplist = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        String[] in;

        for (int i = 0; i < N; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(in[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    bfs(new Pair(i, j));
                }
            }
        }

        //거리 계산
        int answer = Integer.MAX_VALUE;

        for (int i = 0 ; i < maplist.size()-1 ; i++){
            for (int j = i+1; j < maplist.size(); j++){
                for (Pair map1 : maplist.get(i)){
                    for (Pair map2 : maplist.get(j)){
                        answer = Math.min(answer, Math.abs(map1.r - map2.r) + Math.abs(map1.c - map2.c));
                    }
                }
            }
        }
        System.out.println(answer - 1);
    }

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};


    private static void bfs(Pair pair) {

        Queue<Pair> que = new LinkedList<>();
        que.offer(pair);
        map[pair.r][pair.c] = 2;
        maplist.add(new ArrayList<>());

        Pair cur;
        int row, col;
        boolean flag;
        while (!que.isEmpty()) {
            cur = que.poll();
            flag = false;

            for (int d = 0; d < 4; d++) {
                row = cur.r + dr[d];
                col = cur.c + dc[d];

                if (row < 0 || row >= N || col < 0 || col >= N) continue;
                if (map[row][col] != 1) {
                    flag = true;
                    continue;
                }

                map[row][col] = 2;
                que.offer(new Pair(row, col));
            }

            if (flag) maplist.get(maplist.size()-1).add(cur);
        }

    }

    static class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
