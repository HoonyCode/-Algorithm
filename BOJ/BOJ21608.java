import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ21608 {

	static int N;
	static ArrayList<Integer>[] list;
	static int[][] map;
	static int[] Num;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N]; // N * N 크기만큼 설정
		Num = new int[N * N]; // N * N 명의 사람 순서를 받아놓음
		list = new ArrayList[N * N + 1]; // N * N + 1 번까지 사람이 있음. 종아하는 사람 받는 부분

		for (int i = 0; i < N * N; i++) { // 사람 순서와 좋아하는 사람 받는 부분
			String[] input = br.readLine().split(" ");
			Num[i] = Integer.parseInt(input[0]);
			list[Num[i]] = new ArrayList<>();
			for (int j = 1; j < 5; j++) {
				list[Num[i]].add(Integer.parseInt(input[j]));
			}
		}

		init(); // 초기값 설정 처음은 빈칸만 찾으면 됨

		for (int i = 1; i < N * N; i++) { // init에서 num[0]을 집어 넣었으니깐 Num[1]번부터 집어 넣을꺼야
			insert_map(Num[i]); // num[1] => 3을 가리치고 있음
		}

		happy_val(); // 행복감을 알려줌

		System.out.println(res); // 결과값 출력

	}

	// 만족도 메서드
	static void happy_val() {

		int drow;
		int dcol;
		int like;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				like = 0;

				for (int d = 0; d < 4; d++) {
					drow = dr[d] + i;
					dcol = dc[d] + j;

					if (drow < 0 || dcol < 0 || drow >= N || dcol >= N)
						continue;

					for (int search : list[map[i][j]]) {
						if (search == map[drow][dcol]) {
							like++;
							break;
						}
					}
				}
				// 만족도
				switch (like) {
				case 1:
					res += 1;
					break;
				case 2:
					res += 10;
					break;
				case 3:
					res += 100;
					break;
				case 4:
					res += 1000;
					break;
				}
			}
		}
	}

	// Num[0] 넣는 메서드
	static void init() {
		for (int i = 0; i < N; i++) {
			int count;
			for (int j = 0; j < N; j++) {
				count = 4;
				if (i == 0 || i == N - 1)
					count--;
				if (j == 0 || j == N - 1)
					count--;

				if (count == 4) { // 칸수가 제일 많으면 그만해
					map[i][j] = Num[0];
					return;
				}

			}
		}
	}

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	// 맵에 채워 넣는 메서드
	static void insert_map(int num) {
		Pair now;
		Pair max = new Pair(-1, -1);

		int row = -1;
		int col = -1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0)
					continue;
				now = searchMap(i, j, num);

				if (max.like < now.like) {
					max = now;
					row = i;
					col = j;
				} else if (max.like == now.like) {
					if (max.empty < now.empty) {
						max = now;
						row = i;
						col = j;
					}
				}
			}
		}
		map[row][col] = num;

	}

	// like 와 empty를 계산해주는 메서드
	static Pair searchMap(int row, int col, int num) {

		int like = 0;
		int empty = 0;
		int drow;
		int dcol;
		// 탐색
		for (int d = 0; d < 4; d++) {
			drow = dr[d] + row;
			dcol = dc[d] + col;

			if (drow < 0 || dcol < 0 || drow >= N || dcol >= N)
				continue;
			if (map[drow][dcol] == 0) { // 비어 있으면
				empty++; // 빈칸 증가
				continue;
			}
			// 비어 있지 않을때
			for (int a : list[num]) {
				if (a == map[drow][dcol]) {
					like++;
					break;
				}
			}
		}

		return new Pair(like, empty);
	}

	static class Pair {
		int like;
		int empty;

		public Pair(int like, int empty) {
			this.like = like;
			this.empty = empty;
		}
	}

}
