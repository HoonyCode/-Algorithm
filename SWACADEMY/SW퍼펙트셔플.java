package algo;

import java.io.*;

public class SW퍼펙트셔플 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T ; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append("#" + t + " ");
			String[] str = br.readLine().split(" ");
			int half = N/2;
			int j = N%2;
			for(int i = 0 ; i < half; i++) {
				sb.append(str[i] + " ");
				sb.append(str[i+half+j] +  " ");
			}
			if(j == 1) sb.append(str[half]);
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
