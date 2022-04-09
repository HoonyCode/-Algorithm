import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1085 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int w = Integer.parseInt(input[2]);
        int h = Integer.parseInt(input[3]);

        int min1 = Math.min(x - 0, w - x);
        int min2 = Math.min(y - 0, h - y);
        int res = Math.min(min1, min2);
        System.out.println(res);

    }
}
