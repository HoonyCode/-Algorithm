package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_두용액_HoonyCode {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] in = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(in[i]);
        }
        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;

        Answer answer = new Answer(arr[left], arr[right]);

        while (left != right) {
            int sum = arr[left] + arr[right];

            if (answer.Sum() > Math.abs(sum)) {
                answer.left = arr[left];
                answer.right = arr[right];
            }

            if (sum < 0){
                left++;
            }else {
                right--;
            }
        }

        System.out.println(answer.toString());

    }

    static class Answer {
        int left;
        int right;

        public Answer(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int Sum() {
            return Math.abs(left + right);
        }

        @Override
        public String toString() {
            return left + " " + right;
        }
    }
}
