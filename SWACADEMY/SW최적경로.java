import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW최적경로 {
	
	static int min ;
	static int N;
	static Pair[] pair;
	static boolean[] v;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T ; t++) {
			N = Integer.parseInt(br.readLine()); //고객의 수
			pair = new Pair[N+2];
			v = new boolean[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			pair[0] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			pair[N+1] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			for(int i = 1; i <= N; i++) {
				pair[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			min = Integer.MAX_VALUE;
			dfs(1, pair[0], 0);
			
			
			sb.append("#" + t + " " + min + "\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int cnt, Pair expair ,int sum){
		
		if(sum >= min) return;
		
		if(cnt == N+1) {
			sum += Math.abs(expair.row - pair[N+1].row) + Math.abs(expair.col - pair[N+1].col);
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = 1 ; i < N+1 ; i++) {
			if(v[i]) continue;
			v[i] = true;
			dfs(cnt+1, pair[i], sum + Math.abs(expair.row - pair[i].row) + Math.abs(expair.col - pair[i].col));
			v[i] = false;
		}
		
	}
	
	static class Pair{
		int row;
		int col;
		
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
