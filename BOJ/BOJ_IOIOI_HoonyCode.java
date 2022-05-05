package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_IOIOI_HoonyCode {


    // N + 1 개의 I 와 N 개의 o로 이루어져 있으면, I 와 O 이 교대로 나오는 문자열릉 Pn이라고 한다


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();

        int answer = 0;

        int startIdx;
        int cnt = 0;
        loop:
        for (int i = 0; i < M; i++) {
            if (chars[i] != 'I') continue;

            startIdx = i;
            int len = 0;
            cnt = N;
            while (true) {
                if (startIdx + 1 >= M || startIdx + 2 >= M) break;
                if (chars[startIdx + 1] != 'O') break;
                if (chars[startIdx + 2] != 'I') break;
                startIdx += 2;
                len++;
            }
            if (len >= N) {
                answer += len - N + 1;
            }
            i = startIdx;
        }

        System.out.println(answer);
    }

}
