import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int res = 0;

        br.readLine();
        char[] input = br.readLine().toCharArray();
        for(char val : input){
            res += val-'0';
        }

        System.out.println(res);
    }
}
