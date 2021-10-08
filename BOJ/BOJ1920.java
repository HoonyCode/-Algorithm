import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            hashSet.add(Integer.parseInt(input[i]));
        }

        int M = Integer.parseInt(br.readLine());

        input = br.readLine().split(" ");

        for(int i = 0; i < M ; i++){
            int len = hashSet.size();

            hashSet.add(Integer.parseInt(input[i]));

            if(len == hashSet.size()){
                sb.append(1);
            }else{
                sb.append(0);
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}
