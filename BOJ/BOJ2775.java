import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] house = new int[15][15];
        for(int i = 1; i <= 14 ; i++){
            house[0][i] = i;
        }
        for(int i = 1 ; i <= 14 ; i++){
            for(int j = 1 ; j <= 14 ; j++){
                house[i][j] += house[i][j-1] + house[i-1][j];
            }
        }


        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T ; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(house[k][n]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
