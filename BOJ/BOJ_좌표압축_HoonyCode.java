package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_좌표압축_HoonyCode {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Pair[] map = new Pair[N];

        String[] in = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            map[i] = new Pair(Integer.parseInt(in[i]), i);
        }

        Arrays.sort(map, (o1, o2) -> Integer.compare(o1.val, o2.val));

        int[] answer = new int[N];

        int currentNum = map[0].val;
        int grade = 0;

        answer[map[0].idx] = grade;

        for (int i = 1; i < N; i++) {
            if (currentNum < map[i].val) {
                grade++;
                currentNum = map[i].val;
            }

            answer[map[i].idx] = grade;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < N ; i++){
            sb.append(answer[i]).append(' ');
        }

        System.out.print(sb);


    }

    static class Pair {
        int val, idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
