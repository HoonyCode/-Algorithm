import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1009 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int a, b;
			String[] input = br.readLine().split(" ");
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			sb.append(ipow(a, b, 10)).append('\n');
		}
		
		System.out.print(sb.toString());
	}
	
	private static long ipow(int a, int b, int c){
		long ans = 1;
	    while (b != 0) {
	        if (b % 2 == 1) {
	            ans *= a;
	            ans %= c;
	        }
	        a = a * a % c;
	        b /= 2;
	    }
	    
	    if(ans == 0)
	    	return 10;
	    
	    return ans;
	}
}
