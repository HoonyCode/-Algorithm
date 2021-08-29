import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ10158 {

	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int col = Integer.parseInt(input[0]);
		int row = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);
		int t = Integer.parseInt(br.readLine());
		int dr = 1; // y
		int dc = 1; // x;
		
		
		bw.append(x + " " + y);
		bw.flush();
	}
}
