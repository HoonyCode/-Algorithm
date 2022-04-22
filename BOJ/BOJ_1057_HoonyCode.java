package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1057_HoonyCode {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, A, B;

        String[] in = br.readLine().split(" ");
        N = Integer.parseInt(in[0]);
        A = Integer.parseInt(in[1]);
        B = Integer.parseInt(in[2]);

        int cnt = 1;

        while (true){
            if (A % 2 == 1) A++;
            if (B % 2 == 1) B++;

            if (A == B) break;
            cnt++;
            A /=2;
            B /=2;
        }

        System.out.println(cnt);



    }

}
