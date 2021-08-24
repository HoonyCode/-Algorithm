import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1008 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		double answer = (double)Integer.parseInt(input[0])/Integer.parseInt(input[1]);
		System.out.println(answer);
	}

}
