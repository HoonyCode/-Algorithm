package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW농작물수확하기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= T ; t++) {
			int count = 0;
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N+1][N+1];
			
			for(int i = 1; i <= N ;i++) {
				char[] line = br.readLine().toCharArray();
				for(int j = 1; j <= N ;j++) {
					map[i][j]= line[j-1] - '0';
				}
			}
			
			int start = N/2 + 1; //3 ->1
			int end = N/2 + 1;
			int num = 1;
			
			for(int i = 1 ; i <= N; i++) {
				for(int j = start ; j <= end ;j++){
					count += map[i][j];
				}
				if(end == N)
					num = -1;
				
				start -= num;
				end += num;
			}
			sb.append("#" + t + " " + count + "\n");
		}
		System.out.println(sb.toString());
	}
}
