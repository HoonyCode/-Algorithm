package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_운동_HoonyCode {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 운동을 선택한 경우 맥박 + T
        // 1분 동안 운동한 후 맥박이 X + T
        // M을 넘는 것을 원하지 않음
        // 휴식을 하면 R 만큼 감소
        // m보다 작으면 맥박은 m이 된다

        String[] in = br.readLine().split(" ");

        int N = Integer.parseInt(in[0]); // 운동을 N 분 하는데 걸리는 시간
        int m = Integer.parseInt(in[1]);
        int M = Integer.parseInt(in[2]);
        int T = Integer.parseInt(in[3]);
        int R = Integer.parseInt(in[4]);

        // 현재 m 이다
        // M이 넘으며
        int now = m;
        int time = 0;
        int count = 0;

        if (m + T > M) {
            System.out.println(-1);
            return;
        }

        while (true) {
            if (count == N) break;

            if (now + T <= M) {
                now += T;
                count++;
            } else {
                now = Math.max(now - R, m);
            }

            time++;
        }

        System.out.println(time);
    }

}
