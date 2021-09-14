import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4789 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int answer = 0;
			int sum = 0 ;
			String input = br.readLine();

			for (int i = 0; i < input.length(); i++) {
				if(sum >= i ) {
					sum += Integer.parseInt(input.charAt(i)+"");
				}else {
					answer++;
					sum++;
					sum += Integer.parseInt(input.charAt(i)+"");
				}
			}

			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}
}
