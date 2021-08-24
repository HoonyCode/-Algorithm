package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1940 {
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//0 현재 속도 유지 
		//1 가속
		//2 감속
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T ; t++) {
			int N = Integer.parseInt(br.readLine());
			int result = 0;
			int velocity = 0;
			for(int i = 0 ; i < N; i++) {
				String[] input = br.readLine().split(" ");
				int command = Integer.parseInt(input[0]);
				int command2;
				
				if(command == 0){
					result += velocity;
				}else if(command == 1) {
					command2 = Integer.parseInt(input[1]);
					velocity += command2;
					result += velocity;
				}else {
					command2 = Integer.parseInt(input[1]);
					velocity = Math.max(velocity - command2, 0);
					result += velocity;
				}
			}
			sb.append("#" + t + " "+ result +"\n");
		}
		System.out.println(sb.toString());
	}
}
