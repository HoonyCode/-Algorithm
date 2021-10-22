import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1058 {
	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (input[j] == 'N') {
					map[i][j] = 100;
				} else {
					map[i][j] = 1;
				}
			}
		}
		
		// 플로이드 워셜

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(i == k) continue;
				for (int j = 0; j < N; j++) {
					if(i == j || j == k) continue;
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		System.out.print(result());

	}
	
	static int result() {
		int res = 0;
		
		for(int i = 0; i < N ; i++) {
			int nowres = 0;
			for(int j = 0 ; j < N ; j++) {
				if(i == j) continue;
				if(map[i][j] <= 2) nowres++;
			}
			res = Math.max(res, nowres);
		}
		
		
		return res;
	}
	
}
