import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1783 {

    static int V, E;
    static int startV;
    static ArrayList<Date>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().trim().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        startV = Integer.parseInt(br.readLine());

        list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<Date>();
        }

        int v1;
        int v2;
        int weight;

        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            v1 = Integer.parseInt(input[0]);
            v2 = Integer.parseInt(input[1]);
            weight = Integer.parseInt(input[2]);
            list[v1].add(new Date(v2, weight));
        }


        bfs();
        System.out.println(sb.toString());

    }

    static void bfs() {
        int[] res = new int[V + 1];
        boolean[] v = new boolean[V + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        PriorityQueue<Date> que = new PriorityQueue<>();
        que.offer(new Date(startV, 0));
        res[startV] = 0;

        int cur;
        while (!que.isEmpty()) {
            cur = que.poll().V;

            if (v[cur]) continue;
            v[cur] = true;

            for (Date temp : list[cur]) {
                if (res[temp.V] > res[cur] + temp.weight) {
                    res[temp.V] = res[cur] + temp.weight;
                    que.offer(new Date(temp.V, res[temp.V]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
                continue;
            }
            sb.append(res[i] + "\n");
        }
    }


    static class Date implements Comparable<Date>{
        int V, weight;
        public Date(int v, int weight) {
            V = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Date o) {
            return weight - o.weight;
        }
    }
}
