import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11559 {

    static char[][] map = new char[12][6];
    static HashSet<Integer> hashSet = new HashSet<>(); //부서진 열의 값을 가지고 있음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray(); //map 에다가 넣음
        }

        int res = 0;
        while (true){
            BlockBreak(); // 벽 부스기
            if (hashSet.size() == 0) // 벽 부서지 열이 없다면 종료
                break;

            blockDown(); // 벽 내리기
            hashSet.clear();
            res++; // 카운트 증가
        }

        System.out.println(res);
    }

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static void BlockBreak() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] != '.')
                    bfs(i, j);
            }
        }
    }

    static void blockDown(){ //벽 내리기
        for (int col : hashSet){
            String input = "";
            for (int i = 11 ; i > -1 ; i--){
                if (map[i][col] != '.') { //부서진 열에서 문자가 있으면 input에 넣어고 '.'로 만듬
                    input += map[i][col];
                    map[i][col] = '.';
                }
            }
            if (input.length() == 0) continue;
            for (int i = 0; i < input.length(); i++){ //밑에서부터 문자를 채워줌
                map[11-i][col] = input.charAt(i);
            }
        }
    }

    static void bfs(int row, int col) {
        Queue<int[]> que = new LinkedList<>();
        ArrayList<int[]> list = new ArrayList<>();

        boolean[][] v = new boolean[12][6];
        v[row][col] = true;
        que.offer(new int[]{row, col});

        int drow;
        int dcol;
        int[] cur;
        while (!que.isEmpty()) {
            cur = que.poll();
            list.add(cur);

            for (int d = 0; d < 4; d++) {
                drow = dr[d] + cur[0];
                dcol = dc[d] + cur[1];

                if (drow < 0 || drow >= 12 || dcol < 0 || dcol >= 6 || v[drow][dcol]) continue;
                if (map[drow][dcol] != map[cur[0]][cur[1]]) continue;
                v[drow][dcol] = true;
                que.offer(new int[]{drow, dcol});
            }
        }

        if (list.size() < 4) { //인접한 벽 개수가 4개가 아닐 때 종료
            return;
        }

        for (int[] temp : list) { // 인접한 벽 개수가 4개 이상일 때 벽을 부시기.
            map[temp[0]][temp[1]] = '.';
            hashSet.add(temp[1]);
        }
        return;
    }
}
