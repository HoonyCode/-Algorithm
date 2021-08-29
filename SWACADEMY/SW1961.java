import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW1961 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}
			String[] line = new String[N];
			Arrays.fill(line, "");
			int[][] map2 = new int[N][N];
			// 90도
			mapchange(map2, map, N, line);
			mapchange(map, map2, N, line);
			mapchange(map2, map, N, line);
			
			sb.append("#"+t+"\n");
			for(int i = 0 ; i < N ; i++) {
				sb.append(line[i]+"\n");
			}

		}
		System.out.println(sb.toString());
	}

	static void mapchange(int[][] changemap, int[][] map, int N, String[] line) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				changemap[j][N - 1 - i] = map[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				line[i] += changemap[i][j]+"";
			}
			line[i] += " ";
		}
	}
}
