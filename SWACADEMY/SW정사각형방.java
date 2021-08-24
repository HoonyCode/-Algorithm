package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SW정사각형방 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] dr = {0, 0, -1, 1};
		int[] dc = {1, -1, 0, 0};
		
		int T = Integer.parseInt(br.readLine());
		int[][] map;
		boolean[][] checkmap;
		for(int t = 1 ; t <= T ; t++) {
			int result = 0;
			int result2 = Integer.MAX_VALUE;
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			checkmap = new boolean[N][N];
			for(int i = 0 ; i < N ; i++) {
				String[] str = br.readLine().split(" ");
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			Stack<Index> stack = new Stack<>();
			
			//상하좌우
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(checkmap[i][j] == false) {
						stack.push(new Index(i, j));
						checkmap[i][j] = true;
					}else {
						continue;
					}
					int min = Integer.MAX_VALUE;
					int cnt = 0;
					
					while(!stack.empty()) {
						Index temp = stack.pop();
						if(min > map[temp.r][temp.c]) min = map[temp.r][temp.c];
						cnt++;
						for(int k = 0 ; k < 4 ; k++) {
							int row = temp.r + dr[k];
							int col = temp.c + dc[k];
							if(row >= 0 && row < N && col >= 0 && col < N && checkmap[row][col] == false && Math.abs(map[temp.r][temp.c] -  map[row][col]) == 1) {
								stack.push(new Index(row,col));
								checkmap[row][col] = true;
							}
						}
					}
					
					if(result == cnt && result2 > min){
						result2 = min;
					}
					
					if(result < cnt) {
						result = cnt;
						result2 = min;
					}
					
				}
			}
			
			sb.append("#" + t + " " +result2 + " "+ result + "\n");
		}
		System.out.println(sb.toString());
	}
	static class Index{
		int r;
		int c;
		public Index(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}

