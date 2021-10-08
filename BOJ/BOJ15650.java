import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {
	static int N, M;
	static int[] res;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		res = new int[M + 1];
		res[0] = 0;

		dfs(1);
	}

	static void dfs(int dept) {

		if (dept == M + 1) {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= M; i++) {
				sb.append(res[i] + " ");
			}
			System.out.println(sb.toString());
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (res[dept - 1] >= i)
				continue;
			res[dept] = i;
			dfs(dept + 1);
		}

		return;

	}
}
