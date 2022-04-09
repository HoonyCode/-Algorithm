import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ1260 {
	
	static List<Integer>[] lists;
	static int N;
	static StringBuilder str = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int V = Integer.parseInt(input[2]);
		lists = new LinkedList[N+1];
		
		for(int i = 0 ; i < M ; i++) {
			input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			if(lists[from] == null) {
				lists[from] = new LinkedList<>();
			}
			if(lists[to] == null) {
				lists[to] = new LinkedList<>();
			}
			lists[from].add(to);
			lists[to].add(from);
		}
		
		for(int i = 1; i < N+1; i++) {
			if(lists[i] == null) continue;
			Collections.sort(lists[i]);
		}

	
		boolean[] visit = new boolean[N+1];
		dfs(V, visit);
		System.out.println(str.toString());
		bfs(V);
		
	}
	
	static void dfs(int start, boolean[] visit) {
		
		str.append(start + " ");
		
		visit[start] = true;
		
		for(Integer search : lists[start]) {
			if(visit[search]) continue;
			visit[search] = true;
			dfs(search, visit);
		}
		
	}
	
	static void bfs(int start) {
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> que = new LinkedList<>();
		boolean[] visit = new boolean[N+1];
		que.offer(start);
		visit[start] = true;
		
		while(que.size() != 0) {
			Integer temp = que.poll();
			
			sb.append(temp + " ");
			
			for(Integer search : lists[temp]) {
				if(visit[search]) continue;
				que.offer(search);
				visit[search] = true;
			}
		}
		
		System.out.println(sb.toString());
	}
}
