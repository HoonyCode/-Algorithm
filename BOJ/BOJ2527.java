import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2527 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 4; i++) {
			String[] input = br.readLine().split(" ");
			Pair A = new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]));
			Pair B = new Pair(Integer.parseInt(input[4]), Integer.parseInt(input[5]), Integer.parseInt(input[6]), Integer.parseInt(input[7]));
			
		}
	}
	
	static class Pair{
		int x1;
		int y1;
		int x2;
		int y2;
		public Pair(int x1, int y1, int x2, int y2) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
}
