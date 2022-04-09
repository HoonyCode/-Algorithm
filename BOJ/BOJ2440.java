import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2440 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();


        for (int i = N; i > 0; i--) {
            for (int j = 1; j <= i; j++)
                sb.append("*");
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
