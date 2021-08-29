import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW2005 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= T ; t++) {
			int N = Integer.parseInt(br.readLine());
			
			System.out.println("#"+t);
			int[] map = null;
			for(int i = 1; i <= N ; i++) {
				map = MakeMap(map, i);
				mapPrint(map, i);
			}
		}
	}
	static int[] MakeMap(int[] map, int N) {
		int[] newmap = new int[N];
		newmap[0] = 1;
		newmap[N-1] = 1;
		
		for(int i = 1 ; i < N-1; i++) {
			newmap[i] = map[i-1]+map[i];
		}
		return newmap;
	}
	static void mapPrint(int[] map, int N) {
		for(int i = 0; i < N ; i++) {
			System.out.print(map[i] + " ");
		}
		System.out.println();
	}
}
