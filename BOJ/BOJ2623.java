import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2623 {

    static int N, M;
    static HashSet<Integer>[] hashSets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        hashSets = new HashSet[N + 1];
        for (int i = 1; i <= N; i++) hashSets[i] = new HashSet<>();

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int P = Integer.parseInt(input[0]); // 각 줄의 개수

            for (int j = 1; j < P; j++) {
                for (int k = j + 1; k <= P; k++) {
                    hashSets[Integer.parseInt(input[j])].add(Integer.parseInt(input[k]));
                }
            }
        }

        topologiSort();
        return;

    }

    static void topologiSort() {
        Queue<Integer> que = new LinkedList<>();
        boolean check[] = new boolean[N+1];
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 1 ; i <= N ; i++){
            if (hashSets[i].isEmpty()){
                que.offer(i);
                res.add(i);
                check[i] = true;
            }
        }
        int hashIndex;
        while (!que.isEmpty()){
            hashIndex = que.poll();
            for (int i = 1 ; i <= N ; i++){
                if (check[i]) continue;
                if (!hashSets[i].remove(new Integer(hashIndex))) continue;

                if (hashSets[i].isEmpty()){
                    res.add(i);
                    que.offer(i);
                    check[i] = true;
                }
            }
        }

        if (res.size() < N){
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = res.size()-1 ; i > -1 ; i--){
            sb.append(res.get(i)).append('\n');
        }

        System.out.print(sb.toString());

    }
}