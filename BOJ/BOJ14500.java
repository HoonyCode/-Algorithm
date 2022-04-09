import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14500 {


    /**
     * 테트로미노
     * 골드 5
     * 삼성 역량 테스트 문제
     */

    static int R, C; //세로 가로
    static int[][] map;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        bar();
        bar234();
        bar5();


        System.out.println(max);

    }

    static void bar234() { // ㄱ자 ㄹ자 ㅗ자
        // 가로 일때
        int total;
        int res;
        for (int i = 0; i < R - 1; i++) {
            total = 0;
            for (int j = 0; j < 3; j++) {
                total += map[i][j] + map[i + 1][j];
            }


            for (int j = 0; j < C - 2; j++) {
                if(j != 0){
                    total = total - map[i][j-1] - map[i + 1][j-1] + map[i][j + 2] + map[i + 1][j + 2];
                }
                if (total <= max) continue;

                // ㄱ자
                res = total - map[i][j] - map[i][j + 1];
                max = Math.max(res, max);
                res = total - map[i][j + 1] - map[i][j + 2];
                max = Math.max(res, max);
                res = total - map[i + 1][j] - map[i + 1][j + 1];
                max = Math.max(res, max);
                res = total - map[i + 1][j + 1] - map[i + 1][j + 2];
                max = Math.max(res, max);

                //ㄹ 자
                res = total - map[i][j] - map[i + 1][j + 2];
                max = Math.max(res, max);
                res = total - map[i + 1][j] - map[i][j + 2];
                max = Math.max(res, max);

                //ㅗ 자
                res = total - map[i][j] - map[i][j + 2];
                max = Math.max(res, max);
                res = total - map[i + 1][j] - map[i + 1][j + 2];
                max = Math.max(res, max);
            }
        }


        // 세로 일때
        for (int j = 0; j < C - 1; j++) {
            total = 0;
            for (int i = 0; i < 3; i++) {
                total += map[i][j] + map[i][j + 1];
            }

            for (int i = 0; i < R - 2; i++) {
                if(i != 0)
                    total = total - map[i-1][j] - map[i-1][j + 1] + map[i + 2][j] + map[i + 2][j + 1];
                if (total <= max) continue;

                // ㄱ자
                res = total - map[i][j] - map[i + 1][j];
                max = Math.max(res, max);
                res = total - map[i + 1][j] - map[i + 2][j];
                max = Math.max(res, max);
                res = total - map[i][j + 1] - map[i + 1][j + 1];
                max = Math.max(res, max);
                res = total - map[i + 1][j + 1] - map[i + 2][j + 1];
                max = Math.max(res, max);

                //ㄹ 자
                res = total - map[i][j] - map[i + 2][j + 1];
                max = Math.max(res, max);
                res = total - map[i][j + 1] - map[i + 2][j];
                max = Math.max(res, max);

                //ㅗ 자
                res = total - map[i][j] - map[i + 2][j];
                max = Math.max(res, max);
                res = total - map[i][j + 1] - map[i + 2][j + 1];
                max = Math.max(res, max);
            }
        }


    }

    static void bar5() { // ㅁ자 bar
        int total;
        for (int i = 0; i < R - 1; i++) {
            total = 0;
            //초기 - 사각형
            for (int j = 0; j < 2; j++) {
                total += map[i][j] + map[i + 1][j];
            }

            max = Math.max(max, total);
            for (int j = 0; j < C - 3; j++) {
                total = total - map[i][j] - map[i + 1][j] + map[i][j + 2] + map[i + 1][j + 2];
                if (max < total) max = total;
            }
        }
    }


    static void bar() { //일자 바


        int total = 0;

        for (int i = 0; i < R; i++) {
            total = 0;
            for (int j = 0; j < 4; j++) {
                total += map[i][j];
            }
            max = Math.max(max, total);

            for (int j = 0; j < C - 5; j++) {
                total = total - map[i][j] + map[i][j + 4];
                if (max < total) max = total;
            }
        }

        for (int i = 0; i < C; i++) {
            total = 0;
            for (int j = 0; j < 4; j++) {
                total += map[j][i];
            }
            max = Math.max(max, total);

            for (int j = 0; j < R - 5; j++) {
                total = total - map[j][i] + map[j + 4][i];
                if (max < total) max = total;
            }
        }

    }


}
