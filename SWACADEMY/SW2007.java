import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW2007 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int answer = 0;

			String input = br.readLine();

			String a = "";
			for (int i = 0; i < 10; i++) {
				String b = "";
				a += input.charAt(i);
				for (int j = i + 1; j < i + 1 + a.length(); j++) {
					b += input.charAt(j);
				}
				if (a.equals(b)) {
					answer = a.length();
					break;
				}
			}

			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}
}
