import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2458 {
		static int N, M;
		static boolean[][] map;
		static int[] cnt;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		map = new boolean[N+1][N+1];
		cnt = new int[N+1];
		
		for(int i = 0 ; i < M ; i++) {
			input = br.readLine().split(" ");
			map[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = true;
		}
		
		for(int i = 1 ; i < N+1; i++) {
			bfs(i);
		}
	
		
		int res = 0;
		for(int i = 1 ; i < N+1; i++) {
			if(cnt[i] == N) res++;
		}
		
		System.out.println(res);
		
		
		return;
	}
	
	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();
		
		boolean[] v = new boolean[N+1];
		que.add(start);
		v[start] = true;
		
		int total = 0;
		
		while(!que.isEmpty()) {
			
			int row = que.poll();
			
			for(int i = 1 ; i < N+1 ; i++) {
				if(map[row][i] == true && !v[i]) {
					que.add(i);
					v[i] = true;
					cnt[i]++;
					total++;
				}
			}
			
		}
		cnt[start] += total + 1;
		
	}
}
