import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1049_기타줄 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int m1 = Integer.MAX_VALUE;
        int m2 = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            m1 = Math.min(m1, Integer.parseInt(st.nextToken()));
            m2 = Math.min(m2, Integer.parseInt(st.nextToken()));
        }

        if (m1 >= m2 * 6) {
            res = m2 * N;
        } else {
            res = N / 6 * m1;
            if (N % 6 > 0) {
                res += Math.min(m1, N % 6 * m2);
            }
        }

        System.out.print(res);

    }
}