import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1018 {

    static int min = Integer.MAX_VALUE;
    static char[][] map;
    static int N, M;
    static int[] dr = {0,1};
    static int[] dc = {1,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new char[N][M];

        for(int i = 0; i < N ; i++){
            map[i] = br.readLine().toCharArray();
        }


        for(int i = 0 ; i <= N-8; i++){
            for(int j = 0 ; j <= M-8 ; j++){
                bfs(new Pair(i, j, 'W'));
                bfs(new Pair(i, j ,'B'));
            }
        }
        System.out.println(min);
    }

    static void bfs(Pair pair){
        int row = pair.row + 8;
        int col = pair.col + 8;
        int cnt = 0;

        boolean[][] v = new boolean[N][M];
        Queue<Pair> que = new LinkedList<>();
        que.offer(pair);
        v[pair.row][pair.col] = true;

        while (!que.isEmpty()){
            Pair now = que.poll();

            if(map[now.row][now.col] != now.c)
                cnt++;

            if(min <= cnt) return;

            for (int d = 0 ; d < 2 ; d++){
                int drow = now.row + dr[d];
                int dcol = now.col + dc[d];

                if(drow >= row || dcol >= col) continue;
                if(v[drow][dcol]) continue;

                if(now.c == 'W')
                    que.offer(new Pair(drow, dcol, 'B'));
                else
                    que.offer(new Pair(drow, dcol, 'W'));

                v[drow][dcol] = true;
            }
        }

        min = Math.min(min, cnt);
        return;
    }


    static class Pair{
        int row;
        int col;
        char c;

        public Pair(int row, int col, char c) {
            this.row = row;
            this.col = col;
            this.c = c;
        }
    }
}
