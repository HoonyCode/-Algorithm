import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1759 {
	static int L;
	static int C;
	static char[] map;
	static char[] answer;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		L = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		//최소 한개의 모음 최소 두개의 자음
		//순서를 가짐
		map = new char[C];
		answer = new char[L];
		
		input = br.readLine().split(" ");
		for(int i = 0 ; i < C ; i++) {
			map[i] = input[i].charAt(0);
		}
		Arrays.sort(map);
		
		dfs(0, 0, 0, 0);
		
		
	}
	
	
	static void dfs(int cnt,int start, int mcnt, int jcnt) {
		
		if(cnt == L) {
			if(mcnt >= 1 && jcnt >= 2) {
				System.out.println(answer);
			}
			return;
		}
		
		for(int i = start; i < C ; i++) {
			answer[cnt] = map[i];
			if(map[i] == 'a' || map[i] == 'e' || map[i] == 'i' || map[i] == 'o' || map[i] == 'u') {
				dfs(cnt+1, i+1, mcnt+1, jcnt);
			}else {
				dfs(cnt+1, i+1, mcnt, jcnt+1);
			}
		}
	}
}
