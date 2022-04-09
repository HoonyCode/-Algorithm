import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2480 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int[] dice = {Integer.parseInt(in[0]), Integer.parseInt(in[1]), Integer.parseInt(in[2])};
        Arrays.sort(dice);

        if (dice[0] == dice[2]){
            System.out.println(10000 + dice[0] * 1000);
        }else if (dice[0] == dice[1]){
            System.out.println(1000 + dice[1] * 100);
        }else if (dice[1] == dice[2]){
            System.out.println(1000 + dice[1] * 100);
        }else {
            System.out.println(100 * dice[2]);
        }
    }
}
