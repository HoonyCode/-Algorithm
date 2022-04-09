import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14712 {

    static int N, M;
    static boolean[][] v;
    static int[] dr = {-1, -1 ,0};
    static int[] dc = {-1, 0, -1};
    static int cnt = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        v = new boolean[N][M];

        v[0][0] = true;
        dfs(0);
        v[0][0] = false;
        dfs(0);

        System.out.println(cnt);

    }

    private static void dfs(int num) {

        int r = num / M;
        int c = num % M;

        boolean flag = true; // 기본값 false; true일때 그만한다.
        int drow, dcol;
        if (!v[r][c]) flag = false;
        else {
            for (int d = 0 ; d < 3 ; d++){
                drow = r + dr[d];
                dcol = c + dc[d];
                if (drow < 0 || dcol < 0){
                    flag = false;
                    break;
                }else{
                    if (!v[drow][dcol]){
                        flag = false;
                        break;
                    }
                }
            }
        }

        if (flag){
            return;
        }

        if (num == N*M-1){
            cnt++;
            return;
        }

        r = (num + 1)/M;
        c = (num + 1)%M;

        v[r][c] = true;
        dfs(num + 1);
        v[r][c] = false;
        dfs(num + 1);

    }
}
