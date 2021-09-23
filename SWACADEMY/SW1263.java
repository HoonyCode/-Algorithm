import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1263 {
	static int N;
	static int[][] map;
	static int INF = 999_999;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && map[i][j] == 0) {
						map[i][j] = INF;
					}
				}
			}
			for (int k = 0; k < N; k++) { // 경유지 k
				for (int i = 0; i < N; i++) {// 출발지 i
					for (int j = 0; j < N; j++) {// 도착지 j
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					}
				}
			}

			int min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					cnt += map[i][j];
				}
				min = Math.min(min, cnt);
			}

			sb.append("#" + t + " " + min + "\n");
		}
		System.out.println(sb.toString());
	}
}
