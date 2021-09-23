import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1260 {
    static int N, M, V;
    static boolean[][] map;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        V = Integer.parseInt(input[2]); //start

        map = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int e1 = Integer.parseInt(input[0]);
            int e2 = Integer.parseInt(input[1]);
            map[e1][e2] = map[e2][e1] = true;
        }

        v = new boolean[N+1];

        dfs(V);
        sb.append('\n');
        bfs(V);
        System.out.println(sb.toString());

    }

    static void bfs(int start){
        Arrays.fill(v, false);
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        v[start] = true;

        while (!que.isEmpty()){
            int temp = que.poll();
            sb.append(temp + " ");

            for(int i = 1 ; i < N+1; i ++){
                if(v[i] || !map[temp][i]) continue; // true false
                v[i] = true;
                que.offer(i);
            }
        }

    }

    static void dfs(int start) {
        v[start] = true;
        sb.append(start + " ");

        for(int i = 1 ; i < N+1; i ++){
            if(v[i] || !map[start][i]) continue; // true false

            dfs(i);
        }
    }

}
