import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ16236 {
	static int N;
	static int[][] map, submap;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };
	static Pair shork;
	static int big = 2;
	static int eat = 0; // 같은 수의 물고기를 먹을 때 마다 크기가 1증가
	static int time = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		// 9 아기 상어
		// 처음 아기 상어 크기 2
		// 1초 상하좌우
		// 작은 물고기 먹을 수 x 크기 같으면 먹 가능
		// 가장 위 왼쪽
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (map[i][j] == 9) {
					shork = new Pair(i, j);
				}
			}
		}

		while (bfs())
			Print();

		System.out.println(time);

	}

	static boolean bfs() {
		mapcopy();

		Queue<Pair> que = new LinkedList<>();
		que.offer(shork);
		submap[shork.row][shork.col] = 10;
		map[shork.row][shork.col] = 0;
		
		
		while (que.size() != 0) {

			Pair temp = que.poll();

			for (int d = 0; d < 4; d++) {
				int drow = temp.row + dr[d];
				int dcol = temp.col + dc[d];

				if (drow < 0 || drow >= N || dcol < 0 || dcol >= N || submap[drow][dcol] > big)
					continue;

				if (submap[drow][dcol] < big && submap[drow][dcol] > 0) {
					shork.row = drow;
					shork.col = dcol;
					time = time + temp.cnt + 1;
					eat++;
					if (big == eat) {
						big++;
						eat = 0;
					}
					map[drow][dcol] = 9;
					return true;
				}

				submap[drow][dcol] = 10;
				que.offer(new Pair(drow, dcol, temp.cnt + 1));
			}

		}

		return false;
	}

	static void mapcopy() {
		submap = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				submap[i][j] = map[i][j];
			}
		}
	}

	static class Pair {
		int row;
		int col;
		int cnt = 0;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
			this.cnt = 0;
		}

		public Pair(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}
	
	static void Print() {
		for(int i = 0; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(eat + " " + big + " " + time);
	}
}
