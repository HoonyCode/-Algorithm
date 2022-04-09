import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2667 {

	static int N;
	static int[][] map;
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static ArrayList<Integer> list = new ArrayList<>();
 	
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = input[j] - '0';
			}
		}
		
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] == 1) {
					bsf(i, j);
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(Integer l : list) {
			System.out.println(l);
		}
	}
	
	
	static void bsf(int row, int col) {
		int cnt = 1;
		Queue<Pair> que = new LinkedList<>();
		
		que.offer(new Pair(row, col));
		map[row][col] = 0;
		
		while(que.size() != 0) {
			Pair temp = que.poll();
			
			for(int i = 0 ; i < 4;  i++) {
				int dr = temp.row + dx[i];
				int dc = temp.col + dy[i];
				
				if(dr < 0 || dr >= N || dc < 0 || dc >= N || map[dr][dc] == 0) continue;
				
				que.offer(new Pair(dr, dc));
				map[dr][dc] = 0;
				cnt++;
			}
			
		}
		
		list.add(cnt);
		
	}

}

class Pair {
	int row;
	int col;
	
	public Pair(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
