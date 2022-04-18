package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ_별자리만들기_HoonyCode {

    static int n;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parents = new int[n];

        String[] in;
        double x, y;

        Star[] stars = new Star[n];
        for (int i = 0; i < n; i++) {
            in = br.readLine().split(" ");
            stars[i] = new Star(Double.parseDouble(in[0]), Double.parseDouble(in[1]));
        }
        Double answer = 0d;

        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double weight = Math.pow(stars[i].x - stars[j].x, 2) + Math.pow(stars[i].y - stars[j].y, 2);
                weight = Math.pow(weight, 0.5d);
                list.add(new Edge(i, j, weight));
            }
        }

        Collections.sort(list, (o1, o2) -> Double.compare(o1.weight, o2.weight));

        init();

        int cnt = 0;
        for (Edge edge : list) {
            if (union(edge.to, edge.next)) continue;

            answer += edge.weight;
            cnt++;

            if (cnt == n - 1)
                break;

        }


        System.out.printf("%.2f", answer);

    }

    static class Edge {
        int to;
        int next;
        double weight;

        public Edge(int to, int next, double weight) {
            this.to = to;
            this.next = next;
            this.weight = weight;
        }
    }


    private static int find(int x) {
        if (x != parents[x])
            return parents[x] = find(parents[x]);

        return x;
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parents[y] = x;
            return false;
        }

        return true;
    }

    private static void init() {

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    static class Star {
        double x;
        double y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
