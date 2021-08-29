import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOK2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		//합이 21을 넘지 않는 한도 내에서 카드 합을 최대한 크기로 만드는 게임
		
		//3장을 골라 가장 가까이 만드는 것
		int[] arr = new int[N];
		input = br.readLine().split(" ");
		for(int i = 0 ; i< N ; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(arr);
		
		
		int answer = -300_000;
		
		for(int i = 0 ; i < N-2 ; i++) {
			for(int j = i+1 ; j < N -1 ; j++) {
				for(int k = j+1 ; k < N ; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					if(M-sum >= 0 && sum <= M && sum > answer) {
						answer = sum;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
