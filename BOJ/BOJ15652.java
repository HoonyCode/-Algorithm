import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15652 {

    static int N, M;
    static int[] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[M];
        dfs(0,1);
        System.out.print(sb.toString());
    }

    static void dfs(int dept,int start){
        if(dept == M){
            for (int i = 0; i < M ; i++){
                sb.append(map[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N ; i++){
            map[dept] = i;
            dfs(dept+1,i);
        }

    }

}
