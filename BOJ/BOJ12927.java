import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ12927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();
		char[] map = new char[input.length() + 1];
		for (int i = 0; i < input.length(); i++) {
			map[i + 1] = input.charAt(i);
		}
		int answer = 0;
		
		
		for(int i = 1 ; i <= input.length() ; i++) {
			if(map[i] == 'Y') {
				for(int j = 1 ; i*j <= input.length() ; j++) {
					if(map[i*j] == 'Y') map[i*j] = 'N';
					else map[i*j] = 'Y';
				}
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}
