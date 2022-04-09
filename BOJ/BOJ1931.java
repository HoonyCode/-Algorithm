import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Pair> pairs = new ArrayList<>();
        String[] input;
        for (int i = 0; i < N; i++){
            input = br.readLine().trim().split(" ");
            pairs.add(new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        Collections.sort(pairs);

        ArrayList<Pair> meetList = new ArrayList<>();
        meetList.add(pairs.get(0));

        for (int i = 1 ; i < pairs.size(); i++){
            if (meetList.get(meetList.size()-1).end <= pairs.get(i).start){
                meetList.add(pairs.get(i));
            }
        }

        System.out.println(meetList.size());


    }


    static class Pair implements Comparable<Pair>{
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.end == o.end){
                return start - o.start;
            }
            return end - o.end;
        }
    }
}
