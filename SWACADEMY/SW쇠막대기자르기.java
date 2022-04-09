package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW쇠막대기자르기 {
	
	
	public static void main(String[] args) throws  IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= T ; t++) {
			char[] str = br.readLine().toCharArray();
			int result = 0;
			int cnt = 0;
			
			for(int i = 0 ; i < str.length ; i++) {
				if(str[i] == '(') {
					if(str[i+1] == ')') {
						//레이저
						result += cnt;
						i++;
						continue;
					}
					cnt++;
				}else {
					result++;
					cnt--;
				}
				
			}
			
			sb.append("#" + t + " " + result + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
