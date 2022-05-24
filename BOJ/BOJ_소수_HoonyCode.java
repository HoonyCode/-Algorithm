package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_소수_HoonyCode {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[10_001];

        arr[0] = true;
        arr[1] = true;

        for (int i = 2; i < 10_001; i++) {
            for (int j = 2; i * j < 10_001; j++) {
                arr[i * j] = true;
            }
        }

        List<Integer> list = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = M; i <= N; i++) {
            if (arr[i]) continue;

            min = Math.min(min, i);
            sum += i;
        }

        if (sum == 0){
            System.out.println(-1);
        }else{
            System.out.println(sum);
            System.out.println(min);
        }
    }

}
