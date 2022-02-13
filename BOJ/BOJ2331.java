import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2331 {

    static int A, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] count = new int[300000]; // => 9999 / 5

        String[] in = br.readLine().split(" ");
        A = Integer.parseInt(in[0]);
        C = Integer.parseInt(in[1]);

        List<Integer> list = new ArrayList<>();

        count[A]++;
        list.add(A);

        int answer = 0;
        int num = A;
        while (true) {
            num = Make(num);
            list.add(num);
            count[num]++;
            if (count[num] == 2) {
                answer = list.indexOf(num);
                break;
            }
        }

        System.out.println(answer);

    }

    private static int Make(int a) {
        int result = 0;

        // a = 1111;
        int num = 0;
        for (int i = 0; i < 5; i++) {
            num = a % 10;
            a /= 10;

            int c = 1;
            for (int j = 0; j < C; j++) {
                c *= num;
            }

            result += c;
        }

        return result;
    }


}
