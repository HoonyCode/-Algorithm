import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1 ; i <= N ; i++){
            que.offer(i);
        }
        int cnt = 0;
        int cur;
        sb.append('<');
        while (!que.isEmpty()) {
            cnt++;
            cur = que.poll();
            if (cnt == K) {
                cnt = 0;
                sb.append(cur + ", ");
                continue;
            }
            que.offer(cur);
        }

        sb.replace(sb.lastIndexOf(","),sb.length(),">");
        System.out.println(sb.toString());
    }
}
