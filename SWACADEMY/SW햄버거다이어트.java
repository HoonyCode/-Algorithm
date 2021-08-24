package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW햄버거다이어트 {
	
	static int max ;
	static int maxCal ; //최대 칼로리
	static int countMax ; //탐색할 요리수
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 받아옴
		for(int t = 1; t <= T ; t++) {

			String[] input = br.readLine().split(" ");
			countMax = Integer.parseInt(input[0]); // 재료의 수 
			maxCal = Integer.parseInt(input[1]); //칼로리 제한
			
			Cook[] cook = new Cook[countMax];
			
			for(int i = 0 ; i < countMax ; i++) {
				input = br.readLine().split(" ");
				cook[i] = new Cook(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			}
			max = 0; // max = 초기화
			makeH(0, 0, 0, cook);
			
			sb.append("#" + t + " " +max + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void makeH(int count,int nowcalrori,int nowhappy, Cook[] cook) { //재귀로 탐색
		
		if (nowcalrori <= maxCal && max < nowhappy) {
			max = nowhappy;
		}
		
		if(count == countMax) {
			return ;
		}
		int cal = nowcalrori + cook[count].L;
		int happy = nowhappy + cook[count].happy;
		
		count++;
		//아무것도 넣지 않을때 
		makeH(count, nowcalrori, nowhappy, cook);
		
		//넣을때
		if(nowcalrori > maxCal) 
			return;
		makeH(count, cal, happy, cook);
		
	}
	static class Cook{
		int happy;
		int L;
		
		public Cook(int happy, int L) {
			this.happy = happy;
			this.L = L;
		}
	}
}
