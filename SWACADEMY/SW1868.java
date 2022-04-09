import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW1868 {

    static int[][] map;
    static boolean[][] v;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= tc; t++) {
            int res = 0; // 결과
            N = Integer.parseInt(br.readLine().trim()); // N * N
            map = new int[N][N];
            v = new boolean[N][N];

            for (int i = 0; i < N; i++) { //맵 읽기
                char[] ch = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    if (ch[j] == '*') {
                        map[i][j] = -1;
                        v[i][j] = true;
                        warning(i, j); // 별 주변에 설치
                    }
                }
            }
            // * 이면 지뢰가 있다는 뜻 . 는 지뢰가 없다는 뜻

            //역으로 -> 별을 이용해서 문제를 풀자
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0 && !v[i][j]) { // 0이고 v[i][j] check 되어 있지 않으면
                        bfs(i, j);
                        res++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!v[i][j]) { // 만약 방문되지 않았다면
                        res++;
                    }
                }
            }
            sb.append("#" + t + " " + res + "\n");
        }
        System.out.print(sb.toString());
    }

    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

    static void warning(int row, int col) { //지뢰주변에 지뢰있다는 사실 알려주는 매서드
        int drow;
        int dcol;
        for (int d = 0; d < 8; d++) {
            drow = dr[d] + row;
            dcol = dc[d] + col;

            if (drow < 0 || drow >= N || dcol < 0 || dcol >= N) continue;
            if (map[drow][dcol] == -1) continue;

            map[drow][dcol] = 1; // 지뢰가 있다는것만 알려주면 됨
        }
    }

    static void bfs(int row, int col) {
        Queue<Data> que = new LinkedList<>();
        v[row][col] = true;
        que.offer(new Data(row, col));

        Data cur;
        int drow, dcol;
        while (!que.isEmpty()) {
            cur = que.poll();

            for (int d = 0; d < 8; d++) {
                drow = dr[d] + cur.row;
                dcol = dc[d] + cur.col;

                if (drow < 0 || drow >= N || dcol < 0 || dcol >= N) continue;
                if (v[drow][dcol]) continue;
                v[drow][dcol] = true;
                if (map[drow][dcol] == 0)
                    que.offer(new Data(drow, dcol));
            }

        }

    }


    static void PrintMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    static class Data {
        int row;
        int col;

        public Data(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
