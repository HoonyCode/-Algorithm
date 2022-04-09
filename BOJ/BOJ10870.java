import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10870 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		
		if(N == 0) {
			System.out.println(0);
			return;
		}else if(N == 1) {
			System.out.println(1);
			return;
		}else {
			int[] res = new int[N+1];
			res[0] = 0;
			res[1] = 1;
			for (int i = 2; i <= N; i++) {
				res[i] = res[i-1] + res[i-2]; 
			}
			
			System.out.println(res[N]);
		}
		
		
		
	}
}
