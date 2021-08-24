package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2961 {
	static Pair[] pair; 
	static long Min = 1000000000;
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		N = Integer.parseInt(br.readLine());
		pair = new Pair[N];
		for(int i = 0 ; i < N ; i++) {
			String[] input = br.readLine().split(" ");
			pair[i] = new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}
		R(0,0);
		System.out.println(Min);
	}
	
	static class Pair{
		long S;
		long B;
		
		public Pair(int S, int B) {
			// TODO Auto-generated constructor stub
			this.S = S;
			this.B = B;
		}
	}
	
	//비트 보고 판단하는것
	static void R(int cnt, int flag) {
		
		if(cnt == N) {
			if(flag == 0) return;
			long s = 1;
			long b = 0;
			
			for(int i = 0 ; i < N ; i++) {
				if((flag & 1 << i) != 0) { //들어있다는 말
					s *= pair[i].S;
					b += pair[i].B;
				}
			}
			Min = Math.min(Min, Math.abs(s-b));
			
			return;
		}
		//넣을때
		R(cnt + 1 , flag | 1 << cnt);
		
		//안 넣을때
		R(cnt +1 , flag);
		
		
	}
	
	//값 바로 넣는것
	static void R(int cnt, long s, long b) {

		if(!(s == 0 && b == 0)) {
			Min = Math.min(Min, Math.abs(s-b));
		}
		
		if(cnt == N) return;
		
		//넣을때
		if(s == 0 && b == 0){
			R(cnt+1, pair[cnt].S, pair[cnt].B);
		}
		R(cnt+1, s * pair[cnt].S, b + pair[cnt].B);
		
		//안 넣을때
		R(cnt+1, s , b);

		}
		
}
	
