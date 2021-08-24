package algo;

import java.io.InputStreamReader;
import java.util.Scanner;

public class SW사다리 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int[][] map;
		
		
		for(int t = 1 ; t <= 10 ; t++) {
			sc.nextInt();
			int dc = 99;
			int dl = 0;
			map = new int[100][100];
			for(int i = 0 ; i < 100; i ++) {
				
				for(int j = 0 ; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for(int i = 0 ; i < 100; i++) {
				if(map[99][i] == 2) {
					dl = i;
					break;
				}
			}
			
			while(true) {
				if(dc == 0) {
					break;
				}
				int light = dl + 1;
				int left = dl - 1;
				
				//우측
				if(light < 100 && map[dc][light] == 1) {
					map[dc][dl] =0;
					dl = light;
					continue;
				}
				//좌측
				if(left >= 0  && map[dc][left] == 1) {
					map[dc][dl] = 0;
					dl = left;
					continue;
				}
				//없으면 위로
				dc--;
				
				
			}
			
			sb.append("#" + t + " " + dl + "\n");
		}
		
		System.out.println(sb);
	}
	
}
