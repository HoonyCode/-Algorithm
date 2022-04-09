import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2292 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		//1 - > 7 -> 19 -> 37 -> 61
		// 6 12 18 24 증가량
		int start = 1;
		int plusNum = 6;
		int cnt = 1;
		while(true) {
			if(num <= start) {
				System.out.println(cnt);
				break;
			}
			cnt++;
			start = start += plusNum*(cnt-1);
		}
	}
}
