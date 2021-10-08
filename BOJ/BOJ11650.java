import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ11650 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Pair> pairs = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N ; i++){
            String[] input = br.readLine().trim().split(" ");
            pairs.add(new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }
        Collections.sort(pairs);

        for(int i = 0 ; i < N ; i++){
            sb.append(pairs.get(i).toString());
        }
        System.out.println(sb.toString());
    }

    static class Pair implements Comparable<Pair>{

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.x == o.x){
                return this.y - o.y;
            }
            return this.x - o.x;
        }

        @Override
        public String toString() {
            return x+" "+y+"\n";
        }
    }
}
