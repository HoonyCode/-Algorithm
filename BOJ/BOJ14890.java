import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14890 {
	
	static int N, L;
	static int[][] map;
	static int res;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		L = Integer.parseInt(input[1]);
		map = new int[N][N];
		
		for(int i = 0; i < N ; i++) {
			input = br.readLine().split(" ");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for(int i = 0; i < N ; i++) {
			check1(i);
			check2(i);
		}
		
		System.out.println(res);
		
	}
	
	//가로 체크
	static void check1(int row){
		
		int preblock; // 이전블록
		int nowblock;
		boolean[] v = new boolean[N];
		for(int i = 1; i < N ; i++) {
			preblock = map[row][i-1];
			nowblock = map[row][i];
			if(preblock == nowblock) continue;
			if(Math.abs(preblock-nowblock) > 1) return;
			
			if(preblock < nowblock) { // 현재 블록이 클떄
				if(i - L < 0 || v[i - L]) return; // 끝냄
				for(int j = i - L; j < i ; j++) {
					v[j] = true;
				}
			}else { // 작을때 
				if(i+L-1 >= N) return;
				int j;
				for(j = i ; j < i+L ; j++) {
					if(nowblock != map[row][j]) return; // 같지 않으면 리턴
					v[j] = true;
				}
				i = j-1;
			}
		}
		
		
		res++;
	
	}
	
	
	//세로 체크
	static void check2(int col){
		int preblock; // 이전블록
		int nowblock;
		boolean[] v = new boolean[N];
		for(int i = 1; i < N ; i++) {
			preblock = map[i-1][col];
			nowblock = map[i][col];
			if(preblock == nowblock ) continue;
			if(Math.abs(preblock-nowblock) > 1) return;
			if(preblock < nowblock) { // 현재 블록이 클떄
				if(i - L < 0 || v[i - L]) return; // 끝냄
				for(int j = i - L; j < i ; j++) {
					v[j] = true;
				}
			}else { // 작을때 
				if(i+L-1 >= N) return;
				int j;
				for(j = i ; j < i+L ; j++) {
					if(nowblock != map[j][col]) return; // 같지 않으면 리턴
					v[j] = true;
				}
				i = j-1;
			}
		}
	
		
		res++;
	}
}
