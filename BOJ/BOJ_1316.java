package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1316 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        boolean[] v = new boolean['z' - 'a' + 1];
        loop : for (int i = 0; i < N; i++) {
            Arrays.fill(v, false);
            char[] chars = br.readLine().toCharArray();
            char nowChar = chars[0];
            v[nowChar - 'a'] = true;


            for (int j = 1; j < chars.length; j++) {
                if (nowChar != chars[j]){
                    if (v[chars[j] - 'a']) continue loop;

                    //없다면
                    v[chars[j] - 'a'] = true;
                    nowChar = chars[j];
                }
            }

            answer++;
        }

        System.out.println(answer);


    }
}
