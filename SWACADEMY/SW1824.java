import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW1824 {
    static int R, C;
    static char[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] input = br.readLine().split(" ");
            R = Integer.parseInt(input[0]);
            C = Integer.parseInt(input[1]);
            map = new char[R][C];

            boolean exit = false;
            for (int i = 0; i < R; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0 ; j <C ; j++){
                    if (map[i][j] == '@')
                        exit = true;
                }
            }
            String res = "NO";
            if (!exit){
                sb.append("#" + t + " " + res + "\n");
                continue;
            }
            if(bfs(0, 0, 0, 0)){
                res = "YES";
            }
            sb.append("#" + t + " " + res + "\n");
        }
        System.out.println(sb.toString());
    }

    //우 하 좌 상
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static boolean bfs(int memory, int dir, int row, int col) {
        boolean[][][][] v = new boolean[16][4][R][C];
        Queue<Data> que = new LinkedList<>();
        que.offer(new Data(memory,dir,row,col));
        v[memory][dir][row][col] = true;

        Data cur;
        while (!que.isEmpty()){
            cur = que.poll();

            char key = map[cur.row][cur.col];
            if (key == '>') {
                cur.dir = 0;
            } else if (key == 'v') {
                cur.dir = 1;
            } else if (key == '<') {
                cur.dir = 2;
            } else if (key == '^') {
                cur.dir = 3;
            } else if (key == '_') {
                if (cur.memory == 0) {
                    cur.dir = 0;
                } else
                    cur.dir = 2;
            } else if (key == '|') {
                if (cur.memory == 0) {
                    cur.dir = 1;
                } else
                    cur.dir = 3;
            } else if (key == '?') {
                for (int d = 0; d < 4; d++) {
                    cur.dir = d;
                    int drow = cur.row + dr[cur.dir];
                    int dcol = cur.col + dc[cur.dir];
                    if (drow == R) drow = 0;
                    if (drow == -1) drow = R-1;
                    if (dcol == C) dcol =0;
                    if (dcol == -1) dcol = C-1;

                    if (v[cur.memory][cur.dir][drow][dcol]) continue;

                    que.offer(new Data(cur.memory, cur.dir, drow, dcol));
                    v[cur.memory][cur.dir][drow][dcol] = true;
                }
                continue;
            } else if (key == '@') {
                return true;
            } else if (key - '0' >= 0 && key - '0' < 10) {
                cur.memory = key - '0';
            } else if (key == '+') {
                cur.memory++;
            } else if (key == '-') {
                cur.memory--;
            }

            cur.row += dr[cur.dir];
            cur.col += dc[cur.dir];
            if(cur.memory == 16) cur.memory = 0;
            if(cur.memory == -1) cur.memory = 15;
            if (cur.row == R) cur.row = 0;
            if (cur.row == -1) cur.row = R-1;
            if (cur.col == C) cur.col =0;
            if (cur.col == -1) cur.col = C-1;

            if (v[cur.memory][cur.dir][cur.row][cur.col]) continue;

            que.offer(new Data(cur.memory, cur.dir, cur.row, cur.col));
            v[cur.memory][cur.dir][cur.row][cur.col] = true;
        }

        return false;
    }

    static class Data{
        int memory;
        int dir;
        int row;
        int col;

        public Data(int memory, int dir, int row, int col) {
            this.memory = memory;
            this.dir = dir;
            this.row = row;
            this.col = col;
        }
    }
}
