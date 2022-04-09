import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW서로소집합 {

	private static void make(int[] parent, int V) {
		for (int i = 0; i <= V; i++) {
			parent[i] = i;
		}
	}

	private static int find(int a, int[] parent) {
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a], parent);
	}

	private static boolean union(int a, int b, int[] parent, boolean check) {
		int aRoot = find(a, parent);
		int bRoot = find(b, parent);
		if (aRoot == bRoot)
			return true;

		if (check)
			parent[bRoot] = aRoot;
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			int[] parent = new int[n + 1];

			make(parent, n);

			sb.append("#" + t + " ");
			for (int i = 0; i < m; i++) {
				input = br.readLine().split(" ");
				int num = Integer.parseInt(input[0]);
				int a = Integer.parseInt(input[1]);
				int b = Integer.parseInt(input[2]);
				if (num == 0) {
					union(a, b, parent, true);
				} else {
					if (union(a, b, parent, false))
						sb.append("1");
					else
						sb.append("0");
				}
			}

			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}