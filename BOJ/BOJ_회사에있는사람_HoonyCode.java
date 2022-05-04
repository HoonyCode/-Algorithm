package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_회사에있는사람_HoonyCode {

    //현재 회사에 있는 모든 사람을 구하는 프로그램을 작성하시오

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();


        for (int i = 0 ; i < N ; i++){
            String[] in = br.readLine().split(" ");
            map.put(in[0], in[1]);
        }

        List<String> list = new ArrayList<>();

        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            if (stringStringEntry.getValue().equals("enter")) {
                list.add(stringStringEntry.getKey());
            }
        }

        Collections.sort(list, ((o1, o2) -> -o1.compareTo(o2)));

        StringBuilder sb = new StringBuilder();

        for (String result : list) {
            sb.append(result).append('\n');
        }

        System.out.print(sb.toString());

    }

}
