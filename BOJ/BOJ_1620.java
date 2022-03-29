package BackJun;

import java.util.*;
import java.io.*;

public class BOJ_1620 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int M = Integer.parseInt(in[0]);
        int N = Integer.parseInt(in[1]);

        Map<String, String> map = new HashMap<>();


        String str;
        for (int i = 1; i <= M; i++) {
            str = br.readLine();
            map.put(str, Integer.toString(i));
            map.put(Integer.toString(i), str);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            sb.append(map.get(str)).append('\n');
        }

        System.out.print(sb.toString());
    }

}
