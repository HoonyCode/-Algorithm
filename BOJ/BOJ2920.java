import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2920 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int cnt1 = 0;
		int cnt2 = 0;
		
		for(int i = 1 ; i < 9; i++) {
			if(Integer.parseInt(input[i-1]) == i) {
				cnt1 ++;
			}else if(Integer.parseInt(input[i-1]) == 9-i) {
				cnt2 ++;
			}
		}
		if(cnt1 == 8) {
			System.out.println("ascending");
		}else if(cnt2 == 8){
			System.out.println("descending");
		}else {
			System.out.println("mixed");
		}
	}
}
