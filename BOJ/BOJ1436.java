import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] res = new String[N];

        int i = 0;
        int number = 666;
        while (i != N) {
            String input = number++ + "";
            if(input.indexOf("666") != -1) {
                res[i] = input;
                i++;
            }
        }

        System.out.println(res[N-1]);

    }
}
