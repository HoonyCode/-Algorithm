import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2933 {

    static int R, C; // R행 C열
    static char[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new char[R][C];

        for (int i = 0 ; i < R ; i++)
            map[i] = br.readLine().trim().toCharArray();

        N = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        for (int i = 0 ; i < N ; i++){
            
            int breakRow = clustBreak(Integer.parseInt(input[i])+1, i);
            if (breakRow == -1) continue; // 부서진것이 없음

            System.out.println("부서짐");
            PrintMap();


        }

    }


    static int clustBreak(int row,int turn){ //클러스트 부스기
        if (turn % 2 == 0){ //짝수 일때는 왼쪽에서 날라옴
            for (int i = 0 ; i < C ; i++){
                if (map[row][i] == 'x'){
                    map[row][i] = '.';
                    return i;
                }
            }
        }else{ //홀수 일때는 오른쪽에서 날라옴
            for (int i = C-1; i >-1 ; i--){
                if (map[row][i] == 'x'){
                    map[row][i] = '.';
                    return i;
                }
            }
        }

        return -1;
    }

    static void PrintMap(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < R ; i++){
            for (int j = 0 ; j < C ; j++){
                sb.append(map[i][j] + " ");
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}
