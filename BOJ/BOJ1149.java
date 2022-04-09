import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		//각각 칠하는 경우를 따지자
		int[] R = new int[N+1];
		int[] G = new int[N+1];
		int[] B = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			
			String[] input = br.readLine().split(" ");
			int red = Integer.parseInt(input[0]);
			int Grn = Integer.parseInt(input[1]);
			int Ble = Integer.parseInt(input[2]);
			R[i] = Math.min(G[i-1] + red, B[i-1] + red);
			G[i] = Math.min(R[i-1] + Grn, B[i-1] + Grn);
			B[i] = Math.min(R[i-1] + Ble, G[i-1] + Ble);
		}
		
		
		System.out.println(Math.min(Math.min(R[N], G[N]), B[N]));
		
		
	}
}
