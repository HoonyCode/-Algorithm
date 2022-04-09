import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ9205 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			Pair[] pair = new Pair[N + 2];
			for (int i = 0; i < N + 2; i++) {
				String[] input = br.readLine().split(" ");
				pair[i] = new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			}

			bfs(pair);
		}
		System.out.println(sb.toString());
	}

	static void bfs(Pair[] pairs) {
		boolean[] v = new boolean[pairs.length];

		Queue<Pair> que = new LinkedList<Pair>();
		que.offer(pairs[0]);
		v[0] = true;

		while (!que.isEmpty()) {
			Pair temp = que.poll();
			if (temp == pairs[pairs.length - 1]) { // 도착지에 들어옴
				sb.append("happy\n");
				return;
			}

			for (int i = 0; i < pairs.length; i++) {
				if (v[i])
					continue; // 탐색한 곳임

				int len = Math.abs(temp.x - pairs[i].x) + Math.abs(temp.y - pairs[i].y); // 거리 구하기
				if (len <= 1000) { // 거리가 1000이하이면 큐에 넣을수 있다
					que.offer(pairs[i]);
					v[i] = true;
				}

			}

		}

		sb.append("sad\n"); // happy를 출력하지 못하면 sad를 출력함
		return;
	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}