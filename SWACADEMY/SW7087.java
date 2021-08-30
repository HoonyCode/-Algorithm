import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW7087 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int answer = 0;

			int N = Integer.parseInt(br.readLine());
			
			int cnt = 0;
			char[] map = new char[N];
			for(int i = 0; i < N ; i++) {
				map[i] = br.readLine().charAt(0);
			}
			Arrays.sort(map);
			
			for(int i = 0 ; i < N ; i++) {
				if(cnt == map[i]-'A') {
					cnt++;
					answer++;
				}
			}
			
			
			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}
}
