package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW햄버거 {
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t= 1 ; t < T ; t++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]); // N
			int L = Integer.parseInt(input[1]); // L
			
			int[][] dp = new int[L+1][N+1];
			
			for(int i = 0 ; i < N ; i++) {
				input = br.readLine().split(" ");
				Food food = new Food(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			}
			sb.append("#" + t + " " );
		}
	}
	
	static class Food{
		int T; //점수 
		int K; //칼로리
		
		public Food(int T, int K) {
			this.T = T;
			this.K = K;
		}
	}
	
}
