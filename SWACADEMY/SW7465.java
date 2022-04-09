import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW7465 {
	static int N, M;
	static int[] parents;

	private static void make() {
		parents = new int[N];
		for (int i = 1; i < N; i++) {
			parents[i] = i;
		}

	}

	private static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]) + 1;
			M = Integer.parseInt(input[1]);

			make();
			
			for (int i = 0; i < M; i++) {
				input = br.readLine().split(" ");
				int from, to;
				from = Integer.parseInt(input[0]);
				to = Integer.parseInt(input[1]);
				union(from, to);
			}
			int answer = 0;
			
			for(int i = 1; i < N ; i++) {
				if(i == parents[i]) answer++;
			}

			sb.append("#" + t + " "+ answer + "\n");
		}
		System.out.println(sb.toString());
	}
}
