

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ4963 {
	
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			
			if(N == 0) break;
			
			int[][] map = new int[M][N];
			
			for(int i = 0 ; i < M; i++) {
				input = br.readLine().split(" ");
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			int answer = 0;
			for(int i = 0 ; i < M; i++) {
				for(int j = 0 ; j < N ; j++) {
					if (map[i][j] == 1) {
						bfs(map, i, j);
						answer++;
					}
				}
			}
			
			System.out.println(answer);
		}
		
	}
	
	static void bfs(int[][] map, int row, int col) {
		Queue<Pair> que = new LinkedList<>();
		int[] dr = {-1,1,0,0,1,-1,1,-1};
		int[] dc = { 0,0,-1,1,1,-1,-1,1};
		
		que.offer(new Pair(row, col));
		map[row][col] = 0;
		
		while(que.size() != 0) {
			Pair temp = que.poll();
			
			for(int i = 0 ; i < 8; i++ ) {
				int drow = temp.row + dr[i];
				int dcol = temp.col + dc[i];
				
				if(drow >= 0 && drow < M && dcol >= 0 && dcol < N && map[drow][dcol] == 1) {
					que.offer(new Pair(drow, dcol));
					map[drow][dcol] = 0;
				}
				
			}
		}
		
	}
	
	static class Pair{
		int row;
		int col;
		
		public Pair(int row, int col) {
			// TODO Auto-generated constructor stub
			this.row = row;
			this.col = col;
		}
	}
}
