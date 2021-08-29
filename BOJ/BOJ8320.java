import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ8320 {

	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				if (i * j <= N)
					answer++;
				if (i * j > N)
					break;
			}
		}
		System.out.println(answer);
	}
}