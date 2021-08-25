import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10163 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[1001][1001];
		int[] cnt = new int[N+1];

		for (int i = 1; i <= N; i++) {
			String[] input = br.readLine().split(" ");
			int col = Integer.parseInt(input[0]);
			int row = Integer.parseInt(input[1]);
			int clen = Integer.parseInt(input[2]);
			int rlen = Integer.parseInt(input[3]);

			for (int j = row; j < row + rlen; j++) {
				for (int l = col; l < col + clen; l++) {
					if(map[j][l] == 0) {
						cnt[i]++;
						map[j][l] = i;
					}else if(map[j][l] != 0) {
						cnt[map[j][l]]--;
						cnt[i]++;
						map[j][l] = i;
					}
				}
			}
		}
		for(int i = 1; i <= N ; i++) {
			sb.append(cnt[i] + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
