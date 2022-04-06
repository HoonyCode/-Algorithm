package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_7568 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 키 몸무게
        // x, y x > p y > q

        int N = Integer.parseInt(br.readLine());

        Pair[] people = new Pair[N];

        String[] in;
        for (int i = 0 ; i < N ; i++){
            in  = br.readLine().split(" ");
            people[i] = new Pair(Integer.parseInt(in[0]), Integer.parseInt(in[1]));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < N ; i++){
            int cnt = 0;
            for (int j = 0 ; j < N ; j++){
                if (i == j) continue;
                if (people[i].height < people[j].height && people[i].weight < people[j].weight){
                    cnt++;
                }
            }
            sb.append(cnt+1).append(' ');
        }

        System.out.println(sb.toString());

    }

    static class Pair{
        int weight;
        int height;

        public Pair(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}
