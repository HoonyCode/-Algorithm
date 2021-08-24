import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3985 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		boolean[] map = new boolean[L+1];
		
		int Max = Integer.MIN_VALUE;
		int maxIndex = 0;
		int countMax = Integer.MIN_VALUE;
		int cntIndex = 0;
		
		
		for(int i = 1 ; i <= N ; i++) {
			String[] input = br.readLine().split(" ");
			int p = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);
			int cnt = 0;
			
			
			if(Max < k-p) {
				Max = k-p;
				maxIndex = i;
			}
			
			for(int j = p ; j <= k ; j++) {
				if(map[j] == false) {
					cnt ++;
					map[j] = true;
				}
			}
			
			if(countMax < cnt) {
				countMax = cnt;
				cntIndex = i;
			}
			
		}
		
		System.out.println(maxIndex +"\n"+cntIndex);
		
	}
}
