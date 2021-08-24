import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SW무선충전 {
	
	static final int[] dr = {0,-1,0,1,0}; // 0 상 우 하 좌
	static final int[] dc = {0,0,1,0,-1}; // 0 상 우 하 좌
	
	static int[][] map = new int[10][10];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T ; t++) {
			String[] input = br.readLine().split(" ");
			int M = Integer.parseInt(input[0]); //이동시간
			int BC = Integer.parseInt(input[1]); //개수
			
			int[] A = new int[M];
			int[] B = new int[M];
			String[] input1 = br.readLine().split(" ");
			String[] input2 = br.readLine().split(" ");
			for(int i = 0 ; i < M; i++) {
				A[i] = Integer.parseInt(input1[i]);
				B[i] = Integer.parseInt(input2[i]);			
			}
			// A -> 0,0 B -> 9,9에서 움짐임.
			
			AP[] ap = new AP[BC];
			
			for(int i = 0 ; i < BC ; i++) { //AP 의 값을 입력 받음.
				input = br.readLine().split(" ");
				ap[i] = new AP(Integer.parseInt(input[0]) -1 , Integer.parseInt(input[1]) -1 , Integer.parseInt(input[2]), Integer.parseInt(input[3]));
			}
			
			int Adr = 0;
			int Adc = 0;
			int Bdr = 9;
			int Bdc = 9;
			int result =0;
			
			
			int max = 0;
			//사람 출발
		loop :for(int i = -1 ; i < M ; i++) { //0초일때 포함
				max = 0;
				
				if(i != -1) {
					Adr += dr[A[i]];
					Adc += dc[A[i]];
					Bdr += dr[B[i]];
					Bdc += dc[B[i]];
				}
				
				ArrayList<AP> aap = new ArrayList<>(); //a한테 접근 가능한 ap
				ArrayList<AP> bap = new ArrayList<>(); //b한테 접근 가능한 ap
				
				for(int j = 0 ; j < BC ; j++) {
					int alength = Math.abs(Adr - ap[j].row) + Math.abs(Adc - ap[j].col);
					int blength = Math.abs(Bdr - ap[j].row) + Math.abs(Bdc - ap[j].col);
					
					
					if(alength <= ap[j].range) {
						aap.add(ap[j]);
					}
					if(blength <= ap[j].range) {
						bap.add(ap[j]);
					}
					
				}
				//충전량 내림차순 정렬.
				Collections.sort(aap);
				Collections.sort(bap);
				
				int asize = Math.min(aap.size(), 2);
				int bsize = Math.min(bap.size(), 2);
				
				if(asize == 0 && bsize ==0) {
					continue;
				}else if(asize == 0) {
					result += bap.get(0).charge;
					continue;
				}else if(bsize == 0) {
					result += aap.get(0).charge;
					continue;
				}
				
				//둘다 있는 경우
				for(int k = 0 ; k < asize ; k ++) {
					int charge = 0;
					for(int l = 0; l < bsize; l++) {
						if(aap.get(k).row == bap.get(l).row && aap.get(k).col == bap.get(l).col) {
							charge = aap.get(k).charge;
						}else {
							charge = aap.get(k).charge + bap.get(l).charge;
							max = Math.max(max, charge);
						}
						max = Math.max(max, charge);
					}
				}
				
				result += max;
			}
			
			
			
			sb.append("#" + t + " "+ result + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static class AP implements Comparable<AP>{
		int row;
		int col;
		int range;
		int charge;
		
		public AP(int col, int row, int range, int charge) {
			// TODO Auto-generated constructor stub
			this.row = row;
			this.col = col;
			this.range = range;
			this.charge = charge;
		}

		@Override
		public int compareTo(AP o) {
			// TODO Auto-generated method stub
			return -(this.charge - o.charge);
		}
	}
}
