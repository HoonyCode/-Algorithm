import java.io.*;

public class BOJ17435 {

    static int[][] sparseTable;
    static int logn = 20;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        m = Integer.parseInt(br.readLine());

        sparseTable = new int[logn][m + 1];

//      f(1) f(2) f(3) ... f(n);
        String[] in = br.readLine().split(" ");
        for (int i = 1; i <= m; i++)
            sparseTable[0][i] = Integer.parseInt(in[i - 1]);

        makeSparseTable();

        //쿼리 개수 Q가 주어진다.
        int Q = Integer.parseInt(br.readLine());
        //fn(x) 가 주어진다.
        // n과 x가 주어진다.
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            in = br.readLine().split(" ");
            sb.append(query(Integer.parseInt(in[0]), Integer.parseInt(in[1]))).append('\n');
        }
        System.out.print(sb.toString());
    }

    // v 정점에서 출발하여 n개의 간선을 이동하여 도착한 정점 찾기
    public static int query(int n, int v) {
        for (int bit = Integer.toBinaryString(n).length(); bit >= 0; bit--) {
            if ((n & (1 << bit)) != 0) v = sparseTable[bit][v];
        }
        return v;
    }

    public static void makeSparseTable() {
        //log n번 까지 이동해서 도착하는 정점
        for (int k = 1; k < logn; k++) {
            for (int i = 1; i <= m; i++) {
                sparseTable[k][i] = sparseTable[k - 1][sparseTable[k - 1][i]];
            }
        }
    }
}