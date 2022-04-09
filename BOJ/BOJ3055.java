import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ3055 {

	static int R, C;
	static char[][] map;
	static ArrayList<Pair> water = new ArrayList<>();
	static Pair start;
	static Pair end;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'D') { // 비버의 굴
					end = new Pair(i, j, false, 0);
					continue;
				}
				if (map[i][j] == 'S') {
					start = new Pair(i, j, false, 0);
				}
				if (map[i][j] == '*') {
					water.add(new Pair(i, j));
					continue;
				}
			}
		}

		bfs();
		return;

	}

	static void bfs() {
		Queue<Pair> que = new LinkedList<>();

		// 물부터 넣음
		for (Pair temp : water) {
			que.offer(temp);
		}
		// 고슴도치 넣음
		que.offer(start);

		while (!que.isEmpty()) {
			Pair temp = que.poll();
			if (temp.row == end.row && temp.col == end.col) {
				System.out.println(temp.time);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int drow = dr[d] + temp.row;
				int dcol = dc[d] + temp.col;

				if (drow < 0 || drow >= R || dcol < 0 || dcol >= C)
					continue;

				// 물일때
				if (temp.water && map[drow][dcol] == '.') {
					que.offer(new Pair(drow, dcol));
					map[drow][dcol] = '*';
					continue;
				}

				// 고슴도치일떄
				if (!temp.water && (map[drow][dcol] == '.' || map[drow][dcol] == 'D')) {
					que.offer(new Pair(drow, dcol, false, temp.time + 1));
					map[drow][dcol] = 'S';
					continue;
				}
			}

		}

		System.out.println("KAKTUS");
		return;
	}

	static class Pair {

		int row;
		int col;
		int time;
		boolean water = true;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}

		public Pair(int row, int col, boolean water, int time) {
			super();
			this.row = row;
			this.col = col;
			this.water = water;
			this.time = time;
		}

	}

}
