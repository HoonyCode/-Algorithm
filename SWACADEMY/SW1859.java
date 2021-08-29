import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1859 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int answer = 0;
			
			int N = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			int[] map = new int[N];
			for(int i = 0; i < N ; i++) {
				map[i] = Integer.parseInt(input[i]);
			}
			
			int now = map[N-1];
			for(int i = N-1 ; i > -1 ; i--) {
				if(map[i] <= now) {
					answer += now - map[i];
				}else {
					now = map[i];
				}
			}
			
			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}
}
