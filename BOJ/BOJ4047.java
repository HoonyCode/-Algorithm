import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			int[][] card = new int[4][14];
			int[] cardcnt = {13, 13 ,13 ,13};
			boolean check = false;
			// S 0
			// D 1
			// H 2
			// C 3
			String[] input = br.readLine().replace("S", "0").replace("D", "1").replace("H", "2").replace("C", "3")
					.split("");

			for (int i = 0; i < input.length; i = i + 3) {
				int r = Integer.parseInt(input[i]);
				int num = Integer.parseInt(input[i + 1])*10 + Integer.parseInt(input[i + 2]);
				card[r][num]++;
				if (card[r][num] > 1)
					check = true;
				cardcnt[r]--;
			}
			
			if(check) {
				sb.append("#" + t + " ERROR\n");
			}else {
				sb.append("#" + t + " ");
				for(int i = 0 ; i < 4;  i++) {
					sb.append(cardcnt[i] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
