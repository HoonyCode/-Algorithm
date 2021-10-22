import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ20055 {

	static int N, K;
	static Belt[] belt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);

		belt = new Belt[2 * N];
		input = br.readLine().split(" ");
		for (int i = 0; i < 2 * N; i++) {
			belt[i] = new Belt(Integer.parseInt(input[i]), false);
		}

		int cnt = 0;

		// 1. 로봇을 올리고 함께 회전
		while (true) {

			cnt++;

			// 1. 각 칸위에 잇는 로봇과 함께 한 칸 회전한다.
			rotate();
			if (belt[N - 1].robot) {
				belt[N - 1].robot = false;
			}

			// 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한칸 이동 할 수 있으면 이동한다.
			robotMove();
			if (belt[N - 1].robot) {
				belt[N - 1].robot = false;
			}

			// 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 로봇을 올린다.
			if (belt[0].duty > 0 && !belt[0].robot) {
				belt[0].duty--;
				belt[0].robot = true;
			}


			// 4 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다.
			if(checkduty()) break;
		}

		System.out.print(cnt);

	}

	static boolean checkduty() {
		int cnt = 0;

		for (int i = 0; i < 2 * N; i++) {
			if (belt[i].duty == 0)
				cnt++;
		}

		if (cnt >= K)
			return true;

		return false;

	}

	static void robotMove() {

		for (int i = N - 1; i > 0; i--) {
			if (belt[i].duty < 1 || belt[i].robot || !belt[i - 1].robot)
				continue;
			// 동작이 가능할 때
			belt[i].duty--;
			belt[i].robot = true;
			belt[i - 1].robot = false;
		}

	}

	static void rotate() {

		Belt temp = belt[2 * N - 1];

		for (int i = 2 * N - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
		}
		belt[0] = temp;
	}
	
	

	static class Belt {
		int duty; // 내구도
		boolean robot; // 로봇이 있는지

		public Belt(int duty, boolean robot) {
			this.duty = duty;
			this.robot = robot;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return duty + "";
		}

	}
}
