import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ1026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] A = new Integer[N];
        int[] B = new int[N];

        String[] in = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(in[i]);


        in = br.readLine().split(" ");
        for (int j = 0; j < N; j++)
            B[j] = Integer.parseInt(in[j]);


        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B);

        int answer = 0;
        for (int i = 0; i < N ; i++){
            answer += A[i] * B[i];
        }
        System.out.println(answer);
    }
}
