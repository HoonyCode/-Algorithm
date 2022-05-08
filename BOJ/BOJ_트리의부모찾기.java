package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_트리의부모찾기 {
    static List<Integer>[] node;
    static boolean[] v;
    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // root 는 1번
        int[] parents = new int[N + 1];
        v = new boolean[N + 1];

        node = new List[N + 1];

        for (int i = 0; i <= N; i++) {
            node[i] = new ArrayList<>();
        }

        int start, end;
        for (int i = 0; i < N - 1; i++) {
            String[] in = br.readLine().split(" ");
            start = Integer.parseInt(in[0]);
            end = Integer.parseInt(in[1]);

            node[start].add(end);
            node[end].add(start);
        }


        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);

        int cur;

        while (!queue.isEmpty()) {
            cur = queue.poll();

            for (int temp : node[cur]) {
                if (v[temp]) continue;
                v[temp] = true;
                parents[temp] = cur;
                queue.offer(temp);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append('\n');
        }

        System.out.print(sb);

    }
}
