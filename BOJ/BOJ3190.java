import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ3190 {
	
	static int N, K;
	// 행 열
	static ArrayList<int[]> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K ; i++) {
			String[] input = br.readLine().split(" ");
			list.add(new int[] {Integer.parseInt(input[0]), Integer.parseInt(input[1])});
		}
		
		
			
	}
}
