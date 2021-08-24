package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class SW규영이와인영이의카드게임 {
	
	static int win = 0;
	static int lose = 0;
	static boolean[] v;
	static int[] map;
	static int[] map2;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T ; t++) {
			//1 ~ 18까지의 수가 적힌 18장 카드로 게임 9 장씩 나눔.
			//높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수를 얻는다
			
			boolean[] check = new boolean[19];
			map = new int[9];
			map2 = new int[9];
			String[] input = br.readLine().split(" ");
			
			for(int i = 0 ; i < 9 ; i++) {
				map[i] = Integer.parseInt(input[i]);
				check[map[i]] = true;
			}
		
			int cnt = 0;
			for(int i = 1 ; i < 19 ; i++) {
				if (check[i] == false) {
					map2[cnt++] = i;
				}
			}
			
			v = new boolean[9];
			win = 0;
			lose = 0;
			dfs(0,0,0);
			
			sb.append("#" + t + " "+ win + " " + lose + "\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int cnt, int num1, int num2) {
		
		if(cnt == 9) {
			if(num1 > num2) win++;
			if(num2 > num1) lose++;
			return;
		}
		
		//넣어야함
		for(int i = 0 ; i < 9; i++) {
			if(!v[i]) { // true가 아닐때,
				v[i] = true;
				if(map[cnt] > map2[i]) dfs(cnt+1, num1 + map[cnt] + map2[i], num2);
				else dfs(cnt+1, num1, num2 + map[cnt] + map2[i]);
				v[i] = false;
			}
		}
		
		
	}
}
