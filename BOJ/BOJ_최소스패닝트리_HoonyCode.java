package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_최소스패닝트리_HoonyCode {

    static int[] parent;
    static Edge[] edges;
    static int V, E;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        V = Integer.parseInt(in[0]);
        E = Integer.parseInt(in[1]);

        parent = new int[V + 1];
        edges = new Edge[E];


        int A, B, weight;
        for (int i = 0; i < E; i++) {
            in = br.readLine().split(" ");
            A = Integer.parseInt(in[0]);
            B = Integer.parseInt(in[1]);
            weight = Integer.parseInt(in[2]);
            edges[i] = new Edge(A, B, weight);
        }

        Arrays.sort(edges, (o1, o2) -> Integer.compare(o1.weight, o2.weight));

        int cnt = 0;
        long result = 0;

        initParents();

        for (Edge cur : edges) {

            if (!union(cur.A, cur.B)) continue;

            cnt++;
            result += cur.weight;
            if (cnt == V - 1) break;
        }

        System.out.println(result);

    }

    static void initParents() {

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
    }

    static int find(int x) {


        if (parent[x] == x) return x;

        return parent[x] = find(parent[x]);

    }

    static boolean union(int x, int y) {

        x = find(x);
        y = find(y);

        if (x == y) return false;
        parent[y] = x;
        return true;
    }

    static class Edge {
        int A;
        int B;
        int weight;

        public Edge(int a, int b, int weight) {
            A = a;
            B = b;
            this.weight = weight;
        }
    }
}
