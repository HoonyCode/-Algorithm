import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992 {
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			String[] input = br.readLine().split("");
			for(int j = 0 ; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		dfs(0, 0, N);
		System.out.println(sb.toString());
	}
	
	static void dfs(int row, int col, int size) {
		
		int sum = 0;
		for(int i = row ; i < row + size ; i++) {
			for(int j = col ; j < col + size; j++) {
				sum += map[i][j];
			}
		}
		
		if(sum == 0) {
			sb.append(0);
			return;
		}
		if(sum == size*size) {
			sb.append(1);
			return;
		}

		sb.append("(");
		dfs(row, col, size/2);
		dfs(row, col+size/2, size/2);
		dfs(row+size/2, col, size/2);
		dfs(row+size/2, col+size/2, size/2);
		sb.append(")");
	}
}
