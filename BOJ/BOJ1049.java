import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ1049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, m;
        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);

        int jul6 = Integer.MAX_VALUE;
        int jul1 = Integer.MAX_VALUE;

        for (int i = 0 ; i < m;  i++) {
            in = br.readLine().split(" ");
            jul6 = Integer.min(jul6, Integer.parseInt(in[0]));
            jul1 = Integer.min(jul1, Integer.parseInt(in[1]));
        }

        if (jul6 >= 6 * jul1){
            System.out.println(jul1 * n);
        }else{

            if (n % 6 == 0){
                System.out.println( n/6 * jul6);
            }else{
                int min = jul6 / jul1;

                if (n % 6 > min){
                    System.out.println((n/6 + 1) * jul6);
                }else{
                    int answer = (n/6) * jul6 + (n%6) * jul1;
                    System.out.println(answer);
                }

            }

        }



    }
}
