import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SW3307 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");

			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}

			sb.append("#" + t + " " + doLIS3(arr) + "\n"); // NlongN으로 구하기
		}
		System.out.println(sb.toString());
	}

	static int doLIS3(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		int idx = 0;
//		System.out.println(Arrays.toString(dp));
		for (int i = 1; i < arr.length; i++) {
			if (dp[idx] < arr[i]) {
				dp[++idx] = arr[i];
			} else {
				int ii = lower_bound(dp, idx, arr[i]);
				dp[ii] = arr[i];
			}
//			System.out.println(Arrays.toString(dp));
		}
		return idx + 1;
	}

	static int lower_bound(int[] dp, int end, int n) {
		int start = 0;

		while (start < end) {
			int mid = (start + end) / 2;
			if (dp[mid] >= n) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}
}