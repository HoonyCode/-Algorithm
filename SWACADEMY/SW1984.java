import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW1984 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= T ; t++) {
			int[] arr = new int[10];
			String[] input = br.readLine().split(" ");
			for(int i = 0 ; i < 10 ;i++) {
				arr[i] = Integer.parseInt(input[i]);
			}
			Arrays.sort(arr);
			double sum = 0;
			for(int i = 1 ; i < 9 ; i++) {
				sum += arr[i];
			}
			sum /= 8;
			System.out.printf("#"+t+" %.0f\n",sum);
		}
	}
}
