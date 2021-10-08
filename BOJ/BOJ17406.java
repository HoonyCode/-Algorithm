

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17406 {
	static int[][] map;
	static int[][] map2;
	static boolean[] isSearch;
	static int Min = Integer.MAX_VALUE;
	static int N, M, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);
		
		map = new int[N][M];
		map2 = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			input = br.readLine().split(" ");
			for(int j = 0; j < M ; j++) {
				map2[i][j] = map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		Index[] index = new Index[K];
		for(int i = 0 ; i < K ; i++) {
			input = br.readLine().split(" ");
			index[i] = new Index(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
		}
		
		Index[] list = new Index[K];
		isSearch = new boolean[K];
		
		makelist(0, list, index);
		
		System.out.println(Min);
		
	}
	
	static void rotate(int s_row, int s_col, int e_row, int e_col, int R) {
		int r_length =  e_row - s_row+1;
		int s_lenght =  e_col - s_col+1;
		
		if(s_row == e_row) return;

		for(int r = 0; r < R; r++) {
		//돌리는 구문
				
			int temp = map[s_row][e_col];
			//상단 ->
			for(int i = e_col ; i >= s_col+1 ; i--) {
				map[s_row][i] = map[s_row][i-1];
			}
			//올리기
			for(int i = s_row ; i <= e_row -1 ; i++) {
				map[i][s_col] = map[i+1][s_col];
			}
			//하단 <-
			for(int i = s_col ; i <= e_col -1 ; i++) {
				map[e_row][i] = map[e_row][i+1];
			}
			//밑
			for(int i = e_row ; i >= s_row+1; i--) {
				map[i][e_col] = map[i-1][e_col];
			}

			map[s_row+1][e_col] = temp;
		}
	}
	static class Index{

		int r;
		int c;
		int s;
		
		public Index() {
			// TODO Auto-generated constructor stub
		}
		
		public Index(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
	static void cleanMap() {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = map2[i][j];
			}
		}
	}
	
	static void makelist(int cnt, Index[] list,Index[] index) {
		if(cnt == K) {
			for(int i = 0 ; i < K ; i++) {
				//rotate
				int s_row = list[i].r - list[i].s - 1;  
				int s_col = list[i].c - list[i].s - 1;
				int e_row = list[i].r + list[i].s - 1;
				int e_col = list[i].c + list[i].s - 1;
				
				for(int j = 0; j < list[i].s ; j++) {
					rotate(s_row + j, s_col + j, e_row - j, e_col - j, 1);
				}
				
			}
			for(int i = 0; i <N ; i++) {
				int result = 0;
				for(int j = 0 ; j < M ; j++) {
					result += map[i][j];
				}
				Min = Math.min(result, Min);
			}
			
			cleanMap();
			return;
		}
		
		
		for(int i = 0 ; i < K ; i++) {
			if(isSearch[i] == true) continue;
			
			isSearch[i] = true;
			list[cnt] = index[i];
			makelist(cnt+1, list, index);
			isSearch[i] = false;
		}
		
	}
}
