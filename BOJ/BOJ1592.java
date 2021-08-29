

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1592 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int L = Integer.parseInt(input[2]);
		
		//한사람이 M 번 받으면 게임 끝
		//M번보다 적게 받은 사람이 공을 던질 때, 현재 공을 받은 횟수가 홀수번이면 -> 오른쪽으로
		//짝수 방향이면 왼쪽으로  던진다.
		//총 공 던지는 수 
		
		int[] map = new int[N+1];
		//L번 째 던지는거
		//한 사람이 M번 받으면 끝
		//1번 부터 시작
		map[1]++;
		int index = 1;
		int result = 0;
		while(true) {
			//홀수일때 ->
			if((map[index] & 1) == 1) {
				index = index + L;
				if(index > N) index = index%(N+1) + 1;
				map[index]++; // 던져서 받게됨.
				result++;
			}else {
				index = index - L;
				if(index < 1) index = N + index;
				map[index]++;
				result++;
			}
			
			if(map[index] == M){
				System.out.println(result);
				break;
			}
		}
		
	}
}
