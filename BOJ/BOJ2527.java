import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2527 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < 4; t++) {
			// 3 10 50 60 100 100 200 300
			// 중앙값 찾아서 생각하자

			String[] input = br.readLine().split(" ");
			int[] arr = new int[8];
			for (int i = 0; i < 8; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}
			XY A = new XY(arr[0], arr[1], arr[2], arr[3]);
			XY B = new XY(arr[4], arr[5], arr[6], arr[7]);

			if ((A.x4 == B.x1 && A.y4 == B.y1) //한점에서 만날때
					|| (A.x2 == B.x3 && A.y2 == B.y3) 
					|| (A.x3 == B.x2 && A.y3 == B.y2)
					|| (A.x1 == B.x4 && A.y1 == B.y4)) {
				sb.append("c");
			} else if (A.x1 > B.x4 || A.y1 > B.y4  // 만나지 않음
					|| A.x2 < B.x3 || A.y2 > B.y3 
					|| A.x3 > B.x2 || A.y3 < B.y2
					|| A.x4 < B.x1 || A.y4 < B.y1) {
				sb.append("d");
			} else if (A.x1 == B.x4 || A.y1 == B.y4 
					|| A.x2 == B.x3 || A.y2 == B.y3 
					|| A.x3 == B.x2 || A.y3 == B.y2
					|| A.x4 == B.x1 || A.y4 == B.y1) {
				sb.append("b");
			} else {
				sb.append("a");
			}
			sb.append("\n");

		}
		System.out.println(sb.toString());
	}

	static class XY {
		int x1;
		int x2;
		int x3;
		int x4;

		int y1;
		int y2;
		int y3;
		int y4;

		public XY(int x1, int y1, int x4, int y4) {
			super();
			this.x1 = x1;
			this.x2 = x4;
			this.x3 = x1;
			this.x4 = x4;
			this.y1 = y1;
			this.y2 = y1;
			this.y3 = y4;
			this.y4 = y4;
		}

	}
}
