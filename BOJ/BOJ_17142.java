package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_17142 {

	static int N, M;
	static int[][] map;
	static Pair[] arr;
	static boolean[][] v;
	static List<Pair> binus = new ArrayList<>();
	static int total;
	static int answer = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] in = br.readLine().split(" ");

		N = Integer.parseInt(in[0]);
		M = Integer.parseInt(in[1]);

		map = new int[N][N];
		arr = new Pair[M];
		v = new boolean[N][N];

		total = N * N;

		for (int i = 0; i < N; i++) {
			in = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(in[j]);
				if (map[i][j] == 1) {
					total--;
				} else if (map[i][j] == 2) {
					binus.add(new Pair(i, j, 0));
				}
			}
		}

		if (bfs()) {
			System.out.println(-1);
		} else {
			Combination(0, 0);

			System.out.println(answer);
		}

	}

	private static boolean bfs() {
		Queue<Pair> queue = new LinkedList<>();

		for (int i = 0; i < binus.size(); i++) {
			queue.offer(binus.get(i));
			v[binus.get(i).row][binus.get(i).col] = true;
		}


		int drow, dcol = 0;
		Pair cur;
		int cnt = 0;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			cnt++;

			if (cnt == total) {
				return false;
			}

			for (int d = 0; d < 4; d++) {
				drow = dr[d] + cur.row;
				dcol = dc[d] + cur.col;
				if (drow < 0 || drow >= N || dcol < 0 || dcol >= N)
					continue;
				if (v[drow][dcol] || map[drow][dcol] == 1)
					continue;
				v[drow][dcol] = true;

				queue.offer(new Pair(drow, dcol, cur.time + 1));

			}
		}
		
		return true;
	}

	private static void Combination(int depth, int start) {
		if (depth == M) {
			Solution();
			return;
		}

		for (int i = start; i < binus.size(); i++) {
			arr[depth] = binus.get(i);
			Combination(depth + 1, i + 1);
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void Solution() {
		Queue<Pair> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			Arrays.fill(v[i], false);
		}

		for (int i = 0; i < M; i++) {
			queue.offer(arr[i]);
			v[arr[i].row][arr[i].col] = true;
		}

		int binusSize = binus.size();

		int drow, dcol = 0;
		Pair cur;
		int cnt = 0;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			cnt++;

			if (map[cur.row][cur.col] == 2)
				binusSize--;

			if (answer >= 0 && cur.time >= answer)
				return;

			if ((cnt + binusSize) == total) {
				answer = cur.time;
				return;
			}

			for (int d = 0; d < 4; d++) {
				drow = dr[d] + cur.row;
				dcol = dc[d] + cur.col;
				if (drow < 0 || drow >= N || dcol < 0 || dcol >= N)
					continue;
				if (v[drow][dcol] || map[drow][dcol] == 1)
					continue;
				v[drow][dcol] = true;

				queue.offer(new Pair(drow, dcol, cur.time + 1));

			}
		}

	}

	static class Pair {
		int row, col, time;

		public Pair(int row, int col, int time) {
			this.row = row;
			this.col = col;
			this.time = time;
		}

	}
}
