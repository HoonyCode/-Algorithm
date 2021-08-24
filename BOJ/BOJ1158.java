package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ1158 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
			
		boolean[] map = new boolean[N+1];
		
		int index = 1;
		int cnt = 1;
		int kcnt = 1;
		
		sb.append("<");
		while(true) {
			
			if(map[index] == false) {
				kcnt++;
			}
			
			if(kcnt == K+1) {
				map[index] = true;
				sb.append(index + ", ");
				cnt++;
				kcnt = 1;
			}
			
			index++;	
			if(index == N+1) index = 1;
			
			if(cnt == N+1) {
				break;
			}
		}
		
		
		System.out.println(sb.subSequence(0, sb.length()-2) + ">");
		
		
	}
}
