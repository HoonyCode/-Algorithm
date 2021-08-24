package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW암호생성기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= 10; t++) {
			br.readLine();
			String[] str = br.readLine().split(" ");
			int[] map = new int[8];
			for(int i = 0; i < 8 ; i++) {
				map[i] = Integer.parseInt(str[i]);
			}
			int pointer = 0;
			int cnt = 1;
			while(true) {
				if(cnt == 5) cnt = 1;
				if(pointer == 8) pointer =0;
				map[pointer] -= cnt;
				if(map[pointer] <= 0) {
					map[pointer] = 0;
					break;
					}
					pointer++;
					cnt++;
				}
				sb.append("#" + t + " ");
				for(int i = 0 ;i < 8; i++) {
					pointer++;
					if(pointer == 8) pointer = 0;
					sb.append(map[pointer] + " ");
				}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
