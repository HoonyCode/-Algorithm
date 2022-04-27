package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_패션황신해빈 {

    public static void main(String[] args) throws Exception {
        Map<String, Integer> map = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            map.clear();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String[] in = br.readLine().split(" ");
                if (map.containsKey(in[1])) {
                    map.put(in[1], map.get(in[1]) + 1);
                } else {
                    map.put(in[1], 1);
                }
            }

            int cnt = 1;

            for (Integer temp : map.values()) {
                cnt *= (temp+1);
            }
            sb.append(cnt-1).append('\n');
        }

        System.out.print(sb.toString());
    }
}
