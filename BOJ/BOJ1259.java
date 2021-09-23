import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1259 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = "";

        loop : while (!(input = br.readLine()).equals("0")) {
            char[] N = input.toCharArray();

            for (int i = 0; i < N.length; i++) {
                if (N[i] != N[N.length - 1 - i]) {
                    sb.append("no\n");
                    continue loop;
                }
            }
            sb.append("yes\n");
        }

        System.out.println(sb.toString());

    }
}
