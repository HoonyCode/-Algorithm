import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15683 {
	static int R,C;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		map = new int[R][C];
		
		for(int i = 0 ; i < R ;i ++) {
			input = br.readLine().split(" ");
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		//6은 벽 cctv 는 cctv 통과 가능
		//사각지대 최소 크기를 출력
		//CCTV 최대 개수 8개
		
		
	}
}
