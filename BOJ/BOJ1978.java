import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] sosu = new boolean[1001];
        sosu[1] = true;

        for (int i = 2 ; i <= 1000 ; i++){
            for(int j = 2 ; i*j <= 1000; j++){
                sosu[i*j] = true;
            }
        }

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        String[] input = br.readLine().trim().split(" ");
        for (int i = 0 ; i < N ; i++){
            if(!sosu[Integer.parseInt(input[i])]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
