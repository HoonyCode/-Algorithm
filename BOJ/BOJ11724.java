import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ11724 {

    static boolean[] v; // 탐색 한지 나타내는 boolean
    static int N, M; // 정점의 개수 , 간선의 개수
    static List<Integer>[] edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        N = Integer.parseInt(in[0]);
        M = Integer.parseInt(in[1]);

        edgeList = new List[N+1];
        v = new boolean[N+1];
        for (int i = 1 ; i <= N ; i++) {
            edgeList[i] = new ArrayList<>();
        }

        int start, end;
        for (int i = 0; i < M ; i++) {
            in = br.readLine().split(" ");
            start = Integer.parseInt(in[0]);
            end = Integer.parseInt(in[1]);
            edgeList[start].add(end);
            edgeList[end].add(start);
        }

        int answer = 0;
        for (int i = 1 ; i < N+1 ; i++){
            if (v[i]) continue;
            bfs(i);
            answer++;
        }

        System.out.println(answer);
    }

    private static void bfs(int i) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(i);
        v[i] = true;

        int cur;
        while (!que.isEmpty()){
            cur = que.poll();

            for (int next : edgeList[cur]){
                if (v[next]) continue;
                v[next] = true;
                que.offer(next);
            }
        }
    }
}
