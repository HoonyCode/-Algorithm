import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N 학생수 //K 방 크기
		// 0 : 여 1 : 남
		// 학년
		int[][] map = new int[2][7];
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			int sex = Integer.parseInt(input[0]);
			int year = Integer.parseInt(input[1]);
			map[sex][year]++;
		}
		int cnt = 0;
		for (int i = 0; i <= 1; i++) {
			for (int j = 1; j <= 6; j++) {
				if (map[i][j] % K == 0) {
					cnt += (map[i][j] / K);
				} else {
					cnt += (map[i][j] / K) + 1;
				}
			}
		}

		System.out.println(cnt);
	}
}
