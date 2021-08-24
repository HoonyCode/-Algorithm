import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWContact {
	static int L;
	static int N;
	static List<Integer>[] list;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t < 11; t++) {
			list = new ArrayList[101];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			L = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < L; i = i + 2) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if (list[from] == null) {
					list[from] = new ArrayList<Integer>();
				}
				if (list[to] == null) {
					list[to] = new ArrayList<Integer>();
				}
				list[from].add(to);
			}
			v = new boolean[101];
			sb.append("#" + t + " " + bfs() + "\n");
		}
		System.out.println(sb.toString());
	}

	private static int maxNumber() {
		for (int i = 100; i > -1; i--) {
			if (v[i]) {
				return i;
			}
		}
		return 0;
	}

	private static int bfs() {
		Queue<Pair> que = new LinkedList<Pair>();
		que.offer(new Pair(N, 0));
		v[N] = true;
		
		Pair max = new Pair(0, 0);

		while (que.size() != 0) {
			Pair temp = que.poll();
			if(temp.cnt >= max.cnt) {
				if(temp.cnt == max.cnt) 
					max.num = Math.max(temp.num, max.num);
				else max = temp;
			}
			
			if (list[temp.num] != null) {
				for (int listtmep : list[temp.num]) {
					if (!v[listtmep]) {
						que.offer(new Pair(listtmep, temp.cnt + 1));
						v[listtmep] = true;
					}
				}
			}
		}
		
		return max.num;
	}

	static class Pair {
		int num;
		int cnt;

		public Pair(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}

	}
}
