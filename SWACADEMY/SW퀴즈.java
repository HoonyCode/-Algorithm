package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SW퀴즈 {
	static final int mod = 1000000007;
	static long[] map = new long[1000001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T ; t++) {
			int N = Integer.parseInt(br.readLine());
			N++;
			double number = 0;
			for(int i = 1 ; i < N; i++) {
				number += pow(i,i);
				number %= 1000000007;
			}
			sb.append("#" + t + " "+ (int)number  + "\n");
		}
		System.out.println(sb.toString());
	}
	
	static double pow(int a, int b) {
		long result = 1;
		long mult = a;
		
		for(int i = 1; i <= b; i++) {
			result *= (double)a%1000000007;
			result %= (double)1000000007;
		}
		
		return result;
	}
}
