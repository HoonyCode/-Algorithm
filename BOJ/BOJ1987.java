import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ1987 {
	
	static final int[] dr = {1,-1,0,0}; //상 하 좌 우
	static final int[] dc = {0,0,-1,1};
	static char[][] map;
	static int[][] v;
	static int R;
	static int C;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		
		map = new char[R][C];
		v = new int[R][C];
		
		for(int i = 0 ; i < R ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int flag = 0;
		flag = flag | 1 << (map[0][0] -'A');
		dfs(0,0,flag, 1); //dfs 시작 
		System.out.println(max);
	
		
	}
	
	
	static void dfs(int row, int col,int flag, int cnt) {
		if(v[row][col] == flag) return;
		v[row][col] = flag;
		
		for(int d = 0 ; d < 4 ; d++) { // 4방향 탐색
			int drow = dr[d] + row;
			int dcol = dc[d] + col;
			if(drow < 0 || dcol < 0 || drow >= R || dcol >= C) continue; // outofbound 처리
			if((flag & 1 << (map[drow][dcol] - 'A')) != 0) continue; //flag 처리
			
			dfs(drow, dcol, flag | 1 << (map[drow][dcol] - 'A'), cnt+1); //dfs
		}
		
		max = Math.max(max, cnt);
		
	}
}
