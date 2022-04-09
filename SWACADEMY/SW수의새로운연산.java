import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW수의새로운연산 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int answer = 0;
		
		int[][] map = new int[300][300];
		int cnt = 0;
		for(int i = 1 ; i < 300; i++) {
			int x = 1;
			int y = i;
			while(true) {
				cnt++;
				map[y--][x++] = cnt;
				if(y == 0) break;
			}
		}
		
		
		
		
		for(int t = 1 ; t <= T ; t++) {
			String[] input = br.readLine().split(" ");
			int[] num = {Integer.parseInt(input[0]) ,Integer.parseInt(input[1])};
			
			int x =0;
			int y =0;
			
			for(int i = 0 ; i < 2; i++) {
				loop : for(int k = 1 ; k < 300 ; k++) {
					for(int l = 1 ; l < 300 ; l++) {
						if(num[i] == map[k][l]) {
							y += k;
							x += l;
							break loop;
						}
					}
				}
			}
			
			
			sb.append("#"+t + " " + map[y][x] + "\n");
		}

		System.out.println(sb.toString());
	}
	
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}
	}
	
}
