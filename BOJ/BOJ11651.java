import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine().trim());
        Pair[] pairs = new Pair[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().trim().split(" ");
            pairs[i] = new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        Arrays.sort(pairs,
                (o1, o2) -> {
                    if (o1.y == o2.y)
                        return o1.x - o2.x;
                    else
                        return o1.y - o2.y;
                });

        for (Pair out : pairs){
            sb.append(out.toString());
        }

        System.out.println(sb.toString());

    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return this.x + " " + this.y + "\n";
        }
    }
}
