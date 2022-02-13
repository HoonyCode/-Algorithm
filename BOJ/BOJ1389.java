import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ1389 {

    static int N, M; // 유저의 수, 친구 관계의 수 유저는 수는 1부터시작
    static List<Integer>[] friendList;
    static Pair answer = new Pair(0, Integer.MAX_VALUE);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        N = Integer.parseInt(in[0]);
        M = Integer.parseInt(in[1]);

        friendList = new List[N + 1];

        for (int i = 1; i < N + 1; i++) {
            friendList[i] = new ArrayList<>();
        }

        int A, B;
        for (int i = 0; i < M; i++) {
            in = br.readLine().split(" ");
            A = Integer.parseInt(in[0]);
            B = Integer.parseInt(in[1]);

            friendList[A].add(B);
            friendList[B].add(A);
        }

        for (int i = 1; i < N + 1; i++) {
            bfs(i);
        }

        System.out.println(answer.num);

    }

    private static void bfs(int start) {
        boolean[] v = new boolean[N + 1];
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(start, 0));
        v[start] = true;

        int cnt = 0;
        Pair cur;
        while (!que.isEmpty()) {
            cur = que.poll();
            cnt += cur.weight;

            if (cnt >= answer.weight) return;

            for (Integer to : friendList[cur.num]) {
                if (v[to]) continue;
                v[to] = true;
                que.offer(new Pair(to, cur.weight + 1));
            }
        }

        answer.num = start;
        answer.weight = cnt;
    }

    static class Pair {
        int num;
        int weight;

        public Pair(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
}
