

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16926 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int R = Integer.parseInt(input[2]);
		
		int[][] map = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			input = br.readLine().split(" ");
			for(int j = 0; j < M ; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		int c = Math.min(N, M)/2;
		
		for(int i = 0 ; i < c ; i++) {
			rotate(i, i, N-1-i, M-1-i, map, R);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static void rotate(int s_row, int s_col, int e_row, int e_col,int[][] map,int R) {
		int r_length =  e_row - s_row+1;
		int s_lenght =  e_col - s_col+1;
		
		R %= (2 * (r_length + s_lenght) - 4);
		
			for(int r = 0; r < R; r++) {
			//돌리는 구문
			//밑
			int temp = map[e_row][s_col];
			for(int i = e_row ; i >= s_row+1; i--) {
				map[i][s_col] = map[i-1][s_col];
			}
			//상단 <-
			for(int i = s_col ; i <= e_col -1 ; i++) {
				map[s_row][i] = map[s_row][i+1];
			}
			//올리기
			for(int i = s_col ; i <= e_row -1 ; i++) {
				map[i][e_col] = map[i+1][e_col];
			}
			//하단 ->
			for(int i = e_col ; i >= s_col+1 ; i--) {
				map[e_row][i] = map[e_row][i-1];
			}
			map[e_row][s_col+1] = temp;
		}
	}
}
