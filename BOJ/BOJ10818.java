import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ10818 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N ; i++){
            arr[i] = sc.nextInt();
        }

        int min, max;

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
