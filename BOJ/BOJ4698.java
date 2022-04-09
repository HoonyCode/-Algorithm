import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ4698 {
	static boolean[] Sosu = new boolean[1000001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Sosu[1] = true;
		
		//소수 만들기
		for(int i = 2 ; i < 1000001 ; i++) {
			if(Sosu[i] == true) continue;
			for(int j = 2 ; i*j < 1000001 ; j++) {
				Sosu[i*j] = true;
			}
		}
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= T ; t++) {
			int answer = 0;
			
			String[] input = br.readLine().split(" ");
			int D = Integer.parseInt(input[0]);
			int A = Integer.parseInt(input[1]);
			int B = Integer.parseInt(input[2]);
			
			//A이상 B이하
			for(int i = A ; i <= B ; i++) {
				if(Sosu[i] == false) {
					String str = i+"";
					for(int j = 0 ; j < str.length() ; j++) {
						if(D == str.charAt(j)-'0') {
							answer++;
							break;
						}
					}
				}
			}
			
			
			sb.append("#"+t+ " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}
}
