import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SW요리사 {
	static int[][] map;
	static int N;
	static boolean[] v;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T ; t++) {
			
			N  = Integer.parseInt(br.readLine());
			map = new int[N][N];
			//입력
			for(int i = 0 ;i < N ;i++) {
				String[] input = br.readLine().split(" ");
				for(int j = 0 ; j < N ; j++){
					map[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			//조합
			v = new boolean[N];
			answer = Integer.MAX_VALUE;
			
			comb(0,0);
			
			sb.append("#"+t + " " + answer +"\n");
			
		}
		System.out.println(sb.toString());
	}
	
	static void comb(int cnt,int r) {
		
		if(r == N/2) {
			ArrayList<Integer> food1 = new ArrayList<>();
			ArrayList<Integer> food2 = new ArrayList<>();
			
			for(int i = 0 ; i < N ; i++) {
				if(v[i]) {
					food1.add(i);
				}else {
					food2.add(i);
				}
			}
			
			int sum1 = 0;
			int sum2 = 0;
			
			for(int i = 0 ; i < food1.size() -1 ; i++) {
				for(int j = i ; j < food1.size(); j++) {
					sum1 += map[food1.get(i)][food1.get(j)] + map[food1.get(j)][food1.get(i)];
					sum2 += map[food2.get(i)][food2.get(j)] + map[food2.get(j)][food2.get(i)];
				}
			}
			answer = Math.min(answer, Math.abs(sum1-sum2));
			return;
		}
		
		
		
		for(int i = cnt ; i < N; i++) {
			v[i] = true;
			comb(i+1, r+1);
			v[i] = false;
		}
		
	}
}
