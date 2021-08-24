import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1546 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String[] input = br.readLine().split(" ");
		double answer = 0;
		int max = 0;
		for(int i = 0 ;i < input.length ; i++) {
			answer += Integer.parseInt(input[i]);
			max = Math.max(max, Integer.parseInt(input[i]));
		}
		answer = answer/(double)max * 100;
		answer /= (double)input.length;
		System.out.println(answer);
	}
}
