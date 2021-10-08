import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2217 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] map = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(map);
		int max = 0;
		for(int i = 0 ; i < N ; i++) {
			if( max < map[i] * (N-i)) {
				max = map[i] * (N-i);
			}
		}
		
		System.out.println(max);
	}
}
