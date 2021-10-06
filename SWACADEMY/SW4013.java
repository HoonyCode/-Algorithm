import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SW4013 {

    static int magnet[][] = new int[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int K = Integer.parseInt(br.readLine()); // K 회전 횟수

            String[] input;
            for (int i = 0; i < 4; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < 8; j++) {
                    magnet[i][j] = Integer.parseInt(input[j]);
                }
            }

            for (int i = 0; i < K; i++) {
                input = br.readLine().split(" ");
                int magnetN = Integer.parseInt(input[0]) - 1;
                int R = Integer.parseInt(input[1]);
                bfs(new Pair(magnetN, R));
            }

            int res = magnet[0][0] + magnet[1][0] * 2 + magnet[2][0] * 4 + magnet[3][0] * 8;

            sb.append('#').append(t).append(' ').append(res).append('\n');
        }

        System.out.println(sb.toString());
    }

    static int[] dc = {-1,1};

    static void bfs(Pair pair) {
        boolean[] check = new boolean[4]; // 자석의 개수
        ArrayList<Pair> list = new ArrayList<>();
        Queue<Pair> que = new LinkedList<>();
        que.offer(pair);
        list.add(pair);
        check[pair.magNum] = true;

        Pair cur;
        int next;
        while (!que.isEmpty()) {
            cur = que.poll();

            for (int d = 0 ; d < 2; d++){
                next = cur.magNum + dc[d];

                if (next < 0 || next >= 4) continue;
                if (check[next]) continue;

                if (d == 0){ // <- 왼쪽
                    if (magnet[cur.magNum][6] != magnet[next][2]){ //같지 않으면 돌수 있음
                        check[next] = true;
                        que.offer(new Pair(next, -cur.rot));
                        list.add(new Pair(next, -cur.rot));
                    }
                }else{
                    if (magnet[cur.magNum][2] != magnet[next][6]){
                        check[next] = true;
                        que.offer(new Pair(next, -cur.rot));
                        list.add(new Pair(next, -cur.rot));
                    }
                }
            }
        }

        for (Pair temp : list) {
            rotate(temp.magNum, temp.rot);
        }
    }

    static void rotate(int magnetN, int R) {
        if (R == 1) { // 시계 방향
            int temp = magnet[magnetN][7];
            for (int i = 7; i > 0; i--) {
                magnet[magnetN][i] = magnet[magnetN][i - 1];
            }
            magnet[magnetN][0] = temp;
        } else { // -1 일떄 반시계
            int temp = magnet[magnetN][0];
            for (int i = 0; i < 7; i++) {
                magnet[magnetN][i] = magnet[magnetN][i + 1];
            }
            magnet[magnetN][7] = temp;
        }
    }

    static class Pair {
        int magNum;
        int rot;

        public Pair(int magNum, int rot) {
            this.magNum = magNum;
            this.rot = rot;
        }
    }
}