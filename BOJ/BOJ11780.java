import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ11780 {

	static final int Max_size = 100_000 * 100 + 1;
	static int N, M;
	static int[][] map;
	static int[][] next;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		next = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				next[i][j] = -1;
				map[i][j] = Max_size;
			}
		}

		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			int val = Integer.parseInt(input[2]);
			if (val < map[start][end]) {
				map[start][end] = val;
				next[start][end] = start;
			}
		}

		fw();
		
		System.out.print(PrintMap().toString());
		System.out.print(searchRoute().toString());
	}

	static StringBuilder searchRoute() {

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (next[i][j] == -1) {
					sb.append('0').append('\n');
				} else {

					Stack<Integer> path = new Stack<Integer>();
					int pre = j;
					path.push(pre);

					while (i != next[i][pre]) {
						pre = next[i][pre];
						path.push(pre);
					}
						
					sb.append(path.size() + 1 + " ");
					
					sb.append(i + " ");
					while(!path.isEmpty()) {
						sb.append(path.pop() + " ");
					}
					sb.append('\n');
				}
			}
		}

		return sb;
	}

	static void fw() { // 플로이드 워샬

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (i == k)
					continue;
				for (int j = 1; j <= N; j++) {
					if (j == k || i == j)
						continue;
					int val = map[i][k] + map[k][j];
					if (map[i][j] > val) {
						map[i][j] = val;
						next[i][j] = next[k][j];
					}
				}
			}
		}
	}

	static StringBuilder PrintMap() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] >= Max_size) {
					sb.append(0).append(' ');
					continue;
				}
				sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}
		return sb;
	}
}
