package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_숫자카드_HoonyCode {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();

        String[] in = br.readLine().split(" ");

        for (int i = 0 ; i < N ; i++){
            set.add(Integer.parseInt(in[i]));
        }

        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        in = br.readLine().split(" ");
        for (int i = 0 ; i < M ; i++){
            if (set.contains(Integer.parseInt(in[i]))){
                sb.append(1);
            }else{
                sb.append(0);
            }
            sb.append(' ');
        }

        System.out.print(sb);

    }
}
