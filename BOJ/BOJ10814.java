import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayList<Data> list = new ArrayList<>();
        String[] input;
        for (int i = 0; i <N ; i++){
            input = br.readLine().split(" ");
            list.add(new Data(Integer.parseInt(input[0]), input[1]));
        }
        Collections.sort(list);

        for (int i = 0; i < N ; i++){
            sb.append(list.get(i).toString());
        }
        System.out.println(sb.toString());
    }

    static class Data implements Comparable<Data> {
        int num;
        String name;

        public Data(int num, String name) {
            this.num = num;
            this.name = name;
        }

        @Override
        public int compareTo(Data o) {
            return this.num - o.num;
        }

        @Override
        public String toString() {
            return this.num + " " + this.name + "\n";
        }
    }
}
