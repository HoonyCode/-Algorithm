import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11660 {

	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[][] map = new int[N+1][N+1];

		for (int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				int Num =  Integer.parseInt(input[j-1]);
				map[i][j] = map[i][j-1] + map[i-1][j] + Num;
			}
		}
	
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		

//		for (int t = 0; t < M; t++) {
//			input = br.readLine().split(" ");
//			int r1 = Integer.parseInt(input[0]) - 1;
//			int c1 = Integer.parseInt(input[1]) - 1;
//			int r2 = Integer.parseInt(input[2]) - 1;
//			int c2 = Integer.parseInt(input[3]) - 1;
//			
//			int cnt = 0 ;
//			int idx = c2 - c1;
//			
//			for(int i = r1 ; i <= r2 ; i++) {
//				cnt += map[idx][i][c1];
//			}
//			
//			sb.append(cnt+"\n");
//		}
		System.out.print(sb);
	}

}
