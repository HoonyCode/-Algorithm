import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1600 {
    static int K;
    static int W, H;
    static int[][] map;
    static int res = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        W = Integer.parseInt(input[0]);
        H = Integer.parseInt(input[1]);
        map = new int[H][W];
        for(int i = 0; i <H; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j< W; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
//        솔루션
        bfs();
        System.out.println(res);

    }
    static int[] dx = {0,0,-1,1}; // 상하좌우
    static int[] dy = {-1,1,0,0};
    static int[] hdx = {-2,-1,1,2,2,1,-1,-2};
    static int[] hdy = {-1,-2,-2,-1,1,2,2,1};
    private static void bfs() {
        Queue<Data> q = new LinkedList<Data>();
//        큐삽입
        boolean[][][] v = new boolean[K+1][H][W]; // k, x, y
//        방문체크 초기화

        q.offer(new Data(0,0,0,0));
        v[0][0][0] = true;

//        큐 반복
        Data cur;
        while(!q.isEmpty()) {
//            도착지 확인
            cur = q.poll();
            if(cur.x == W-1 && cur.y == H-1) {
                res = cur.cnt;
                break;
            }
//            원숭이 이동
            int nx, ny;
            for(int d = 0; d < 4; d++) {
                nx = cur.x + dx[d];
                ny = cur.y + dy[d];
//                범위체크
                if(nx < 0 || nx >=W || ny < 0 || ny >= H) {
                    continue;
                }
//                방문체크
                if(v[cur.k][ny][nx]) {
                    continue;
                }
//                장애물체크
                if(map[ny][nx] == 1) {
                    continue;
                }
//                큐에 삽입
                q.offer(new Data(nx, ny, cur.cnt + 1, cur.k)); // 치트키 사용안함
                v[cur.k][ny][nx] = true;

            }
//            말 이동(if k)
            if(cur.k + 1<= K) { // 치트키 사용가능하면 말이동
                for(int d = 0; d < 8; d++) {
                    nx = cur.x + hdx[d];
                    ny = cur.y + hdy[d];
//                    범위체크
                    if(nx < 0 || nx >=W || ny < 0 || ny >= H) {
                        continue;
                    }
//                    방문체크
                    if(v[cur.k+1][ny][nx]) {
                        continue;
                    }
//                    장애물체크
                    if(map[ny][nx] == 1) {
                        continue;
                    }
//                    큐에 삽입
                    q.offer(new Data(nx, ny, cur.cnt + 1, cur.k+1)); // 치트키 사용 함
                    v[cur.k + 1][ny][nx] = true;
                }
            }
        }

    }

    static class Data{
        int x, y;
        int cnt;
        int k ; // 치트키 횟수
        public Data(int x, int y, int cnt, int k) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.k = k;
        }

    }

}
