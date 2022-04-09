import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ7696 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();


        List<Integer> list = new ArrayList<>();
        int num = 0;
        int num2 = 0;

        boolean[] v = new boolean[10];
        loop:
        while (list.size() != 1_000_000) {
            num++;
            num2 = num;

            Arrays.fill(v, false);
            while (num2 != 0) {
                if (v[num2 % 10]) continue loop;
                v[num2 % 10] = true;
                num2 /= 10;
            }
            list.add(num);
        }


        int answer;
        while ((answer = sc.nextInt()) != 0) {
            sb.append(list.get(answer - 1)).append('\n');
        }

        System.out.print(sb.toString());
    }
}