package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11723 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		int flag = 0;
		for(int i = 0 ; i < M ; i++) {
			String[] input = br.readLine().split(" ");
			String type = input[0];
			int num = 0;
			
			switch (type) {
			case "add":
				num = Integer.parseInt(input[1]);
				if((flag & 1 << num) != 0) break;   //  0일 아니면 있다.
				flag += 1 << num;
				break;
			case "remove":
				num = Integer.parseInt(input[1]);
				if((flag & 1 << num) != 0) {   //  0일 아니면 있다.
					flag -= 1 << num;
				}
				break;
			case "check":
				num = Integer.parseInt(input[1]);
				if((flag & 1 << num) != 0) {   //  0일 아니면 있다.
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
				break;
			case "toggle":
				num = Integer.parseInt(input[1]);
				if((flag & 1 << num) != 0) { // 0이 아니면 있다.
					flag -= 1<<num;
				}else {
					flag += 1<<num;
				}
				break;
			case "all":
				flag = -1;
				break;
			case "empty":
				flag = 0;
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
