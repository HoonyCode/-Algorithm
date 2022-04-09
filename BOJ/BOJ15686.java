

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ15686 {
	
	static int Min = Integer.MAX_VALUE;
	static ArrayList<Pair> arr;
	static int N;
	static int M;
	static int[][] map;
	static int[][] submap;
	static boolean[] v;
	static final int[] dr = {0,0,1,-1};
	static final int[] dc = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]); // 수익을 가장 많이 낼 수 있는 개수
		
		
		map = new int[N][N];
		//1부터 시작 
		//사이의 거리 r1-r2 + c1-c2;
		
		//map 넣기
		arr = new ArrayList<>(); 
		for(int i = 0 ; i < N ; i++) {
			input = br.readLine().split(" ");
			for(int j =0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if(Integer.parseInt(input[j]) == 2) {
					arr.add(new Pair(i, j, 0));
				}
			}
		}
		v = new boolean[arr.size()];
		
		dfs(0, 0);
		
		System.out.println(Min);
	}
	
	
	static class Pair{
		int row;
		int col;
		int count;
		
		public Pair(int row, int col, int count) {
			this.col =col;
			this.row = row;
			this.count = count;
		}
	}
//	static int bfs(int row, int col) {
//		
//		submap = new int[N][N];//치킨집 맵 셋팅
//		for(int i = 0 ; i < arr.size(); i++) {
//			if(v[i]) {// true이면 실행
//				Pair temp = arr.get(i);
//				submap[temp.row][temp.col] = 2;
//			}
//		}
//		
//		Queue<Pair> que = new LinkedList<>();
//		que.offer(new Pair(row, col, 0));
//		submap[row][col] = 1;
//		
//		while(que.size() != 0) {
//			Pair temp = que.poll();
//			
//			for(int d = 0 ; d < 4 ; d++) {
//				int drow = temp.row + dr[d];
//				int dcol = temp.col + dc[d];
//				
//				if(drow >= 0 && drow < N && dcol >= 0 && dcol < N && submap[drow][dcol] != 1) {
//					if(submap[drow][dcol] == 2) {
//						return temp.count + 1;
//					}
//					submap[drow][dcol] = 1;
//					que.offer(new Pair(drow, dcol, temp.count + 1));
//				}
//				
//			}
//			
//		}
//		return Integer.MAX_VALUE;
//		
//	}
	
	static void dfs(int cnt,int T) {
		
		
		if(T == M) {
			int result = 0;
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(map[i][j] == 1){
						int min = Integer.MAX_VALUE;
						for(int k = 0; k < arr.size(); k++) {
							if(v[k]) {// true;
								Pair temp = arr.get(k);
								min = Math.min(min, Math.abs(temp.row - i) + Math.abs(temp.col - j));
							}
						}
						result += min;
						if(result >= Min) return;
					}
					if(result >= Min) return;
				}
			}	
			Min = Math.min(Min, result);
			return;
		}
		
		if(cnt == arr.size()) {
			return;
		}
		
		//넣을 때
		v[cnt] = true;
		dfs(cnt+1, T+1);
		v[cnt] = false;
		//안넣을 때
		dfs(cnt +1 , T);
	}
	
}
