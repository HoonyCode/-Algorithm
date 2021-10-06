import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ17471 {
    static int N;
    static int[] cnt; // 구역의 사람 수
    static int Min = Integer.MAX_VALUE;
    static ArrayList<Integer>[] adjlist;
    static ArrayList<Integer> A = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        cnt = new int[N + 1];
        adjlist = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adjlist[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) cnt[i] = Integer.parseInt(input[i - 1]);

        for (int i = 1; i <= N; i++) {
            input = br.readLine().split(" ");
            for (int j = 1; j <= Integer.parseInt(input[0]); j++) {
                adjlist[i].add(j);
            }
        }

        if (Min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else
            System.out.println();
    }

    static void Combi(int start, int cnt){
        if (cnt == N){

        }

        for (int i = start; i <= N ; i++){
            A.add(i);
            Combi(start+1, cnt+1);
        }

    }
}
