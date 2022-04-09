import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15663 {

	static int N, M;
	static int[] res, arr;
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		arr = new int[N];
		res = new int[N];

		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		v = new boolean[N];

		Arrays.sort(arr);

		dfs(0);

		System.out.print(sb.toString());
	}

	static void dfs(int cnt) {
		if (cnt == M) {

			for (int i = 0; i < M; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append('\n');

			return;
		}

		res[cnt] = 0;
		for (int i = 0; i < N; i++) {
			if (v[i] || res[cnt] >= arr[i])
				continue;
			v[i] = true;
			res[cnt] = arr[i];
			dfs(cnt + 1);
			v[i] = false;
		}
	}
}
