import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ15693 {
	
	static int N, M;
	static int[][] map;
	static int Min = Integer.MAX_VALUE;
	static int[][] map2;
	static int[] direction;
	
	static int[] dir = {0, 4, 2, 4, 4, 0};
	static ArrayList<Cctv> arr = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		map = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			input = br.readLine().split(" ");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if(map[i][j] > 0 && map[i][j] < 6) {
					arr.add(new Cctv(i, j, map[i][j], dir[map[i][j]]));
				}
			}
		}
		
		for(int i = arr.size()-1 ; i > -1; i--) {
			Cctv temp = arr.get(i);
			
			if(temp.value == 5) {
				Right(temp.row, temp.col, map);
				Left(temp.row, temp.col, map);
				Up(temp.row, temp.col, map);
				Down(temp.row, temp.col, map);
				
				arr.remove(i);// 배열에서 삭제
			}
		}
	
		map2 = new int[N][M];
		copyMap();
		direction = new int[arr.size()];
		dfs(0);
		
		
		System.out.println(Min);
		
	}
	
	static void dfs(int cnt) {
		
		if(cnt == arr.size()) {
			for(int i = 0 ; i < arr.size(); i++) {
				Serach(arr.get(i), direction[i]);
			}
			checkMap();
			copyMap(); //map2에 map을 copy함
			return;
		}
		
		for(int i = 1 ; i <= arr.get(cnt).dir; i++) {
			//배열에 넣기
			direction[cnt] = i;
			dfs(cnt+1);
		}
	}
	
	static void Serach(Cctv cctv, int dir) {
		
		if(cctv.value == 1) { //1번 cctv
			switch (dir) {
			case 1:
				Right(cctv.row, cctv.col, map2);
				break;
			case 2:
				Left(cctv.row, cctv.col, map2);
				break;
			case 3:
				Up(cctv.row, cctv.col, map2);
				break;
			case 4:
				Down(cctv.row, cctv.col, map2);
				break;
			}
		}else if(cctv.value == 2) {
			switch (dir) {
			case 1:
				Right(cctv.row, cctv.col, map2);
				Left(cctv.row, cctv.col, map2);
				break;
			case 2:
				Up(cctv.row, cctv.col, map2);
				Down(cctv.row, cctv.col, map2);
				break;
			}
		}else if(cctv.value == 3) {
			switch (dir) {
			case 1:
				Up(cctv.row, cctv.col, map2);
				Right(cctv.row, cctv.col, map2);
				break;
			case 2:
				Right(cctv.row, cctv.col, map2);
				Down(cctv.row, cctv.col, map2);
				break;
			case 3:
				Down(cctv.row, cctv.col, map2);
				Left(cctv.row, cctv.col, map2);
				break;
			case 4:
				Left(cctv.row, cctv.col, map2);
				Up(cctv.row, cctv.col, map2);
				break;
			}
		}else if(cctv.value == 4) {
			switch (dir) {
			case 1:
				Up(cctv.row, cctv.col, map2);
				Right(cctv.row, cctv.col, map2);
				Down(cctv.row, cctv.col, map2);
				break;
			case 2:
				Right(cctv.row, cctv.col, map2);
				Down(cctv.row, cctv.col, map2);
				Left(cctv.row, cctv.col, map2);
				break;
			case 3:
				Down(cctv.row, cctv.col, map2);
				Left(cctv.row, cctv.col, map2);
				Up(cctv.row, cctv.col, map2);
				break;
			case 4:
				Left(cctv.row, cctv.col, map2);
				Up(cctv.row, cctv.col, map2);
				Right(cctv.row, cctv.col, map2);
				break;
			}
		}
		
		
	}
	
	
	//오른쪽 탐색
	static void Right(int row, int col, int[][] m) {
		for(int i = col+1; i < M; i++) {
			if(m[row][i] == 6) break;
			if(m[row][i] > 0) continue;
			m[row][i] = -1;
		}
	}
	
	//왼쪽 탐색
	static void Left(int row, int col, int[][] m) {
		for(int i = col-1; i > -1; i--) {
			if(m[row][i] == 6) break;
			if(m[row][i] > 0) continue;
			m[row][i] = -1;
		}
	}
	
	//위 탐색
	static void Up(int row, int col, int[][] m) {
		for(int i = row-1; i > -1; i--) {
			if(m[i][col] == 6 ) break;
			if(m[i][col] > 0) continue;
			m[i][col] = -1;
		}
	}
	
	//아래 탐색
	static void Down(int row, int col, int[][] m) {
		for(int i = row+1; i < N; i++) {
			if(m[i][col] == 6 ) break;
			if(m[i][col] > 0) continue;
			m[i][col] = -1;
		}
	}
	
	static void checkMap() {
		int cnt = 0;
		
		for(int i = 0 ; i < N; i++ ) {
			for(int j = 0 ; j < M ; j++) {
				if(map2[i][j] == 0) cnt++;
				if(cnt >= Min) return;
			}
		}
		Min = cnt;
		return;
	}
	
	static void copyMap() {
		for(int i = 0; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				map2[i][j] = map[i][j];
			}
		}
	}
}

class Cctv{
	
	int row; 
	int col;
	int value;
	int dir = 0;
	
	public Cctv(int row, int col, int value, int dir) {
		this.row = row;
		this.col = col;
		this.value = value;
		this.dir = dir;
	}

	@Override
	public String toString() {
		return "Cctv [row=" + row + ", col=" + col + ", value=" + value + ", dir=" + dir + "]";
	}
	
}
