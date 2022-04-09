import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14696 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int[] A = new int[5];
			int[] B = new int[5];
			String[] input = br.readLine().split(" ");
			for (int i = 1; i <= Integer.parseInt(input[0]); i++) {
				A[Integer.parseInt(input[i])]++;
			}
			input = br.readLine().split(" ");
			for (int i = 1; i <= Integer.parseInt(input[0]); i++) {
				B[Integer.parseInt(input[i])]++;
			}

			char answer = 'D';
			for (int i = 4; i > 0; i--) {
				if (A[i] > B[i]) {
					answer = 'A';
					break;
				} else if (A[i] < B[i]) {
					answer = 'B';
					break;
				}
			}
			sb.append(answer + "\n");
		}

		System.out.println(sb.toString());
	}
}
