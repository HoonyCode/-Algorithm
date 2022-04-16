package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_흩날리는시험지속에서내평점이느껴진거야 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int K = Integer.parseInt(in[1]);

        Integer[] arr = new Integer[N];

        in = br.readLine().split(" ");
        for (int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(in[0]);
        }

        Arrays.sort(arr, (o1, o2) -> -Integer.compare(o1,o2));


    }
}
