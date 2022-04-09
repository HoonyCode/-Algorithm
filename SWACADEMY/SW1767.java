import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SW1767 {

	static int N;
	static int maxCore;
	static int minLen;
	static int[][] map, submap;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	static ArrayList<Pair> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			list.clear(); // 초기화

			N = Integer.parseInt(br.readLine());

			submap = new int[N][N];
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					submap[i][j] = map[i][j] = Integer.parseInt(input[j]);

					if (i == 0 || j == 0 || i == N - 1 || j == N - 1)
						continue;

					if (map[i][j] == 1)
						list.add(new Pair(i, j)); // 코어 넣기
				}
			}

			maxCore = 0;
			minLen = 100_000_000;

			dfs(0, 0, 0);

			sb.append("#" + t + " " + minLen + "\n");
		}

		System.out.println(sb.toString());
	}

	static void dfs(int cnt, int corecnt, int len) {

		if (corecnt + list.size() - cnt < maxCore)
			return;

		if (cnt == list.size()) {
			if (maxCore == corecnt) {
				minLen = Math.min(minLen, len);
			}
			if (maxCore < corecnt) {
				maxCore = corecnt;
				minLen = len;
			}

			return;
		}

		for (int i = 0; i < 4; i++) {
			int nowlen = exe(list.get(cnt), i, cnt + 10);
			if (nowlen == 0) { // 없을때
				mapcopy(list.get(cnt), i, cnt + 10); // 초기화
				dfs(cnt + 1, corecnt, len);
			} else {
				dfs(cnt + 1, corecnt + 1, len + nowlen);
				mapcopy(list.get(cnt), i, cnt + 10);
			}
		}
		return;

	}

	static void mapcopy(Pair pair, int Case, int color) {

		if (Case == 0) {
			for (int i = pair.col + 1; i < N; i++) {
				if (submap[pair.row][i] != color)
					return;
				submap[pair.row][i] = map[pair.row][i];
			}
		} else if (Case == 1) {
			for (int i = pair.col - 1; i >= 0; i--) {
				if (submap[pair.row][i] != color)
					return;
				submap[pair.row][i] = map[pair.row][i];
			}
		} else if (Case == 2) {
			for (int i = pair.row - 1; i >= 0; i--) {
				if (submap[i][pair.col] != color)
					return;
				submap[i][pair.col] = map[i][pair.col];
			}
		} else {
			for (int i = pair.row + 1; i < N; i++) {
				if (submap[i][pair.col] != color)
					return;
				submap[i][pair.col] = map[i][pair.col];
			}
		}

	}

	static int exe(Pair pair, int Case, int color) {

		int len = 0;

		switch (Case) {
		case 0:
			len = right(pair, color);
			break;
		case 1:
			len = left(pair, color);
			break;
		case 2:
			len = up(pair, color);
			break;
		case 3:
			len = down(pair, color);
			break;
		}

		return len;
	}

	static int right(Pair pair, int color) {
		int len = 0;

		for (int i = pair.col + 1; i < N; i++) {
			if (submap[pair.row][i] != 0)
				return 0;
			submap[pair.row][i] = color;
			len++;
		}
		return len;
	}

	static int left(Pair pair, int color) {
		int len = 0;
		for (int i = pair.col - 1; i >= 0; i--) {
			if (submap[pair.row][i] != 0)
				return 0;
			submap[pair.row][i] = color;
			len++;
		}
		return len;
	}

	static int down(Pair pair, int color) {
		int len = 0;

		for (int i = pair.row + 1; i < N; i++) {
			if (submap[i][pair.col] != 0)
				return 0;
			submap[i][pair.col] = color;
			len++;
		}
		return len;
	}

	static int up(Pair pair, int color) {
		int len = 0;

		for (int i = pair.row - 1; i >= 0; i--) {
			if (submap[i][pair.col] != 0)
				return 0;
			submap[i][pair.col] = color;
			len++;
		}

		return len;
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
