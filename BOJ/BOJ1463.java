import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BOJ1463 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int map[] = new int[N + 1];

		map[1] = 0;

		int result;

		for (int i = 2; i < N + 1; i++) {

			result = Integer.MAX_VALUE;

			if (i % 3 == 0) {
				result = Math.min(result, map[i / 3] + 1);

			}
			if (i % 2 == 0) {
				result = Math.min(result, map[i / 2] + 1);
			}
			if (i - 1 > 0)
				map[i] = Math.min(result, map[i - 1] + 1);
		}
		System.out.println(map[N]);

	}
}
