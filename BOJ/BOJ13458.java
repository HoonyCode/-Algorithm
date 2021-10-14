import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ13458 {
	static int N;
	static long[] A;
	static long B, C;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new long[N];
		String[] input = br.readLine().split(" ");
		for(int i = 0; i < N ; i++) {
			A[i] = Integer.parseInt(input[i]);
		}
		input = br.readLine().split(" ");
		B = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		long res = 0;
		
		for(int i = 0; i < N; i++) {
			A[i] -= B;
			res++;
			if(A[i] < 1) continue;
			if(A[i] % C == 0) {
				res += A[i]/C;
				continue;
			}else {
				res += A[i]/C + 1;
			}
		}
		
		
		System.out.println(res);
		
	}
}
