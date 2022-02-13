import java.util.Scanner;

public class BOJ2748 {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N+1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2 ; i <= N ; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(arr[N]);
    }
}
