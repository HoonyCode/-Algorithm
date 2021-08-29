import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1979 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int K = Integer.parseInt(input[1]);

			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}
			int answer = 0;

			// 가로
			for (int i = 0; i < N; i++) {
				loop : for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						int k = j + K;
						
						for (; j < k; j++) {
							if(j >= N || map[i][j] == 0) continue loop;
						}
						if( j >= N || map[i][j] == 0) answer++;
						else {
							while(true) {
								j++;
								if(j>=N || map[i][j] ==0) continue loop;
							}
						}
					}
				}
			}
			//세로
			for (int i = 0; i < N; i++) {
				loop : for (int j = 0; j < N; j++) {
					if (map[j][i] == 1) {
						int k = j + K;
						
						for (; j < k; j++) {
							if(j >= N || map[j][i] == 0) continue loop;
						}
						if( j >= N || map[j][i] == 0) answer++;
						else {
							while(true) {
								j++;
								if(j>=N || map[j][i] ==0) continue loop;
							}
						}
					}
				}
			}

			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}
}
