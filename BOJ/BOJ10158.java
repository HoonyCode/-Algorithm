import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ10158 {

	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder sb = new StringBuilder();
		String[] input = br.readLine().split(" ");
		int col = Integer.parseInt(input[0]);
		int row = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);
		int t = Integer.parseInt(br.readLine());

		x = (x + t) % (2 * col);
		y = (y + t) % (2 * row);
		if (x > col) {
			x = 2 * col - x;
		}
		if (y > row) {
			y = 2 * row - y;
		}
		System.out.println(x + " " + y);
	}
}
