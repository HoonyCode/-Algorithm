import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SW5643 {

    static ArrayList<Integer>[] list;
    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            M = Integer.parseInt(br.readLine().trim());

            list = new ArrayList[N + 1];
            arr = new int[N + 1];
            for (int i = 1; i <= N; i++){
                list[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < M; i++) {
                String[] input = br.readLine().trim().split(" ");
                list[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
            }

            for (int i = 1; i <= N; i++) {
                bfs(i);
            }

            int res = 0;
            for (int i = 1; i < N + 1; i++) {
                if (arr[i] == N) res++;
            }

            sb.append("#" + t + " " + res + "\n");

        }

        System.out.println(sb.toString());
    }

    static void bfs(int start) {
        boolean[] v = new boolean[N + 1];
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        v[start] = true;

        int cur;
        int total = 0;
        while (!que.isEmpty()) {
            cur = que.poll();

            for (int next : list[cur]) {
                if (v[next]) continue;
                v[next] = true;
                total++;
                arr[next]++;
                que.offer(next);
            }
        }

        arr[start] += total + 1;
    }
}
