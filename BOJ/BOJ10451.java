import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10451 {

    static int[] arr; // 배열
    static boolean[] v; // 방문 체크
    static int answer; // 답


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            v = new boolean[N + 1];
            String[] in = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                arr[j] = Integer.parseInt(in[j - 1]);
            }

            answer = 0;
            for (int j = 1; j <= N; j++) {
                if(v[j]) continue;
                bfs(j);
            }

            sb.append(answer).append('\n');
        }

        System.out.print(sb.toString());

    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        v[start] = true;

        int cur;
        int next;
        while (!que.isEmpty()){
            cur = que.poll();

            next = arr[cur];
            if (v[next]){
                answer++;
                break;
            }
            v[next] = true;
            que.offer(next);

        }
    }


}
