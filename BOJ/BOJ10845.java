import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Queue que = new LinkedList();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            if (input[0].equals("push")){

            }else if(input[0].equals("front")){

            }
        }
    }
}