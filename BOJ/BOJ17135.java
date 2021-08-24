package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ17135 {
	
	static int Max = 0;
	static int N;
	static int M;
	static int D;
	static int[][] initmap;
	static int[][] resultmap;
	static int[][] map;
	static boolean[] v;
	static final int[] dr = {0,-1,0};
	static final int[] dc = {-1,0,1};
	
	static class Pair{
		int row;
		int col;
		int count=1;
		
		public Pair(int row, int col) {
			// TODO Auto-generated constructor stub
			this.row = row;
			this.col = col;
		}
		public Pair(int row, int col, int count) {
			// TODO Auto-generated constructor stub
			this.row = row;
			this.col = col;
			this.count = count;
		}
	}
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]); // N x M
		M = Integer.parseInt(input[1]); // N x M
		D = Integer.parseInt(input[2]); //거리
		
		//궁수는 3명
		
		initmap = new int[N][M];
		resultmap = new int[N][M];
		map = new int[N][M];
		v = new boolean[M];
		
		for(int i = 0 ; i < N ; i++) { // map 에 기록
			input = br.readLine().split(" ");
			for(int j = 0 ; j < M ; j++) {
				initmap[i][j] = resultmap[i][j] = map[i][j] = Integer.parseInt(input[j]);
			}
		}
		dfs(0,0);
		
		System.out.println(Max);
	}
	
	static int bfs(ArrayList<Pair> arr) {
		//궁수는 세명이다 
		//궁수는 최대 N 번 쏜다
		
		int result = 0;
		
		for(int t = 0 ; t < N; t++) { // 총 N 번 게임 할수 있음
			loop : for(int j = 0 ; j < 3 ; j++) {
				boolean[][] submap = new boolean[N][M]; // 방문 체크할 맵
				Queue<Pair> que = new LinkedList<Pair>();
				Pair temp = arr.get(j);
				if(map[temp.row][temp.col] == 1) { //적이 있을때
					resultmap[temp.row][temp.col] = 0; //적을 지움
					continue loop;
				}
				//적이 없을때
				submap[temp.row][temp.col] = true; // 방문 했다 표시
				que.add(temp);
				while(que.size() != 0) {
					Pair tpair = que.poll();
					
					if(tpair.count == D) break; //사정거리
					
					for(int d = 0 ; d < 3 ; d++) {
						int drow = dr[d] + tpair.row;
						int dcol = dc[d] + tpair.col;
						if(drow >= 0 && dcol >= 0 && drow < N && dcol < M && !submap[drow][dcol]) {
							if(map[drow][dcol] == 1) {
								resultmap[drow][dcol] = 0;
								continue loop;
							}
							que.offer(new Pair(drow, dcol,tpair.count+1));
							submap[drow][dcol] = true;
						}
					}
					
				}
			
			}
		
			//카운트 세기
			for(int i = 0; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(map[i][j] != resultmap[i][j]) result++;
				}
			}
			//맵 내리기
			map = DownMap();
			//맵 복사
			copyMap();
			//맵 체크
			if(checkMap()) break; // 탈출
		}
		
		return result;
	}
	
	static void dfs(int cnt,int T) {
		if(T == 3) { //궁수가 세명일때
			ArrayList<Pair> arr = new ArrayList<>();
			for(int i = 0 ; i < M ; i++) {
				if(v[i]) arr.add(new Pair(N-1, i)); //arr에 궁수 셋팅
			}
			initmap();
			Max = Math.max(Max, bfs(arr));
			return;
		}
		if(cnt == M) {
			return;
		}
		//넣을때
		v[cnt] = true;
		dfs(cnt + 1, T + 1);
		v[cnt] = false;
		//안 넣을때
		dfs(cnt+1, T);
	}
	
	static int[][] DownMap() {
		int[][] map2 = new int[N][M];
		
		for(int i = 1 ; i < N; i++) {
			for(int j = 0; j < M ; j++) {
				map2[i][j] = resultmap[i-1][j];
			}
		}
		
		return map2;
	}
	
	static void copyMap() {
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0; j < M; j++) {
				resultmap[i][j] = map[i][j];
			}
		}
	}
	
	static boolean checkMap() {
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0; j < M ; j++) {
				if(map[i][j] == 1) return false;
			}
		}
		return true;
	}
	
	static void initmap() {
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0; j < M ; j++) {
				map[i][j] = resultmap[i][j] = initmap[i][j];
			}
		}
	}
	
}
