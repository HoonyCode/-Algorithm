import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ12100 {

	static int N;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		res = 0;
		dfs(map, 0);
		System.out.println(res);
	}

	private static void dfs(int[][] map, int cnt) {
		if (cnt == 5) {
			result(map);
			return;// 종료
		}

		dfs(up(map), cnt + 1);
		dfs(down(map), cnt + 1);
		dfs(right(map), cnt + 1);
		dfs(left(map), cnt + 1);

	}

	private static void result(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (res < map[i][j]) {
					res = map[i][j];
				}
			}
		}
	}

	static int[][] up(int[][] map) {
		int[][] nowmap = new int[N][N];

		// 올리기
		for (int i = 0; i < N; i++) { // 열
			int val = 0;
			int pre = 0;
			int row = 0;
			while (row != N) {

				if (val == 0) {
					if (map[row][i] > 0) {
						val = map[row][i];
					}
					row++;
					continue;
				}
				// val 같은 수 일때
				if (map[row][i] == val) {
					nowmap[pre][i] = val << 1;
					val = 0;
					pre++;
				} else if (map[row][i] > 0) { // 다른 수 일때
					nowmap[pre][i] = val;
					val = map[row][i];
					pre++;
				}
				row++;
			}
			if (val != 0) {
				nowmap[pre][i] = val;
			}
		}

		return nowmap;
	}

	static int[][] down(int[][] map) {
		int[][] nowmap = new int[N][N];

		// 내리기
		for (int i = 0; i < N; i++) { // 열
			int val = 0;
			int pre = N - 1;
			int row = N - 1;
			while (row != -1) {

				if (val == 0) {
					if (map[row][i] > 0) {
						val = map[row][i];
					}
					row--;
					continue;
				}
				// val 같은 수 일때
				if (map[row][i] == val) {
					nowmap[pre][i] = val << 1;
					val = 0;
					pre--;
				} else if (map[row][i] > 0) { // 다른 수 일때
					nowmap[pre][i] = val;
					val = map[row][i];
					pre--;
				}
				row--;
			}
			if (val != 0) {
				nowmap[pre][i] = val;
			}
		}

		return nowmap;
	}

	static int[][] right(int[][] map) {
		int[][] nowmap = new int[N][N];

		// 왼쪽으로 밀기
		for (int i = 0; i < N; i++) { // 열
			int val = 0;
			int pre = N - 1;
			int col = N - 1;
			while (col != -1) {

				if (val == 0) {
					if (map[i][col] > 0) {
						val = map[i][col];
					}
					col--;
					continue;
				}
				// val 같은 수 일때
				if (map[i][col] == val) {
					nowmap[i][pre] = val << 1;
					val = 0;
					pre--;
				} else if (map[i][col] > 0) { // 다른 수 일때
					nowmap[i][pre] = val;
					val = map[i][col];
					pre--;
				}
				col--;
			}
			if (val != 0) {
				nowmap[i][pre] = val;
			}
		}

		return nowmap;
	}

	// 왼쪽으로 밀기
	static int[][] left(int[][] map) {
		int[][] nowmap = new int[N][N];

		// 왼쪽으로 밀기
		for (int i = 0; i < N; i++) { // 열

			int val = 0;
			int pre = 0;
			int col = 0;
			while (col != N) {

				if (val == 0) {
					if (map[i][col] > 0) {
						val = map[i][col];
					}
					col++;
					continue;
				}
				// val 같은 수 일때
				if (map[i][col] == val) {
					nowmap[i][pre] = val << 1;
					val = 0;
					pre++;
				} else if (map[i][col] > 0) { // 다른 수 일때
					nowmap[i][pre] = val;
					val = map[i][col];
					pre++;
				}
				col++;
			}
			if (val != 0) {
				nowmap[i][pre] = val;
			}
		}

		return nowmap;
	}

	static void Print(int[][] map) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
