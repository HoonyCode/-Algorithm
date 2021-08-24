package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2567 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[101][101];
		int N = Integer.parseInt(br.readLine());
		
		for(int t = 0 ; t < N ; t++) {
			String[] input = br.readLine().split(" ");
			int col = Integer.parseInt(input[0]) + 1;
			int row = 91 - Integer.parseInt(input[1]);
			
			for(int i = row ; i <= row+9 ; i++) {
				for(int j = col; j <= col+9; j++) {
					map[i][j] = 1;
				}
			}
		}
		int result = 0;
		
		for(int i = 1 ; i <= 100 ;i++) {
			for(int j = 1 ; j <= 100; j++) {
				//세로 길이 체크 부분 0 -> 1 or 1 -> 0 로 가면 길이가 1인 변이 있다는 거임. 그리고 양 끝쪽이 1이면 길이 +1
				if(j == 1 && map[i][j] == 1) result++;
				if(j < 100) {
					if(map[i][j] != map[i][j+1]) result++; 
				}
				if(j == 100 && map[i][j] == 1)  result++;
				//가로 길이 체크 부분 0 -> 1 or 1 -> 0 로 가면 길이가 1인 변이 있다는 거임. 그리고 양 끝쪽이 1이면 길이 +1
				if(j == 1 && map[j][i] == 1) result++;
				if(j < 100) {
					if(map[j][i] != map[j+1][i]) result++; 
				}
				if(j == 100 && map[j][i] == 1)  result++;
			}
		}
		System.out.println(result);
	}
}

