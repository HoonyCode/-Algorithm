package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class BOJ_11652 {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Long, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        Long temp;
        for (int i = 0 ; i < N ; i++){
            temp = Long.parseLong(br.readLine());

            if (map.containsKey(temp)){
                map.replace(temp, map.get(temp) + 1);
            }else {
                map.put(temp,1);
            }
        }

        Long answer = Long.MAX_VALUE;
        int cnt = 0;

        for (Map.Entry<Long, Integer> cur : map.entrySet()) {
            Long key = cur.getKey();
            Integer value = cur.getValue();

            if (value >= cnt){
                if (cnt == value){
                    answer = Math.min(answer, key);
                }else {
                    answer = key;
                }
                cnt = value;
            }
        }

        System.out.print(answer);

    }
}
