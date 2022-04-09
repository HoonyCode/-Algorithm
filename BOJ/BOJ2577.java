import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int[] res = new int[10];
        char[] c = (A*B*C+"").toCharArray();

        for(int i = 0; i < c.length; i++){
            res[(int)c[i] - '0' ]++;
        }

        for (int i = 0 ; i < 10; i++){
            System.out.println(res[i]);
        }


    }
}
