import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW7964 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int len = Integer.parseInt(input[1]);

			input = br.readLine().split(" ");
			int[] map = new int[N + 2];
			map[0] = map[N + 1] = 1;
			for (int i = 0; i < N; i++) {
				map[i + 1] = Integer.parseInt(input[i]);
			}
			int answer = 0;

			loop: for (int i = 0; i < N; i++) {
				if (map[i] == 1) {
					for (int j = i + 1; j <= i + len; j++) {
						if (j == N + 1)
							break loop;
						if (map[j] == 1) {
							i = j - 1;
							continue loop;
						}
					}
					// 아무것도 없다면
					map[i + len] = 1;
					answer++;
					i = i + len - 1;
				}
			}

			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}
}
