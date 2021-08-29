
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1753 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int V = Integer.parseInt(input[0]) + 1; // 정점 갯수
		int E = Integer.parseInt(input[1]);
		int start = Integer.parseInt(br.readLine());

		int[][] matrix = new int[V][V];
		final int INFINITY = Integer.MAX_VALUE;

		for (int i = 0; i < E; i++) {
			input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			int weight = Integer.parseInt(input[2]);
			matrix[from][to] = weight;
		}

		for (int t = 1; t < V; t++) {
			int[] D = new int[V];
			boolean[] v = new boolean[V];

			int end = t; // 도착점 인덱
			Arrays.fill(D, INFINITY);
			D[start] = 0;

			int min = 0, current = 0;
			for (int i = 0; i < V; ++i) {
				// a단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
				min = INFINITY;
				for (int j = 0; j < V; ++j) {
					if (v[j]) {
						continue;
					}
					if (D[j] < min) {
						min = D[j];
						current = j;
					}
				}
				v[current] = true; // 선택 정점 방문 처리
				if (current == end) { // 선택 정점이 도착정점이면 탈출.
					break;
				}

				// b단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
				for (int c = 0; c < V; ++c) {
					if (v[c]) {
						continue;
					}
					if (matrix[current][c] == 0) {
						continue;
					}
					if (D[c] > min + matrix[current][c]) {
						D[c] = min + matrix[current][c];
					}
				}
			}

			if (D[end] == INFINITY) {
				System.out.println("INF");
			} else
				System.out.println(D[end]);
		}

	}

}
