import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW7236 {

	static int[] dx = { 1, 1, 1, 0, 0, -1, -1, -1 };
	static int[] dy = { 1, 0, -1, 1, -1, 1, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			char[][] map = new char[N][N];

			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				for(int j = 0; j < N ; j++) {
					map[i][j] = input[j].charAt(0);
				}
			}
			

			int answer = 1;

			for (int i = 1; i < N - 1; i++) {
				loop: for (int j = 1; j < N - 1; j++) {
					if (map[i][j] == 'W') {
						int cnt = 8;
						for (int d = 0; d < 8; d++) {
							int row = i + dx[d];
							int col = j + dy[d];
							
							if (map[row][col] == 'G') {
								cnt--;
							}
							
							if (cnt <= answer) {
								continue loop;
							}
						}
						answer = Math.max(answer, cnt);
					}
				}
			}

			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}
}
