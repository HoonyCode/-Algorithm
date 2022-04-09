import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int num = Integer.parseInt(in[0]) * 60 + Integer.parseInt(in[1]);
        num += Integer.parseInt(br.readLine());

        int hour = num / 60 % 24;
        int min = num % 60;

        System.out.println(hour + " " + min);

    }

}
