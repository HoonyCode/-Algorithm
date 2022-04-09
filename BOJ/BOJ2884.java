import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int hour = Integer.parseInt(input[0]);
        int min = Integer.parseInt(input[1]);

        int time = hour*60 + min - 45;
        if(time < 0)
            time += 24*60;

        hour = time/60;
        min = time%60;

        System.out.println(hour + " " + min);

    }
}
