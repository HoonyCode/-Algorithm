import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ14502 {

	static int N, M;
	static int min = Integer.MAX_VALUE; // 바이러스의 최소값
	static int[][] map, subMap;
	static ArrayList<Pair> arr = new ArrayList<>();
	static int safeZone;
	static int[] drow = { 0, 0, 1, -1 };
	static int[] dcol = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		map = new int[N][M];
		subMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				int val = Integer.parseInt(input[j]);
				subMap[i][j] = map[i][j] = val;
				if (val == 0)
					safeZone++;
				if (val == 2)
					arr.add(new Pair(i, j)); // 바이러스 위치 넣어둠
			}
		}

		safeZone -= 3;
		// 벽 세개 세우기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (subMap[i][j] != 0)
					continue;

				// 0일때
				for (int ii = i; ii < N; ii++) {
					for (int jj = 0; jj < M; jj++) {
						if (ii == i && jj <= j)
							continue;
						if (subMap[ii][jj] != 0)
							continue;

						// 0일때
						for (int iii = ii; iii < N; iii++) {
							for (int jjj = 0; jjj < M; jjj++) {
								if (iii == ii && jjj <= jj)
									continue;
								if (subMap[ii][jj] != 0)
									continue;

								subMap[i][j] = subMap[ii][jj] = subMap[iii][jjj] = 1;
								bfs();
								mapCopy();
							}
						}
					}
				}
			}
		}

		System.out.println(safeZone - min);
		return;
	}

	static void bfs() {
		Queue<Pair> que = new LinkedList<>();
		for (Pair temp : arr) { // 바이러스 위치를 담아둔다
			que.offer(temp);
//			System.out.println(temp.toString());
		}

		int nowMin = 0; // 현재 바이러스의 수

		while (!que.isEmpty()) { // 큐가 비지 않으면 돈다
			Pair temp = que.poll();

			if (nowMin > min)
				return; // 현재 바이러스가 기록된 바이러스 보다 많아지면 끝

			for (int d = 0; d < 4; d++) {
				int dr = temp.row + drow[d];
				int dc = temp.col + dcol[d];

				if (dr < 0 || dr >= N || dc < 0 || dc >= M || subMap[dr][dc] != 0)
					continue;

				que.offer(new Pair(dr, dc)); // 퍼지는 바이러스를 담음
				subMap[dr][dc] = 2; // 바이러스
				nowMin++;
			}

		}

		min = nowMin;
	}

	// 맵 복사
	static void mapCopy() {
		for (int i = 0; i < N; i++) {
			subMap[i] = Arrays.copyOf(map[i], M);
		}
	}

	static class Pair {
		int row;
		int col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Pair [row=" + row + ", col=" + col + "]";
		}

	}

	static void Print() {
		System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(subMap[i][j] + " ");
			}
			System.out.println();
		}
	}
}
