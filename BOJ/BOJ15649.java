import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15649 {
	
	static int N, M;
	static int[] res;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		res = new int[M];
		v = new boolean[N+1];
		
		dfs(0);
	}
	
	static void dfs(int dept) { //dpet : 깊이를 받는다 
		
		if(dept == M) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0 ; i < M ; i++) {
				sb.append(res[i] + " ");
			}
			System.out.println(sb.toString());
			return;
		}
		
		for(int i = 1; i <= N ; i++) {
			if(v[i]) continue;
			res[dept] = i;
			v[i] = true;
			dfs(dept+1);
			v[i] = false;
		}
		return;
	}
}
