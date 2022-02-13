import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ15886 {

    static boolean[] v; // 방문 체크
    static int answer = 0; // 답
    static char[] map; // 배열 받을꺼

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = br.readLine().toCharArray();
        v = new boolean[N];

        for (int i = 0; i < N; i++){
            if (v[i]) continue;
            bfs(i);
        }
        System.out.println(answer);
    }

    private static void bfs(int start) {
        v[start] = true;
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);

        int cur;
        int next;
        while (!que.isEmpty()){
            cur = que.poll();
            next = cur + (map[cur] == 'E' ? 1 : -1);

            if (map[cur] != map[next]){
                v[next] = true;
                break;
            }
            if (v[next]){
                return;
            }
            que.offer(next);
            v[next] = true;
        }

        answer++;
    }
}
