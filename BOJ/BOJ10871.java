import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int X = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        for (int i = 0; i < input.length ; i++){
            if(Integer.parseInt(input[i]) < X)
                sb.append(input[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
