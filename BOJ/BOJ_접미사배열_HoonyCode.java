package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ_접미사배열_HoonyCode {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        List<String> list = new ArrayList<>();

        int len = str.length();

        for (int i = 0 ; i < len ; i++){
            list.add(str.substring(i));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (String answer : list) {
            sb.append(answer).append('\n');
        }

        System.out.print(sb.toString());
    }

}
