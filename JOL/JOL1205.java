import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JOL1205 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] map = new int[N];
		String[] input = br.readLine().split(" ");
		int zerocnt = 0;
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(input[i]);
			if (map[i] == 0)
				zerocnt++;
		}
		Arrays.sort(map);
		int maxLength = zerocnt;
		
		for(int i = zerocnt ; i < N ; i++) {
			int zero = zerocnt;
			int len = 1;
			int j = i;
			int Num = map[j];
			while(true) {
				if( j + 1 < N && map[j+1] == Num) {
					j++;
					continue;
				}
				if( j + 1 < N && map[j+1] == Num +1) {
					Num++;
					j++;
					len++;
					continue;
				}
				if(zero > 0) {
					zero--;
					len++;
					Num++;
					continue;
				}
				maxLength = Math.max(len, maxLength);
				break;
			}
		}
		
		System.out.println(maxLength);
	}
}
