import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10950 {
	
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < T ; i++) {
			String[] input = br.readLine().split(" ");
			sb.append((Integer.parseInt(input[0])+Integer.parseInt(input[1]))+"\n");
		}
		
		System.out.println(sb.toString());
	}
	
}
