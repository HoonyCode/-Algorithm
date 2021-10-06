import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ17143 {

    static int R, C, M;
    static int res; //잡은 상어의 크기를 담는 변수
    static Data[][] map;
    static Data[][] changeMap;

    //d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽을 의미한다.
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]); //향의 크기
        C = Integer.parseInt(input[1]); //열의 크기
        M = Integer.parseInt(input[2]); //상어의 수

        map = new Data[R+1][C+1];
        changeMap = new Data[R+1][C+1];

        for (int i = 1; i <= R; i++) { //맵 초기화
            for (int j = 1; j <= C; j++) {
                map[i][j] = new Data();
            }
        }

        for (int i = 0; i < M; i++) { // 상어를 받아드림
            input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            int s = Integer.parseInt(input[2]);
            int d = Integer.parseInt(input[3]);
            int z = Integer.parseInt(input[4]);
            if (d == 1 || d == 2) {
                s = s % (2 * (R - 1));
            } else {
                s = s % (2 * (C - 1));
            }
            map[r][c].avail = true;
            map[r][c].z = z;
            map[r][c].d = d;
            map[r][c].s = s;
        }


        // 상어를 잡는다 -> 상어가 움직인다 -> 사람이 움직인다.
        int place = 1; //사람의 위치

        while (place <= C) { //사람의 위치가 행보다 작을때만 실행한다.
            fishing(place); // 물고기를 잡는다
            move(); //물고기가 움직인다
            place++; //사람이 한칸 움직인다
        }

        //출력은 낚시왕이 잡은 상어 크기의 합을 출력한다.
        System.out.println(res);
    }

    static void move() { //상어가 움직이는 메서드
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                changeMap[i][j] = new Data();
            }
        }

        int row;
        int col;
        Data nowShark;

        for (int i = 1 ; i <= R ; i++){
            for (int j = 1 ; j <= C ; j++){
               if (!map[i][j].avail) continue;

                //상어가 존재할때 상어가 움직이고 결과를 받아드림
                nowShark = map[i][j];
                row = i;
                col = j;
                for (int s = 0; s < nowShark.s; s++) {
                    row += dr[nowShark.d];
                    col += dc[nowShark.d];

                    if (row <= 0 || col <= 0 || row > R || col > C) {
                        row -= 2 * dr[nowShark.d];
                        col -= 2 * dc[nowShark.d];
                        if (nowShark.d == 1) nowShark.d = 2;
                        else if (nowShark.d == 2) nowShark.d = 1;
                        else if (nowShark.d == 3) nowShark.d = 4;
                        else if (nowShark.d == 4) nowShark.d = 3;
                    }
                }


                //changeMap에 넣기
                if (changeMap[row][col].avail) { //상어가 존재하면
                    if (changeMap[row][col].z < nowShark.z) { //현재 샤크가 맵에 있는것 보다 크면
                        changeMap[row][col] = nowShark; // 넣는다
                    }
                } else { // 없으면 그냥 넣는다
                    changeMap[row][col] = nowShark;
                }
            }
        }


        for (int i = 1; i <= R; i++) {
            System.arraycopy(changeMap[i], 1, map[i], 1, C);
        }

    }

    static void fishing(int col) { //물고기를 잡는 메서드

        for (int i = 1; i <= R; i++) { //가장 땅과 가까움 물고기를 겟 한다
            if (map[i][col].avail) {
                map[i][col].avail = false; //상어가 없다라고 만들어줌
                res += map[i][col].z; // 물고기의 크기를 출력값에 더한다.
                break;
            }
        }
    }


    static class Data {
        int s; // 상어의 속력
        int d; // 상어의 방향
        int z; // 상어의 크기
        boolean avail; // 상어의 존재여부

        public Data() {
            avail = false;
        }

        public Data(int s, int d, int z) {
            this.s = s;
            this.d = d;
            this.z = z;
            this.avail = true;
        }
    }
}
