import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1929 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        boolean[] sosu = new boolean[1_000_001];

        sosu[0] = true;
        sosu[1] = true;

        for(int i = 2; i <= Math.sqrt(1_000_000) ; i++){
            for(int j = 2 ; j*i <= 1_000_000 ; j++){
                sosu[i*j] = true;
            }
        }

        for(int i = N ; i <= M ; i++){
            if(!sosu[i])
                sb.append(i+"\n");
        }

        System.out.println(sb.toString());

    }
}
