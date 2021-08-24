package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class SW암호문2 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		for(int t = 1 ; t <=10; t++) {
			LinkedList<Integer> list = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			for(int i = 0 ; i < N ; i++) {
				list.add(Integer.parseInt(str[i]));
			}
			N  = Integer.parseInt(br.readLine());
			str = br.readLine().split(" ");
			int cnt = 0;
			for(int i = 0; i < N ; i++) {
				char c = str[cnt++].charAt(0);
				if(c == 'I') {
					int index = Integer.parseInt(str[cnt++]);
					int num = Integer.parseInt(str[cnt++]);
					cnt = cnt + num - 1; //7;
					for(int j = 0 ; j < num ; j++) {
						list.add(index, Integer.parseInt(str[cnt - j]));
					}
					cnt++;
				}else {
					int index = Integer.parseInt(str[cnt++]);
					int num = Integer.parseInt(str[cnt++]);
					for(int j = 0 ; j < num ;j++) {
						list.remove(index);
					}
				}
			}
			sb.append("#" + t + " ");
			for(int i = 0 ; i < 10; i++) {
				sb.append(list.get(i) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
