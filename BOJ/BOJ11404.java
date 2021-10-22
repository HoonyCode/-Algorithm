import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11404 {

	static int N;
	static int[][] map;
	static final int map_Max = 100000 * 100 + 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = map_Max;
			}
		}

		for (int i = 0; i < K; i++) {
			String[] input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]) - 1;
			int end = Integer.parseInt(input[1]) - 1;
			int value = Integer.parseInt(input[2]);
			
			map[start][end] = Math.min(map[start][end], value);
			
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (k == i)
					continue;
				for (int j = 0; j < N; j++) {
					if (i == j || k == j)
						continue;
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] >= map_Max) {
					sb.append(0).append(' ');
					continue;
				}
				sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}

		System.out.print(sb.toString());

	}
}
