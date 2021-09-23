import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ4153 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;
        while (true) {
            input = br.readLine().trim().split(" ");
            int[] number = new int[3];
            for (int i = 0; i < 3; i++) {
                number[i] = Integer.parseInt(input[i]);
            }
            if (number[0] == 0 && number[1] == 0 && number[2] == 0)
                break;
            Arrays.sort(number); // 오름차순
            if (number[0] * number[0] + number[1] * number[1] == number[2] * number[2])
                sb.append("right").append("\n");
            else
                sb.append("wrong").append("\n");
        }

        System.out.println(sb.toString());
    }
}
