import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        for (int i = 0 ; i < N ; i++){
            list.add(Integer.parseInt(input[0]));
        }
        int M = Integer.parseInt(br.readLine());

    }
}
