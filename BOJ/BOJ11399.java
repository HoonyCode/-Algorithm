

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11399 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] input = new int[N];
		for(int i = 0 ; i < N ; i++) {
			input[i] = Integer.parseInt(str[i]);
		}
		Arrays.sort(input);
		int sum = 0;
		int now = 0;
		for(int i = 0 ; i < N ; i++) {
			sum += now;
			sum += input[i];
			now += input[i];
		}
		
		System.out.println(sum);
	}
}
