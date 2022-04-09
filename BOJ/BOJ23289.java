import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ23289 {

    static int R, C, K, W;
    static int[][] map;

    static List<Pair> checkLists = new ArrayList<>();

    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};
    static int[] d = {1, 0, -1};


    static int answer = 0; // 초콜릿

    /**
     * 집에 있는 모든 온풍기에서 바람이 한 번 나옴
     * 온도가 조절됨
     * 온도가 1 이상인 가장 바깥쪽 칸의 온도가 1씩 감소
     * 초콜릿을 하나 먹는다.
     * 조사하는 모든 칸의 온도가 K 이상이 되었는지 검사.
     * 모든 칸의 온도가 K이상이면 테스트를 중단하고, 아니면 1부터 다시 시작한다.
     */

    public static void main(String[] args) throws IOException {

        input(); // 입출력을 받음


    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");

        R = Integer.parseInt(in[0]);
        C = Integer.parseInt(in[1]);
        K = Integer.parseInt(in[2]);

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                if (Integer.parseInt(in[j]) == 5){
                    checkLists.add(new Pair(i, j));
                    continue;
                }
                map[i][j] = Integer.parseInt(in[j]);
            }
        }
    }

    static class Pair{
        int row, col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
