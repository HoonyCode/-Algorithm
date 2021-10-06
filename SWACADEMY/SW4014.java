import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class SW4014 {

    static int N, X;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); //테스트 케이스 갯수

        String[] input;
        for (int tc = 1; tc <= T; tc++) {
            int res = 0; // 결과
            input = br.readLine().trim().split(" ");
            N = Integer.parseInt(input[0]); //지형의 크기
            X = Integer.parseInt(input[1]); //경사로는 길이가 x이고 높이는 1이다

            map = new int[N][N]; // N * N 크기의 맵 생성

            for (int i = 0; i < N; i++) { //맵 넣기
                input = br.readLine().trim().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            res += colCheck();
            res += rowCheck();

            sb.append("#" + tc + " " + res + "\n");
        }
        System.out.print(sb.toString());
    }

    static int rowCheck(){
        int total = 0;

        int curHigh; // 현재 높이
        int preHigh; // 이전 높이

        loop : for (int i = 0; i < N ; i++){
            boolean[] v = new boolean[N];
            for (int j = 1 ; j < N; j++){
                curHigh = map[j][i]; // 현재 높이
                preHigh = map[j-1][i]; //이전 높이
                if (preHigh == curHigh) continue; // 그냥 넘어감
                if (Math.abs(preHigh-curHigh) > 1) continue loop; //만들지 못함

                if (curHigh > preHigh){
                    if (j - X < 0) continue loop; //범위 밖으로 나가는 경우
                    if (Math.abs(map[j-X][i] - curHigh) > 1) continue loop;
                    if (v[j-X]) continue loop;
                }else{ //현재 높이가 preHigh 보다 작은 경우
                    if (j + X - 1 >= N) continue loop; //범위 밖으로 나가는 경우
                    //땅이 일정한지 확인하는 부분
                    for (int k = j ; k <= j + X - 1; k++){
                        if (curHigh != map[k][i]) continue loop;
                        v[k] = true;
                    }
                    j = j + X - 1;
                }
            }
            total++;
        }
        return total;
    }

    //가로 체크
    static int colCheck(){

        int total = 0;

        int curHigh; // 현재 높이
        int preHigh; // 이전 높이

        loop : for (int i = 0; i < N ; i++){
            boolean[] v = new boolean[N];
            for (int j = 1 ; j < N; j++){
                curHigh = map[i][j]; // 현재 높이
                preHigh = map[i][j-1]; //이전 높이

                if (preHigh == curHigh) continue; // 그냥 넘어감
                if (Math.abs(preHigh-curHigh) > 1) continue loop; //만들지 못함

                if (curHigh > preHigh){
                    if (j - X < 0) continue loop; //범위 밖으로 나가는 경우
                    if (Math.abs(map[i][j-X] - curHigh) > 1) continue loop;
                    if (v[j-X]) continue loop;
                }else{ //현재 높이가 preHigh 보다 작은 경우
                    if (j + X - 1 >= N) continue loop; //범위 밖으로 나가는 경우
                    //땅이 일정한지 확인하는 부분
                    for (int k = j ; k <= j + X - 1; k++){
                        if (curHigh != map[i][k]) continue loop;
                        v[k] = true;
                    }
                    j = j + X - 1;
                }

            }
            total++;
        }
        return total;
    }

}
