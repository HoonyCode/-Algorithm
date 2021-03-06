import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] zero = new int[41];
		int[] one = new int[41];
		zero[0] = 1;
		one[1] = 1;
		for(int i = 2 ; i < 41 ; i++) {
			zero[i] = zero[i-2] + zero[i-1];
			one[i] = one[i-2] + one[i-1];
		}
		
		
		for(int t = 1 ; t <= T ; t++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(zero[num] + " " + one[num] +"\n");
		}
		
		System.out.println(sb.toString());
	}
}
