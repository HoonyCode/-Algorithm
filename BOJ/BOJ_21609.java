package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_21609 {

	static int N, M;
	static int[][] map;
	static List<Data> list = new ArrayList<>();
	static boolean[][] v;
	static final int breakBlock = -100;
	static int answer = 0;

	public static void main(String[] args) throws Exception {

		input(); // 입력 받아드림

		while (true) {

			// 방문 배열 초기화
			list.clear();
			vinit();

			// 검은색 블록은 -1, 무지개 블록은 0
			// 블록 그룹의 기준 블록은 무지개 블록이 아닌 블록 중에서 행의 번호가 가장 작은 블록,
			// 그러한 블록이 여러개면 열의 번호가 가장 작은 블록이다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (v[i][j] || map[i][j] == 0 || map[i][j] < 0)
						continue;
					bfs(new Pair(i, j));
				}
			}

			Collections.sort(list);

			if(list.isEmpty()) break;
			
			answer += breakBfs(list.get(0));
		}
		
		System.out.println(answer);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static int breakBfs(Data start) {
		Queue<Pair> que = new LinkedList<>();
		que.offer(new Pair(start.row, start.col));
		int blockSize = map[start.row][start.col];

		map[start.row][start.col] = breakBlock;

		int drow, dcol;
		Pair cur;
		while (!que.isEmpty()) {
			cur = que.poll();

			for (int d = 0; d < 4; d++) {
				drow = dr[d] + cur.r;
				dcol = dr[d] + cur.c;

				if (check(drow, dcol))
					continue;
				if (!(map[drow][dcol] == blockSize || map[drow][dcol] == 0))
					continue;
				map[drow][dcol] = blockSize;
				que.offer(new Pair(drow, dcol));
			}

		}

		return start.count * start.count;
		
	}

	private static void bfs(Pair start) {
		v[start.r][start.c] = true; // 방문 체크
		int blockSize = map[start.r][start.c];
		Queue<Pair> que = new LinkedList<>();
		que.offer(start);

		int minRow = start.r;
		int minCol = start.c;

		int row, col;
		Pair cur;
		int cnt = 0;
		while (que.isEmpty()) {
			cur = que.poll();
			cnt++;

			if (map[cur.r][cur.c] == blockSize) {
				if (minRow > cur.r) {
					minRow = cur.r;
					minCol = cur.c;
				} else if (minRow == cur.r) {
					minCol = Math.min(minCol, cur.c);
				}
			}

			for (int d = 0; d < 4; d++) {
				row = dr[d] + cur.r;
				col = dc[d] + cur.c;

				if (check(row, col))
					continue;
				if (v[row][col] || map[row][col] == -1)
					continue;
				if (!(map[row][col] == blockSize || map[row][col] == 0))
					continue;

				v[row][col] = true;
				que.offer(new Pair(row, col));
			}
		}

		if (cnt > 1)
			list.add(new Data(minRow, minCol, cnt));
	}

	static boolean check(int row, int col) {

		if (row < 0 || row >= N || col < 0 || col >= N) {
			return true;
		}

		return false;
	}

	// 방문 배열 초기화
	private static void vinit() {
		for (int i = 0; i < N; i++) {
			Arrays.fill(v[i], false);
		}
	}

	static class Pair {
		int r, c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");

		N = Integer.parseInt(in[0]);
		M = Integer.parseInt(in[1]);

		map = new int[N][N];
		v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			in = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(in[j]);
			}
		}
	}

	static class Data implements Comparable<Data> {
		int row, col;
		int count;

		public Data(int row, int col, int count) {
			this.row = row;
			this.col = col;
			this.count = count;
		}

		@Override
		public int compareTo(Data o) {
			if (this.count == o.count) {
				if (this.row == o.row) {
					return -Integer.compare(this.col, o.col);
				}
				return -Integer.compare(this.row, o.row);
			}
			return -Integer.compare(this.count, o.count);
		}
	}
}
