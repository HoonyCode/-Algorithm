import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SW1123 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t = 1 ; t < 11 ; t++) {
			int answer = 0;
			int N = Integer.parseInt(br.readLine()); // N
			String[] input = br.readLine().split("");
			for(int i = 1 ; i < N ; i=i+2) {
				if(input[i].equals("*")) {
					input[i+1] = Integer.parseInt(input[i-1]) * Integer.parseInt(input[i+1]) + "";
					input[i-1] = "+";
					input[i] ="+";
				}
			}
			
			for(int i = 0 ; i < N ; i++) {
				if(input[i].equals("+")) continue;
				answer += Integer.parseInt(input[i]);
			}

			sb.append("#"+t +" "+ answer + "\n");
		}
		System.out.println(sb.toString());
	}

}
