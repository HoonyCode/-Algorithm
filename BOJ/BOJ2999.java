import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2999 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		N 글자이다.
		String input = br.readLine();
		int R = 0;
		int C = 0;
		for (int i = 1; i <= input.length() / 2; i++) {
			if (input.length() % i == 0) {
				if (input.length() / i >= i) {
					R = i;
					C = input.length() / R;
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(input.charAt(R * j + i));
			}
		}
		System.out.println(sb.toString());
	}
}
