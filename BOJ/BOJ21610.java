import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ21610 {

	static int N, M;
	static int[][] map;
	static boolean[][] chack;
	static Queue<Pair> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		map = new int[N + 1][N + 1];

		// 가장 윗쪽읜 칸은 1.1

		// 각 칸에는 바구니 있고 물의 양 제한 없음

		for (int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(input[j - 1]);
			}
		}

		int d;
		int s;

		que = new LinkedList<>();
		Pair pair = new Pair(N - 1, 1);
		
		Pair cur;
		
		for (int i = 0; i < M; i++) {


			input = br.readLine().split(" ");
			// 이동 정보 거리;
			d = Integer.parseInt(input[0]);
			s = Integer.parseInt(input[1]);

			if (i == 0) {
				que.offer(pair = bfs(pair, d, s));
				map[pair.row][pair.col]++;
				que.offer(cur = bfs(pair, 5, 1));
				map[cur.row][cur.col]++;
				que.offer(cur = bfs(pair, 6, 1));
				map[cur.row][cur.col]++;
				que.offer(cur = bfs(pair, 7, 1));
				map[cur.row][cur.col]++;
			} else {
				for (int j = 0; j < que.size(); j++) {
					cur = bfs(que.poll(),d,s);
					map[cur.row][cur.col]++;
					que.offer(cur);
				}
			}

			chack = new boolean[N + 1][N + 1];

			while (!que.isEmpty())
				water_copy(que.poll());// 물 채우기

			delet();
		}
		

		System.out.println(result());

	}

	static void delet() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] < 2 || chack[i][j])
					continue;

				// 물빼기
				map[i][j] -= 2;
				que.offer(new Pair(i, j)); // 구름 넣어주기
			}
		}
	}

	static int[] dr = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

	private static void water_copy(Pair pair) {
		int cnt = 0;

		chack[pair.row][pair.col] = true;

		int drow;
		int dcol;

		for (int d = 2; d <= 8; d = d + 2) {
			drow = dr[d] + pair.row;
			dcol = dc[d] + pair.col;

			if (drow < 1 || drow > N || dcol < 1 || dcol > N)
				continue;
			if (map[drow][dcol] == 0)
				continue;
			cnt++;
		}

		map[pair.row][pair.col] += cnt; // 비오는거 + 
	}

	private static Pair bfs(Pair pair, int d, int s) {
		// d = 방향
		// s = 거리

		int cnt = 0;
		int drow = pair.row;
		int dcol = pair.col;

		while (cnt != s) {
			drow += dr[d];
			dcol += dc[d];
			if (drow == 0)
				drow = N;
			if (drow == N + 1)
				drow = 1;
			if (dcol == 0)
				dcol = N;
			if (dcol == N + 1)
				dcol = 1;
			cnt++;
		}

		return new Pair(drow, dcol);

	}

	static int result() {
		int res = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				res += map[i][j];
			}
		}
		return res;
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
			return "[row=" + row + ", col=" + col + "]";
		}

	}

	static void Print() {
		System.out.println();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sb.append(map[i][j]).append('\t');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
