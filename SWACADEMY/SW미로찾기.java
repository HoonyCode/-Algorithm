package algo;

import java.util.LinkedList;
import java.util.Queue;

public class SW미로찾기 {
	static int[][] map;
	
	public static void main(String[] args) {
		map = new int[][]{  
			{0,0,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,1},
			{1,1,1,0,1,1,1,1},
			{1,1,1,0,1,1,1,1},
			{1,0,0,0,0,0,0,1},
			{1,0,1,1,0,1,0,1},
			{1,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,1,0}
		};
//		0 : 갈수 있다. 1 : 갈수 없다.
		int row = map.length -1;
		int col = map[0].length -1;
		
		dfs(0, 0, 0);
		//bfs
		bfs(new Pair(0, 0), row, col);
	}
	
	static void bfs(Pair pair,int row, int col) {
		Queue<Pair> queue = new LinkedList<>();
		int[] drow = { 0,0,1,-1};
		int[] dcol = { 1,-1,0,0};
		
		queue.offer(pair);
		map[pair.row][pair.col]++;
		
		int count = 0;
		
		while(queue.size() != 0){
			Pair p = queue.poll();
			for(int i = 0 ; i < 4; i++) {
				int dr = p.row + drow[i];
				int dc = p.col + dcol[i];
				
				if(dr >= 0 && dc >= 0 && dr <= row && dc <= col && map[dr][dc] == 0) {
					map[dr][dc]++;
					queue.offer(new Pair(dr,dc, p.count + 1));
					if(dr == row && dc == col) {
						System.out.println("count : " + (p.count+1));
						return;
					}
				}
			}
		}
	}
	
	static void dfs(int x, int y, int cnt) {
		//목적지이면 멈춤
		if(x == map[0].length-1 && y == map.length - 1) {
			System.out.println("탈출 : "+cnt);
			return;
		}
		//4방위 탐색
		int[] drow = { 0,0,1,-1};
		int[] dcol = { 1,-1,0,0};
		
		int nx, ny;
		for(int d = 0 ; d < 4 ; d++) {
			nx = x + drow[d];
			ny = y + dcol[d];
			if(nx >= 0 && ny >= 0 && nx <= map.length-1 && ny <= map[0].length -1 && map[nx][ny] == 0) {
				map[nx][ny]++;
				dfs(nx,ny,cnt+1);
				map[nx][ny]--;
			}
		}
		
	}
	
	static class Pair{
		int row;
		int col;
		int count = 0;
		
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
		public Pair(int row, int col, int count) {
			this.row = row;
			this.col = col;
			this.count = count;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[ row : " + this.row + " col : " + this.col +"]\n";
		}
	}
}