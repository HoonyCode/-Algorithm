import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10818 {	
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int min = 1_000_000;
		int max = -1_000_000;
		
		String[] input = br.readLine().split(" ");
		for(int i = 0 ; i < N ; i++) {
			min = Math.min(min, Integer.parseInt(input[i]));
			max = Math.max(max, Integer.parseInt(input[i]));
		}
		
		System.out.println(min + " " + max);
	}

}
