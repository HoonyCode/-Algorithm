package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW스도쿠검증 {
	
	static int[][] map = new int[9][9];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ;t <= T ; t++) { //테스트 케이스 만큼 돌림
			for(int i = 0 ; i < 9 ; i++) { //map 넣기
				String[] input = br.readLine().split(" ");
				for(int j = 0 ; j < 9; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}
			int answer = 0; // 답은 아니다 라고 초기화 시켜놈 바로 나가는 경우일때 아니다라고 하기 위함.
			oneblock : {
				//3개씩 돌리는 곳
				for(int i = 0 ; i < 9 ; i = i+3) {
					for(int j = 0; j < 9 ; j = j +3) {
						
						boolean[] v = new boolean[10]; //탐색 방문
						for(int k = i ; k < i+3 ; k++) {
							for(int l = j; l < j+3; l++) {
								if(v[map[k][l]] == false) {
									v[map[k][l]] = true;
								}else {
									break oneblock;
								}
							}
						}
					}
				}
				
				//세로
				for(int i = 0; i < 9 ; i++) {
					boolean[] v = new boolean[10]; //탐색 방문
					for(int j = 0 ; j < 9; j++) {
						if(v[map[i][j]] == false) {
							v[map[i][j]] = true;
						}else {
							break oneblock;
						}
					}
				}
				
				//가로
				for(int i = 0; i < 9 ; i++) {
					boolean[] v = new boolean[10]; //탐색 방문
					for(int j = 0 ; j < 9; j++) {
						if(v[map[j][i]] == false) {
							v[map[j][i]] = true;
						}else {
							break oneblock;
						}
					}
				}
				answer = 1; //완전히 다 돌았으면 참
			}
			
			sb.append("#" + t + " " + answer + "\n"); //답 기록
		}
		System.out.println(sb.toString());
	}
}
