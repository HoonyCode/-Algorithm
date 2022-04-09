import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2644 {

    static int N;
    static int A,B;
    static boolean[][] map;
    static int res = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().trim().split(" ");
        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);
        int tc = Integer.parseInt(br.readLine());
        map = new boolean[N+1][N+1];
        //y의 아이는 x이다
        for (int i = 0 ; i < tc ; i++){
            input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            map[p][c] = map[c][p] = true;
        }

        bfs();

        System.out.println(res);
    }

    private static void bfs() {
        Queue<Data> que = new LinkedList<>();
        que.offer(new Data(A, 0));
        boolean[] v = new boolean[N+1];
        v[A] = true;


        while (!que.isEmpty()){
            Data now = que.poll();

            if(now.value == B){
                res = now.depth;
                return;
            }

            for (int i = 1; i < N+1; i ++){
                if(v[i] || !map[now.value][i])  continue;

                que.offer(new Data(i, now.depth+1));
                v[i] = true;
            }
        }
    }


    static class Data{
        int value;
        int depth;

        public Data(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }

}