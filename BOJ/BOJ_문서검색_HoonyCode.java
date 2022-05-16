package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_문서검색_HoonyCode {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String search = br.readLine();

        String finish = str.replaceAll(search, "");

        int subLen = str.length() - finish.length();

        int answer = subLen / search.length();

        System.out.println(answer);
    }

}
