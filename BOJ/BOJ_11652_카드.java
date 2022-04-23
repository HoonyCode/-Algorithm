package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11652_카드 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Long, Data> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            if (map.containsKey(num)) {
                map.put(num, new Data(num, map.get(num).cnt + 1));
            }else map.put(num, new Data(num, 1));
        }

        Optional<Data> answer = map.values().stream().min(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1.cnt == o2.cnt)
                    return Long.compare(o1.num, o2.num);
                return Integer.compare(o2.cnt, o1.cnt);
            }
        });

        System.out.print(answer.get().num);
    }

    static class Data {
        long num;
        int cnt;

        public Data(long num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
