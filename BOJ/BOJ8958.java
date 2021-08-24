package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8958 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < T ; t++) {
			char[] map = br.readLine().toCharArray();
			int cnt = 1;
			int answer = 0;
			for(int i = 0 ; i < map.length; i++) {
				if(map[i] == 'O') {
					answer += cnt;
					cnt++;
				}else {
					cnt = 1;
				}
			}
			sb.append(answer+"\n");
		}
		System.out.println(sb.toString());
	}
}
