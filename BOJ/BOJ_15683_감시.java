package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_15683_감시 {

	static int N, M;

	static int noCnt = 0; // 사각지대
	static int answer = Integer.MAX_VALUE; // 답

	static int[] drow = { -1, 0, 1, 0 };
	static int[] dcol = { 0, 1, 0, -1 };

	static ArrayList<int[]> cameraList = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		//입력받기
		int[][] map = Input();

		//카메라 5작동
		cameraFiveExecute(map);

		//카메라 작동
		dfs(0, noCnt, map);

		//답 출력
		System.out.println(answer);

	}

	private static void cameraFiveExecute(int[][] map) {
		for (int i = cameraList.size() - 1; i >= 0; i--) {
			int[] temp = cameraList.get(i);

			int row = temp[0];
			int col = temp[1];

			if (map[row][col] == 5) {
				noCnt -= cameraExecute(row, col, 5, 0, map);
				cameraList.remove(i);
			}
		}
	}

	private static int[][] Input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] in = br.readLine().split(" ");
		N = Integer.parseInt(in[0]);
		M = Integer.parseInt(in[1]);

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			in = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(in[j]);
				if (map[i][j] == 0)
					noCnt++;
				if (map[i][j] > 0 && map[i][j] < 6)
					cameraList.add(new int[] { i, j });
			}
		}
		return map;
	}

	public static int[][] copyArr(int[][] org) {

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = org[i][j];
			}
		}

		return arr;
	}

	public static void dfs(int depth, int count, int[][] map) {

		if (depth == cameraList.size()) {
			answer = Math.min(count, answer);
			return;
		}

		int[][] arr;
		int sum;
		int[] temp = cameraList.get(depth);
		for (int d = 0; d < 4; d++) {
			arr = copyArr(map);

			sum = cameraExecute(temp[0], temp[1], map[temp[0]][temp[1]], d, arr);
			dfs(depth + 1, count - sum, arr);
		}

	}

	public static int cameraExecute(int row, int col, int id, int d, int[][] map) {
		int sum = 0;

		switch (id) {
		case 1:
			sum += delete(row, col, map, d);
			break;
		case 2:
			sum += delete(row, col, map, d);
			sum += delete(row, col, map, d + 2);
			break;
		case 3:
			sum += delete(row, col, map, d);
			sum += delete(row, col, map, d + 1);
			break;
		case 4:
			sum += delete(row, col, map, d);
			sum += delete(row, col, map, d + 1);
			sum += delete(row, col, map, d + 2);
			break;
		case 5:
			sum += delete(row, col, map, d);
			sum += delete(row, col, map, d + 1);
			sum += delete(row, col, map, d + 2);
			sum += delete(row, col, map, d + 3);
			break;
		}

		return sum;
	}

	// 0은 빈 칸, 6은 벽, 1~5는 CCTV를 나타내고 7은 제거한걸 나타냄
	public static int delete(int row, int col, int[][] map, int d) { // d : 방향 1 위 2 오른쪽 3 아래 4 왼쪽

		d = d % 4;

		int dy = drow[d] + row;
		int dx = dcol[d] + col;

		int sum = 0;

		while (true) {

			if (dy < 0 || dy >= N || dx < 0 || dx >= M)
				break; // 범위 이탈

			if (map[dy][dx] == 6)
				break;

			if (map[dy][dx] != 0) {
				dy += drow[d];
				dx += dcol[d];
				continue;

			}

			map[dy][dx] = -1;
			sum++;

			dy += drow[d];
			dx += dcol[d];
		}

		return sum;
	}
}
