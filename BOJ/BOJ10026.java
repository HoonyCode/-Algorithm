import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10026 {
	static int N;
	static char[][][] map;
	static int[][][] v;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int[] cnt = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[2][N][N];
		v = new int[2][N][N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[0][i][j] = map[1][i][j] = input[j].charAt(0);
				if (map[1][i][j] == 'G')
					map[1][i][j] = 'R';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (v[0][i][j] == 0) {
					cnt[0]++;
					bfs(new Pair(i, j), 0);
				}
				if (v[1][i][j] == 0) {
					cnt[1]++;
					bfs(new Pair(i, j), 1);
				}
			}
		}
		System.out.println(cnt[0] + " " + cnt[1]);
	}

	static void bfs(Pair pair, int num) {

		Queue<Pair> que = new LinkedList<>();
		que.offer(pair);
		v[num][pair.row][pair.col] = cnt[num];

		while (que.size() != 0) {
			Pair temp = que.poll();

			for (int d = 0; d < 4; d++) {
				int drow = temp.row + dr[d];
				int dcol = temp.col + dc[d];

				if (drow < 0 || drow >= N || dcol < 0 || dcol >= N || v[num][drow][dcol] != 0
						|| map[num][drow][dcol] != map[num][temp.row][temp.col])
					continue;

				v[num][drow][dcol] = cnt[num];
				que.offer(new Pair(drow, dcol));
			}
		}

	}

	static class Pair {
		int row;
		int col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}

	}
}
