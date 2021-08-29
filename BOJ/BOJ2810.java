import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2810 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int people = input.length();
		int holder = input.replace("LL", "S").length() + 1;
		
		System.out.println(Math.min(people, holder));
		
	}
}
