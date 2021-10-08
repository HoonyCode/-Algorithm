import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14889 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        int[][] map = new int[N][N];
        for (int i = 0; i < N ; i++){
            String[] input =br.readLine().split(" ");
            for (int j = 0; j < N ; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        boolean[] v = new boolean[N];

    }

    static void dfs(boolean[] v, int cnt){
        if (cnt == N/4){



            return;
        }

        for (int i = 0; i < N ; i++){
            if (v[i]) continue;
            v[i] =true;
            dfs(v, cnt+1);
            v[i] = false;
        }

    }
}
