import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW5356 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			char[][] map = new char[5][15];
			
			for(int i = 0 ; i < 5; i++) {
				String input = br.readLine();
				for(int j = 0 ; j < input.length(); j++) {
					map[i][j] = input.charAt(j);
				}
			}
			
			char[] bin = new char[1];
			
			String answer = "";
			for(int i = 0 ; i < 15; i++) {
				for(int j = 0 ; j < 5; j++) {
					if(map[j][i] == bin[0]) continue;
					answer += map[j][i];
				}
			}
			
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb.toString());
	}
}
