import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2098 {

    private static final int INFINITY = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().trim().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        int start = Integer.parseInt(br.readLine().trim());
        int[][] matrix = new int[V + 1][V + 1];

        for (int i = 0; i < E; i++) {
            input = br.readLine().trim().split(" ");
            matrix[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = Integer.parseInt(input[2]);
        }

        for (int end = 1; end <= V; end++) {
            boolean flag = false;
            if (start == end) {
                sb.append("0\n");
                continue;
            }
            int[] D = new int[V + 1];
            boolean[] v = new boolean[V + 1];

            Arrays.fill(D, INFINITY);
            D[start] = 0;

            int min = 0, current = 0;
            for (int i = 1; i <= V; i++) {
                min = INFINITY;

                for (int j = 1; j <= V; j++) {
                    if (v[j]) continue;
                    if (D[j] < min) {
                        min = D[j];
                        current = j;
                    }
                }

                v[current] = true;
                if (current == end) {
                    flag = true;
                    break;
                }

                for (int c = 1; c <= V; ++c) {
                    if (v[c]) continue;

                    if (matrix[current][c] == 0)
                        continue;

                    if (D[c] > min + matrix[current][c]){
                        D[c] = min+matrix[current][c];
                    }
                }
            }

            if (flag == false){
                sb.append("INF\n");
            }else{
                System.out.println(D[end]);
            }
        }
        System.out.println(sb.toString());
    }
}
