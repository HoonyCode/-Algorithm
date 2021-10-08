import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15651 {

	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		res = new int[M];

		dfs(0);

		System.out.print(sb.toString());
	}

	static void dfs(int dept) {

		if (dept == M) {
			for (int i = 0; i < M; i++) {
				sb.append(res[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			res[dept] = i;
			dfs(dept + 1);
		}
		return;
	}

}
