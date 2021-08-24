package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW부서진타일 {
	
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T ; t++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			char[][] map = new char[N][M];
			for(int i = 0 ; i < N ; i++) { //맵 받기
				String input = br.readLine();
				map[i] = input.toCharArray();
			}
			
			String result = "YES";
			
			loop : for(int i = 0; i < N-1; i++) {
				for(int j = 0; j < M-1; j++) {
					if(map[i][j] == '#') {
						
						for(int k = i; k < i+2; k++) {
							for(int l = j; l < j+2; l++) {
								if(map[k][l] == '.') {
									result = "NO";
									break loop;
								}
								map[k][l] = '.';
							}
						}
					}
					
				}
			}
			for(int i = 0 ; i < N ; i++) {
				if(map[i][M-1] == '#')
					result = "NO";
			}
			for(int i = 0 ; i < M ; i++) {
				if(map[N-1][i] == '#')
					result = "NO";
			}
			
			sb.append("#" + t + " " + result + "\n");
		}
		System.out.println(sb.toString());
	}
}
