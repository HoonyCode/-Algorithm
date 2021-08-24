import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2739 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i < 10; i++) {
			sb.append(N +" * " + i +" = " + (N*i) + "\n");
		} 
		System.out.println(sb.toString());
	}
}
