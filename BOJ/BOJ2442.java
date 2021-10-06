import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2442 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());
        for (int i = 1, j = 1 ; i <= N ; i++, j = j+2){
            for (int l = i ; l < N; l++) sb.append(" ");
            for (int k = 1 ; k <= j ; k++) sb.append("*");
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
