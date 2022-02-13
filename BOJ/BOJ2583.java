import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// bfs sort


public class BOJ2583 {

    static int M, N, K;
    static boolean[][] visit;
    static List<Integer> mapSizeList = new ArrayList<>();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        M = Integer.parseInt(in[0]);
        N = Integer.parseInt(in[1]);
        K = Integer.parseInt(in[2]);

        visit = new boolean[M][N];

        int x1, y1, x2, y2;
        for (int i = 0 ; i < K ; i++){
            in = br.readLine().split(" ");
            x1 = Integer.parseInt(in[0]);
            y1 = Integer.parseInt(in[1]);
            x2 = Integer.parseInt(in[2]);
            y2 = Integer.parseInt(in[3]);
            checkmap(x1,y1,x2,y2);
        }

        for (int i = 0 ; i < M ; i++){
            for (int j = 0 ; j < N ; j++ ){
                if(visit[i][j]) continue;
                bfs(new Pair(i,j));
            }
        }

        Collections.sort(mapSizeList);
        System.out.println(mapSizeList.size());
        for (Integer answer : mapSizeList){
            System.out.print(answer + " ");
        }

    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};


    private static void bfs(Pair start) {
        int cnt = 0;
        Queue<Pair> que = new LinkedList<>();
        que.offer(start);
        visit[start.x][start.y] = true;

        Pair cur;
        int xx, yy;
        while (!que.isEmpty()){
            cnt++;
            cur = que.poll();

            for (int d = 0 ; d < 4 ; d++){
                xx = cur.x + dx[d];
                yy = cur.y + dy[d];

                if (xx < 0 || xx >= M || yy < 0 || yy >= N || visit[xx][yy]) continue;
                visit[xx][yy] = true;
                que.offer(new Pair(xx,yy));
            }
        }

        mapSizeList.add(cnt);
    }

    private static void checkmap(int x1, int y1, int x2, int y2) {
        for (int i = y1 ; i < y2 ; i++) {
            for (int j = x1; j < x2; j++) {
                visit[i][j] = true;
            }
        }
    }

    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
