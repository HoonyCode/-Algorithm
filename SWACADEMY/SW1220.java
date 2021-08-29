import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1220 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t < 11; t++) {
			int answer = 0;

			int N = Integer.parseInt(br.readLine());

			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}

			// 1 N
			// 2 S
			for (int i = 0; i < N; i++) {
				int start = 0;
				for (int j = 0; j < N; j++) {
					if (start == 0 && map[j][i] == 1) {
						start = 1;
					} else if (start == 1 && map[j][i] == 2) {
						answer++;
						start = 0;
					}
				}
			}

			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

}
