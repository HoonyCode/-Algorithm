import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MatchGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2609 {

    private static final int Max = 10_001;
    static int[][] arr = new int[2][Max];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        makeArr(A, 0);
        makeArr(B, 1);

        int max = Math.max(A, B);
        int res1 = 1;
        int res2 = 1;
        
        for (int i = 2; i <= max; i++) {
            if (arr[0][i] == 0 && arr[1][i] == 0) continue;
            res2 *= Math.pow(i, Math.max(arr[0][i], arr[1][i]));
            res1 *= Math.pow(i, Math.min(arr[0][i], arr[1][i]));
        }

        System.out.println(res1);
        System.out.println(res2);
    }

    static void makeArr(int Num, int cnt) {
        for (int i = 2; i <= Num; i++) {
            if (Num == 1) break;
            if (Num % i == 0) {
                Num /= i;
                arr[cnt][i]++;
                i--;
            }
        }
    }
}
