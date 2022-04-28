package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1051_HoonyCode {

	static int N, M;
	static int[][] map;
	static int answer = 1;

	public static void main(String[] args) throws Exception {
		input();
		solution();
		System.out.println(answer);
	}

	private static void solution() throws IOException {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = Math.min(N -1 - i, M -1 - j); k >= answer; k--) {
					int A = map[i][j];
					int B = map[i + k][j];
					int C = map[i][j + k];
					int D = map[i + k][j + k];

					if (A == B && C == D && A == D) {
						answer = (k+1);
					}
				}
			}
		}
		
		if(answer == 1) return;
		answer = (answer) * (answer);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] in = br.readLine().split(" ");

		N = Integer.parseInt(in[0]);
		M = Integer.parseInt(in[1]);

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			in = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(in[j]);
			}
		}
	}
}
