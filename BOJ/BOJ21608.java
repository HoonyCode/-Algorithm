import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ21608 {
	static int N, student;
	static int[][] map;
	static ArrayList<Integer>[] lists;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		
		
		student = N*N;
		
		lists = new ArrayList[student + 1];
		for(int i = 1; i <= student; i++) {
			lists[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < student;  i++) {
			String[] input = br.readLine().split(" ");
			for(int j = 1; j < 5;  i++) {
				lists[i].add(Integer.parseInt(input[j]));
			}
		}
		
		
		
	}
	
	
}
