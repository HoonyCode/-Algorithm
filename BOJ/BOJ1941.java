import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1941 {

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static char[][] map = new char[5][5];
	static boolean[] v = new boolean[25];
	static int total = 0;
	static Pair[] pairs = new Pair[7];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// S 이다솜파
		// Y 임도연파

		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}

		dfs(0, 0);

		System.out.println(total);
	}

	static void dfs(int start, int cnt) {

		if (cnt == 7) {
			int Scnt = 0;
			for (int i = 0; i < 7; i++) {
				if (map[pairs[i].row][pairs[i].col] == 'S')
					Scnt++;
			}

			if (Scnt < 4)
				return;

			bfs();
			return;
		}

		for (int i = start; i < 25; i++) {
			pairs[cnt] = shiftPair(i);

			if (cnt > 0 && pairs[cnt].row - pairs[cnt - 1].row > 1)
				return;

			v[i] = true;
			dfs(i + 1, cnt + 1);
			v[i] = false;
		}

		return;

	}

	static void bfs() {
		Queue<Pair> que = new LinkedList<>();

		que.offer(pairs[0]);
		boolean[] qv = new boolean[7];
		qv[0] = true;
		int cnt = 1;
		while (!que.isEmpty()) {
			Pair temp = que.poll();

			for (int d = 0; d < 4; d++) {
				int drow = dr[d] + temp.row;
				int dcol = dc[d] + temp.col;

				for (int i = 1; i < 7; i++) {
					if (qv[i])
						continue;

					if (pairs[i].row == drow && pairs[i].col == dcol) {
						qv[i] = true;
						que.offer(pairs[i]);
						cnt++;
					}
				}
			}
		}

		if (cnt == 7)
			total++;

	}

	static class Pair {
		int row;
		int col;

		public Pair(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

	}

	static Pair shiftPair(int i) {

		int row = i / 5;
		int col = i % 5;

		return new Pair(row, col);
	}

}
