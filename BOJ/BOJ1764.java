package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1764 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in[] = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);

        HashSet<String> name = new HashSet<>();

        for (int i = 0; i < N; i++) {
            name.add(br.readLine());
        }

        List<String> list = new ArrayList<>();

        String input;
        for (int j = 0; j < M; j++) {
            input = br.readLine();
            if (name.contains(input)) {
                list.add(input);
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        sb.append(list.size()).append('\n');
        for (String str : list) {
            sb.append(str).append('\n');
        }

        System.out.println(sb.toString());

    }

}
