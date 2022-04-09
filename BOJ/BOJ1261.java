import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1261 {
    static int col, row; // 가로 세로
    static int[][] map;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static boolean finish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        col = Integer.parseInt(input[0]);
        row = Integer.parseInt(input[1]);

        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < col; j++) {
                map[i][j] = -Integer.parseInt(input[j]); //벽은 -1로 된다.
            }
        }


        int res = 0;
        while (true){
            bfs();
            if(finish)
                break;
            blockBreak();
            res++;
        }

        System.out.println(res);

    }

    static void bfs(){
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(0,0));
        map[0][0] = 1;

        while (!que.isEmpty()){
            Pair temp = que.poll();
            if(temp.row == row-1 && temp.col == col-1)
                finish = true;

            for(int d = 0 ; d < 4 ; d++){
                int drow = temp.row + dr[d];
                int dcol = temp.col + dc[d];

                if(drow < 0 || drow >= row || dcol < 0 || dcol >= col) continue;
                if(map[drow][dcol] != 0 ) continue;

                que.offer(new Pair(drow,dcol));
                map[drow][dcol] = 1;
            }
        }
    }

    static void blockBreak(){
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if(map[i][j] == 1){
                    for (int d = 0 ; d < 4 ; d++){
                        int drow = i + dr[d];
                        int dcol = j + dc[d];

                        if(drow < 0 || drow >= row || dcol < 0 || dcol >= col) continue;
                        if(map[drow][dcol] == -1 ){
                            map[drow][dcol] = 0;
                        }
                    }
                    map[i][j] = 0;
                }
            }
        }
    }

    static class Pair{
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
