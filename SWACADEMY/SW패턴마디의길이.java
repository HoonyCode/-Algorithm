package algo;

import java.util.Scanner;

public class SW패턴마디의길이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		for(int i = 0 ; i < T ; i++) {
			String str = sc.next();
			int count = 1;
			for(int j = 1 ; j < 15; j++) {
				String a = str.substring(0, j);
				String b = str.substring(str.length()-j,str.length());
				System.out.println(a + " : " + b);
				if(a.equals(b)) {
					count = str.substring(0, j).length();
					break;
				}
			}
			sb.append("#" + (i+1) + " " + count + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
