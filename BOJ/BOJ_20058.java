package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_20058 {

	static int N, Q;
	static int[] arr;

	static int[][] map;
	static int[][] submap;
	static int answer = 0;
	static int size = 0;
	static boolean[][] v;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		input();

		for (int t = 0; t < Q; t++) {
			int len = (int) Math.pow(2, arr[t]);

			if (len != 1) {
				for (int i = 0; i < N; i = i + len) {
					for (int j = 0; j < N; j = j + len) {
						change(i, j, len);
					}
				}
			}
			solve();
			mapcopy();

		}

		v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] <= 0)
					continue;
				answer += map[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (v[i][j] || map[i][j] <= 0)
					continue;
				bfs(new Pair(i, j));
			}
		}

		System.out.println(answer);
		System.out.println(size);

	}

	private static void bfs(Pair start) {

		Queue<Pair> que = new LinkedList<>();
		que.offer(start);
		v[start.row][start.col] = true;

		int cnt = 0;
		Pair cur;
		int drow, dcol;
		while (!que.isEmpty()) {
			cur = que.poll();
			cnt++;

			for (int d = 0; d < 4; d++) {
				drow = dr[d] + cur.row;
				dcol = dc[d] + cur.col;

				if (drow < 0 || drow >= N || dcol < 0 || dcol >= N)
					continue;
				if (v[drow][dcol] || map[drow][dcol] <= 0)
					continue;
				v[drow][dcol] = true;

				que.offer(new Pair(drow, dcol));
			}
		}

		size = Math.max(size, cnt);

	}

	static class Pair {
		int row, col;

		public Pair(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}

	private static void solve() {
		int drow;
		int dcol;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				for (int d = 0; d < 4; d++) {

					drow = i + dr[d];
					dcol = j + dc[d];

					if (drow < 0 || drow >= N || dcol < 0 || dcol >= N)
						continue;
					if (map[drow][dcol] <= 0)
						continue;
					cnt++;
				}

				if (cnt >= 3) {
					submap[i][j] = map[i][j];
				} else {
					submap[i][j] = map[i][j] - 1;
				}

			}
		}
	}

	private static void mapcopy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = submap[i][j];
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");

		N = (int) Math.pow(2, Integer.parseInt(in[0]));
		Q = Integer.parseInt(in[1]);

		arr = new int[Q];

		map = new int[N][N];
		submap = new int[N][N];

		for (int i = 0; i < N; i++) {

			in = br.readLine().split(" ");

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(in[j]);
			}
		}

		in = br.readLine().split(" ");
		for (int i = 0; i < Q; i++) {
			arr[i] = Integer.parseInt(in[i]);
		}

	}

	private static void change(int r, int c, int len) {
		int[][] temp = new int[len][len];

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				temp[i][j] = map[r + i][c + j];
			}
		}

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				map[r + j][c + len - 1 - i] = temp[i][j];
			}
		}
	}

}
