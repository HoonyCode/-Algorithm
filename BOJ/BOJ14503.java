import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14503 {

	static int R, C;
	static int[][] map;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");
		int[] start = { Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]) };

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		dfs(start);

		System.out.println(res);
	}

	// 왼쪽 방향 청소 x 공간 그 방향으로 회전한 다음 한칸 전진
	// d = 0 북쪽 1인 경우 동쪽 2인 경우 남쪽 3인 경우 서쪽

	private static void dfs(int[] start) {
		// TODO Auto-generated method stub
		if (map[start[0]][start[1]] == 0) {
			res++;
			map[start[0]][start[1]] = -1; // 청소 완료
		}

		int drow = 0;
		int dcol = 0;
		int d = start[2];
		boolean check = false;

		for (int i = 0; i < 4; i++) {
			d--;
			if (d == -1)
				d = 3;
			drow = dr[d] + start[0];
			dcol = dc[d] + start[1];

			if (drow < 0 || drow >= R || dcol < 0 || dcol >= C || map[drow][dcol] != 0)
				continue;
			check = true;
			break;
		}

		if (check) {
			dfs(new int[] { drow, dcol, d });
		} else { // 네 방향
			d = start[2] - 2;
			if (d < 0)
				d += 4;

			drow = dr[d] + start[0];
			dcol = dc[d] + start[1];

			if (drow >= 0 && drow < R && dcol >= 0 && dcol < C && map[drow][dcol] != 1) {
				dfs(new int[] { drow, dcol, start[2] });
			}
		}
		
		return;

	}

	static int[] dr = { -1, 0, 1, 0 }; // 북동남서
	static int[] dc = { 0, 1, 0, -1 };

	static void PrintMap() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
