package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_게리맨더링2_HoonyCode {

    static boolean[] v;
    static int[][] map;
    static int N;


    public static void main(String[] args) throws Exception{
        init(); // 초기화 함수

    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0 ; i < N ; i++){
            String[] in = br.readLine().split(" ");
            for (int j = 0 ; j <N ; j++){
                map[i][j] = Integer.parseInt(in[j]);
            }
        }
    }
}
