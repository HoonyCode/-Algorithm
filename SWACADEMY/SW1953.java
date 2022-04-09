import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW1953 {

    static int N, M, R, C, L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            String[] input = br.readLine().trim().split(" ");
            N = Integer.parseInt(input[0]); //가로
            M = Integer.parseInt(input[1]); //세로
            R = Integer.parseInt(input[2]); //맨홀 뚜껑이 위치한 장소의 세로
            C = Integer.parseInt(input[3]); //맨홀 뚜껑이 위치한 장소의 가로
            L = Integer.parseInt(input[4]); //소요된 시간

            map = new int[N][M];

            for (int i = 0; i < N; i++) {
                input = br.readLine().trim().split(" ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            if (map[R][C] == 0){
                sb.append("#" + t + " " + 0 +"\n");
            }

            int res = bfs(new Data(R, C, 1));

            sb.append("#" + t + " " + res + "\n");
        }

        System.out.println(sb.toString());
    }

    static int[][] dr = {
            {-1, 1, 0, 0}, // 상 하 좌 우
            {-1, 1, 0, 0}, // 상 하
            { 0, 0, 0, 0}, //      좌 우
            {-1, 0, 0, 0}, // 상      우
            { 0, 1, 0, 0}, //   하    우
            { 0, 1, 0, 0}, //   하  좌
            {-1, 0, 0, 0}  // 상    좌
    };
    static int[][] dc = {
            {0, 0, -1, 1},// 상 하 좌 우
            {0, 0, 0, 0},// 상 하
            {0, 0, -1, 1},//      좌 우
            {0, 0,  0, 1},// 상      우
            {0, 0,  0, 1}, //   하    우
            {0, 0, -1, 0},//   하  좌
            {0, 0, -1, 0}// 상    좌
    };

    static int[][] isPos = { // 상 하 좌 우
            {1,2,5,6}, //상일떄 가능
            {1,2,4,7}, //하일때 가능
            {1,3,4,5}, //좌 일때 가능
            {1,3,6,7} //울 일떄 가능
    };

    static int bfs(Data start) {
        int total = 0;
        Queue<Data> que = new LinkedList<>();
        boolean[][] v = new boolean[N][M];
        que.offer(start);
        v[start.row][start.col] = true;

        int drow;
        int dcol;
        Data cur;
        while (!que.isEmpty()) {
            cur = que.poll();

            if (cur.time > L){
                break;
            }
            total++;

            int nowTN = map[cur.row][cur.col] - 1;
            for (int d = 0; d < 4 ; d++){

                if(dr[nowTN][d] + dc[nowTN][d] == 0) continue;
                drow = dr[nowTN][d] + cur.row;
                dcol = dc[nowTN][d] + cur.col;

                if (drow < 0 || drow >= N || dcol < 0 || dcol >= M || map[drow][dcol] == 0) continue;
                if (v[drow][dcol]) continue;
                boolean flag = false;
                for (int i = 0; i < 4 ; i++){ // 가능한게 있으면 true 반환
                    if (map[drow][dcol] == isPos[d][i]){
                        flag = true;
                        break;
                    }
                }
                if (!flag) continue; // true가 아니면 넘어감

                que.offer(new Data(drow,dcol,cur.time+1));
                v[drow][dcol] = true;
            }
        }

        return total;
    }


    static class Data {
        int row;
        int col;
        int time;

        public Data(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}
