import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW6485 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N];
			int[] B = new int[N];

			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				A[i] = Integer.parseInt(input[0]);
				B[i] = Integer.parseInt(input[1]);
			}
			int P = Integer.parseInt(br.readLine());
			int[] C = new int[P];
			for(int i = 0 ; i < P; i++) {
				C[i] = Integer.parseInt(br.readLine());
			}
			
			int[] arr = new int[P];
			
			for(int i = 0 ; i < N ; i++) { // 범의 A B 쓸꺼임
				for(int j = 0 ; j < P ; j++) {
					if(C[j] >= A[i] && C[j] <= B[i]) {
						arr[j]++;
						continue;
					}
				}
			}

			sb.append("#" + t + " ");
			for(int j = 0 ; j < P ; j++) {
				sb.append(arr[j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
