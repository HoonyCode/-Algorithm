import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for (Integer res : list){
            bw.append(res + "\n");
        }

        bw.flush();

    }
}
