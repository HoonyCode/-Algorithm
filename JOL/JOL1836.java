import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class JOL1836 {

	private static int[] parents;
	private static int N;
	private static int M;

	private static void make() {
		parents = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static void union(int a, int b) {
		
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return;
		
		parents[bRoot] = aRoot;
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		make();
		
		for(int i = 0 ; i< M ; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			union(a, b);
		}
		
		int cnt = 0;
		for(int i =1 ; i <= N ; i++) {
			if(parents[i] == i) cnt++;
		}
		
		System.out.println(cnt);
	}
}
