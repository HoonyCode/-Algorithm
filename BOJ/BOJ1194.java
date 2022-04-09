import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1194 {

    static int N, M;
    static char[][] map;
    static int res = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().trim().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new char[N][M];

        int row;
        int col;
        Pair start = null;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().trim().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '0') {
                    map[i][j] = '.';
                    start = new Pair(i, j, 1 << 20, 0);
                }
            }
        }

        bfs(start);

        System.out.println(res);
    }

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void bfs(Pair start) {
        Queue<Pair> que = new LinkedList<>();
        int[][] v = new int[N][M]; //flag값 저장하는 배열
        v[start.row][start.col] = start.flag;
        que.offer(start);

        Pair cur;
        int drow;
        int dcol;
        while (!que.isEmpty()) {
            cur = que.poll();

            for (int d = 0; d < 4; d++) {
                drow = dr[d] + cur.row;
                dcol = dc[d] + cur.col;

                if (drow < 0 || drow >= N || dcol < 0 || dcol >= M) continue;
                if (map[drow][dcol] == '#') continue;
                if ((v[drow][dcol] | cur.flag) == v[drow][dcol]) continue; //방문 한 곳이면

                if (map[drow][dcol] == '1') { // 종료 조건
                    res = cur.cnt + 1;
                    return;
                }

                if (map[drow][dcol] == '.') { //땅일 떄
                    que.offer(new Pair(drow, dcol, cur.flag, cur.cnt + 1));
                    v[drow][dcol] = cur.flag;
                } else if (map[drow][dcol] >= 'a' && map[drow][dcol] <= 'f') { //열쇠
                    int flag = 1 << (map[drow][dcol] - 'a');
                    if ((cur.flag & flag) == 0){
                        flag += cur.flag;
                        que.offer(new Pair(drow, dcol, flag, cur.cnt + 1));
                        v[drow][dcol] = flag;
                    }else{
                       que.offer(new Pair(drow, dcol, cur.flag, cur.cnt + 1));
                        v[drow][dcol] = cur.flag;
                    }
                } else {//열쇠
                    int checkFlag = 1 << (map[drow][dcol] - 'A');
                    if ((cur.flag & checkFlag) > 0) { //키를 가지고 있음
                        que.offer(new Pair(drow, dcol, cur.flag, cur.cnt + 1));
                        v[drow][dcol] = cur.flag;
                    }
                }
            }
        }
        return;
    }


    static class Pair {
        int row;
        int col;
        int flag;
        int cnt;

        public Pair(int row, int col, int flag, int cnt) {
            this.row = row;
            this.col = col;
            this.flag = flag;
            this.cnt = cnt;
        }
    }
}
