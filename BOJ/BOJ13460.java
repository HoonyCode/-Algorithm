import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ13460 {

	static final int Blue = 2;
	static final int Red = 1;
	static int row, col;
	static char[][] map;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		row = Integer.parseInt(input[0]);
		col = Integer.parseInt(input[1]);

		Ball start = new Ball();

		map = new char[row][col];
		for (int i = 0; i < row; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 'R') {
					map[i][j] = '.';
					start.red = new Pair(i, j);
				} else if (map[i][j] == 'B') {
					map[i][j] = '.';
					start.blue = new Pair(i, j);
				}
			}
		}

		System.out.println(bfs(start));

	}

	// 상 우 하 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	private static int bfs(Ball start) {
		Queue<Ball> que = new LinkedList<>();
		que.offer(start);

		Ball cur;
		Pair blue, red;

		while (!que.isEmpty()) {
			cur = que.poll();

			if (cur.time > 9) {
				break;
			}
			
			// 상우하좌
			for (int d = 0; d < 4; d++) {
				red = cur.red;
				blue = cur.blue;
				
				
				res = 0;
				// command patrern;
				switch (d) {
				case 0: // 상
					if (red.row < blue.row) {
						red = move(red, blue, d, Red);
						blue = move(red, blue, d, Blue);
					} else {
						blue = move(red, blue, d, Blue);
						red = move(red, blue, d, Red);
					}
					break;
				case 1: // 우
					if (red.col > blue.col) {
						red = move(red, blue, d, Red);
						blue = move(red, blue, d, Blue);
					} else {
						blue = move(red, blue, d, Blue);
						red = move(red, blue, d, Red);
					}
					break;
				case 2: // 밑
					if (red.row > blue.row) {
						red = move(red, blue, d, Red);
						blue = move(red, blue, d, Blue);
					} else {
						blue = move(blue, blue, d, Blue);
						red = move(red, blue, d, Red);
					}
					break;
				case 3: // 좌
					if (red.col < blue.col) {
						red = move(red, blue, d, Red);
						blue = move(red, blue, d, Blue);
					} else {
						blue = move(red, blue, d, Blue);
						red = move(red, blue, d, Red);
					}
					break;
				}
				// 끝.

				if (res == Red) { // 빨간 구슬만 들어갈때
					return cur.time + 1;
				} else if (res == 0) {
					if (red.row == cur.red.row && red.col == cur.red.col && blue.col == cur.blue.col
							&& blue.row == cur.blue.row)
						continue;
					que.offer(new Ball(red, blue, cur.time + 1));
				}
			}

		}

		return -1;
	}

	// 볼과 방향을 받아온다
	private static Pair move(Pair red, Pair blue, int d, int color) {
		int drow;
		int dcol;

		if (color == Red) { // 레드일때
			drow = red.row;
			dcol = red.col;

			while (true) {
				drow += dr[d];
				dcol += dc[d];

				// 벽이거나 칼러면 아웃
				if (map[drow][dcol] == '#' || (drow == blue.row && dcol == blue.col)) {
					return new Pair(drow - dr[d], dcol - dc[d]);
				}

				if (map[drow][dcol] == 'O') {
					res += color;
					return new Pair(0, 0);
				}

			}
		} else { // 블루 일때
			drow = blue.row;
			dcol = blue.col;

			while (true) {
				drow = blue.row;
				dcol = blue.col;

				while (true) {
					drow += dr[d];
					dcol += dc[d];

					// 벽이거나 칼러면 아웃
					if (map[drow][dcol] == '#' || (drow == red.row && dcol == red.col)) {
						return new Pair(drow - dr[d], dcol - dc[d]);
					}

					if (map[drow][dcol] == 'O') {
						res += color;
						return new Pair(0, 0);
					}
				}
			}

		}
	}

	static class Pair {
		int row;
		int col;

		public Pair(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Pair [row=" + row + ", col=" + col + "]";
		}

	}

	static class Ball {
		Pair red;
		Pair blue;
		int time = 0;

		public Ball() {
		}

		public Ball(Pair red, Pair blue, int time) {
			super();
			this.red = red;
			this.blue = blue;
			this.time = time;
		}

	}

}
