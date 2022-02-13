import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ17244 {
    static int[][] map;


    static int R, C;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        C = Integer.parseInt(input[0]);
        R = Integer.parseInt(input[1]);

        map = new int[R][C];

        Pair start = null;

        //S : 현재 위치 E : 나가는 문의 위치 X : 물건
        for (int i = 0; i < R; i++) {
            char[] in = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (in[j] == '#') {
                    map[i][j] = -1;
                } else if (in[j] == 'S') {
                    start = new Pair(i, j, 0, 1 << 20, 0);
                } else if (in[j] == 'X') {
                    map[i][j] = ++cnt;
                } else if (in[j] == 'E') {
                    map[i][j] = 6;
                }
            }
        }

        bfs(start);


    }

    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};


    static void bfs(Pair start) {
        int[][] v = new int[R][C];
        Queue<Pair> que = new LinkedList<>();
        que.offer(start);
        v[start.r][start.c] = start.flag;

        int drow, dcol;
        Pair cur;
        while (!que.isEmpty()) {
            cur = que.poll();

            if (cur.key == cnt && map[cur.r][cur.c] == 6){
                System.out.println(cur.cnt);
                return;
            }


            for (int d = 0 ; d < 4 ; d++){
                drow = dr[d] + cur.r;
                dcol = dc[d] + cur.c;

                //1. 범위를 벗어남 => continue
                if (drow < 0 || drow >= R || dcol < 0 || dcol >= C) continue;

                //2. 벽일때
                if (map[drow][dcol] == -1) continue;

                //3. 방문한 곳 & 가 같을때
                if ((v[drow][dcol] & cur.flag) == cur.flag) continue;

                // 키일때
                if (map[drow][dcol] > 0 && map[drow][dcol] < 6){

                    int tempflag = cur.flag + (1 << map[drow][dcol]);
                    v[drow][dcol] |= tempflag;
                    que.offer(new Pair(drow, dcol, cur.cnt + 1, tempflag, cur.key + 1));

                }else{ // 키가 아닐떄

                    v[drow][dcol] |= cur.flag;
                    que.offer(new Pair(drow, dcol, cur.cnt + 1, cur.flag, cur.key + 1));
                }
            }
        }

    }

    static class Pair {
        int r, c;
        int cnt;
        int key; // 키의 개수
        int flag;

        public Pair(int r, int c, int cnt, int flag, int key) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.flag = flag;
            this.key = key;
        }
    }
}
