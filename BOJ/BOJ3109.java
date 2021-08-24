import java.util.Scanner;

public class BOJ3109 {
	
	private static int[] dr = {-1,0,1};     // 위 대각선, 오른쪽, 아래 대각선 순서로 탐색해야 파이프 개수 최대
	private static int[] dc = {1,1,1};    
	private static int R;
	private static int C;
	private static char[][] map;
	private static boolean[][] isVisited;  // dfs 탐색 내에서 방문 체크용 배열
	private static boolean isConnected;    // 파이프 생성여부 확인
	private static int cnt;                // 파이프 개수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();     // 행의 수
		C = sc.nextInt();     // 열의 수
		
		map = new char[R][C];   
		for(int i=0; i<R; i++) {            // 지도 입력 받기
			String str = sc.next();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		isVisited = new boolean[R][C];
		isConnected = false;     // 초기화  (왜 안되지?)
		cnt = 0;
		
		// 각 행의 첫 번째 열에서 출발해야 함 => 출발하는 열의 위치 0으로 고정	(이 부분 어떻게 하는 지 몰라서 구글링함)
		for(int i=0; i< R; i++) {
			isConnected = false;     // 초기화
			dfs(i,0);
			
			if(isConnected == true)
				cnt++;               // 파이프 개수 증가
		}

		System.out.println(cnt);    // 파이프 개수 출력
		sc.close();
		
	}
	
	private static void dfs(int r, int c) {     
		
		
		if(isConnected == true) {           // 마지막 열에서 이미 파이프가 연결 된 곳은 다시 생성x (도착지가 여러 곳이므로 반드시 체크!)
			return;
		}
		
		if(c == C-1) {                      // 빵집에 도착하면(마지막 열) 종료   
			isConnected = true;             // 마지막 열에서 파이프가 연결된 곳이라고 표시
			return; 
		}		
		
		isVisited[r][c] = true;             // 방문했다고 표시

		for(int d=0; d<3; d++) {            // 위 대각선, 오른쪽, 아래 대각선 순서로 탐색
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 범위 벗어나는 경우
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) {
				continue;
			}
			
			// 방문한 곳은 다시 방문x
			if(isVisited[nr][nc]) {
				continue;
			}
			
			// 'x' 인곳은 방문x
			if(map[nr][nc] == 'x') {
				continue;
			}		
			
			dfs(nr, nc);
				
			}
		}

	}
