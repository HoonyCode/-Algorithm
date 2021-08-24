package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW7272 {
	
	static final String str1 = "C|E|F|G|H|I|J|K|L|M|N|S|T|U|V|W|X|Y|Z";
	static final String str2 = "A|D|O|P|Q|R";
	static final String str3 = "B";
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <=T ; t++) {
			String[] input = br.readLine().split(" ");
			
			for(int i = 0 ; i < 2 ; i++) {
				input[i] = input[i].replaceAll(str1, "0").replaceAll(str2, "1").replaceAll(str3, "2");
			}
			sb.append("#" + t);
			if(input[0].equals(input[1])) {
				sb.append(" SAME\n");
			}else {
				sb.append(" DIFF\n");
			}
		}
		System.out.println(sb.toString());
	}
}
