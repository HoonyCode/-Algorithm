import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JOL1037 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		int row = 0;
		int col = 0;
		int rcnt = 0;
		int ccnt = 0;

		int rsum = 0;
		int csum = 0;

		for (int i = 0; i < N; i++) {
			rsum = 0;
			csum = 0;
			for (int j = 0; j < N; j++) {
				rsum += map[i][j];
				csum += map[j][i];
			}
			if (rsum % 2 == 1) {
				row = i;
				rcnt++;
			}
			if (csum % 2 == 1) {
				col = i;
				ccnt++;
			}
		}

		if (rcnt + ccnt == 0) {
			System.out.println("OK");
		} else if (rcnt == 1 && ccnt == 1) {
			System.out.println("Change bit (" + (row + 1) + "," + (col + 1) + ")");
		}else {
			System.out.println("Corrupt");
		}
	}
}
