import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2851 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 100에 가장 가깝 만들려고 함.
		// 중간에 나오는 버섯 생각해야함.
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());
			if (Math.abs(100 - sum) >= Math.abs(100 - sum - num) && cnt == 0) {
				sum = sum + num;
				continue;
			}
			cnt++;
		}
		System.out.println(sum);
	}
}
