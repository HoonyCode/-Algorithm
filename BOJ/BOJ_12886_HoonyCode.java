package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_12886_HoonyCode {

    public static void main(String[] args) throws Exception{
        int A,B,C;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");

        A = Integer.parseInt(in[0]);
        B = Integer.parseInt(in[1]);
        C = Integer.parseInt(in[2]);

        if (bfs(new int[]{A, B, C}))
            System.out.println(1);
        else
            System.out.println(0);

    }

    private static boolean bfs(int[] arr) {
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(arr[0], arr[1], arr[2]));

        Set<Data> set = new HashSet<>();

        Data cur;

        while (!queue.isEmpty()) {
            cur = queue.poll();

            if (cur.A == cur.C) {
                return true;
            }

            if (set.contains(cur)) continue;

            set.add(cur);


            if (cur.A != cur.B) {
                queue.offer(new Data(cur.A + cur.A, cur.B - cur.A, cur.C));
            }

            if (cur.B != cur.C) {
                queue.offer(new Data(cur.A, cur.B + cur.B, cur.C - cur.B));
            }
            queue.offer(new Data(cur.A + cur.A, cur.B, cur.C - cur.A));
        }

        return false;
    }

    static class Data {
        int A, B, C;

        public Data(int a, int b, int c) {
            int[] arr = new int[]{a,b,c};
            Arrays.sort(arr);

            A = arr[0];
            B = arr[1];
            C = arr[2];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Data data = (Data) o;
            return A == data.A && B == data.B && C == data.C;
        }

        @Override
        public int hashCode() {
            return Objects.hash(A, B, C);
        }
    }
}
