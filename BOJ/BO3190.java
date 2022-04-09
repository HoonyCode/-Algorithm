import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BO3190 {
	static int N;
	static int K;
	static int[][] map;
	static int res;

	static final int apple = 2;
	static final int snack = 1;
	static Queue<int[]> check;

	static int[] dr = { 0, -1, 0, 1 }; // 좌 상 우 하
	static int[] dc = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];

		String[] input;
		for (int i = 0; i < K; i++) {
			input = br.readLine().split(" ");
			map[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = apple;
		}
		int L = Integer.parseInt(br.readLine());
		check = new LinkedList<>();
		for (int i = 0; i < L; i++) {
			input = br.readLine().split(" ");
			check.offer(new int[] { Integer.parseInt(input[0]), input[1].charAt(0) });
		}

		System.out.println(bfs(new int[] { 1, 1 }));

	}

	private static int bfs(int[] is) {
		Queue<int[]> len = new LinkedList<>();
		len.offer(is);
		map[is[0]][is[1]] = snack; // 스네이크 표시

		int direction = 2; // 오른쪽을 향한다.
		int time = 0;

		int[] temp_check;
		int drow = is[0];
		int dcol = is[1];

		while (true) {
			time++;
			


			// 방향 정리
			if (!check.isEmpty()) {
				temp_check = check.peek();
				if (time > temp_check[0]) {
					check.poll(); // 하나 뺴고
					if (temp_check[1] == 'L') {
						direction--;
						if (direction < 0) {
							direction = 3;
						}
					} else {
						direction++;
						if (direction > 3) {
							direction = 0;
						}
					}

				}
			}

			drow = drow + dr[direction];
			dcol = dcol + dc[direction];

			if (drow < 1 || drow > N || dcol < 1 || dcol > N)
				return time; // 벽에 부딪혔을때
			if (map[drow][dcol] == snack)
				return time; // 자기 자신과 만났을때

			// 사과가 아닐때 자신의 흔적을 지워야함
			if (map[drow][dcol] != apple) {
				int[] temp = len.poll();
				map[temp[0]][temp[1]] = 0;
			}
			
			//표시하고
			map[drow][dcol] = snack;
			
			// 머리 넣고
			len.offer(new int[] { drow, dcol });
			
			

			
		}

	}
	
	static void Print() {
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j  <= N ; j++) {
				sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
