import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ14888 {

    static int N;
    static int[] Number;
    static boolean[] v;
    static int[] res;
    static List<Integer> list = new ArrayList<Integer>();
    static int Max = -1000000000;
    static int min = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        Number = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N ; i++){
            Number[i] = Integer.parseInt(input[i]);
        }
        input = br.readLine().split(" ");
        for (int i = 0 ; i < 4; i++){
            for (int j = 0 ; j < Integer.parseInt(input[i]); j++){
                list.add(i+1);
            }
        }

        v = new boolean[N-1];
        res = new int[N-1];
        dfs(0);

        System.out.print(Max +"\n" +min);

    }

    static void dfs(int cnt){
        if (cnt == N-1){
            int sum = Number[0];

            for (int i = 0; i < N-1; i++){
                switch (list.get(res[i])){
                    case 1:
                        sum += Number[i+1];
                        break;
                    case 2:
                        sum -= Number[i+1];
                        break;
                    case 3:
                        sum *= Number[i+1];
                        break;
                    case 4:
                        if (Number[i+1] == 0) return;
                        sum /= Number[i+1];
                        break;
                }
            }

            Max = Math.max(sum,Max);
            min = Math.min(sum,min);



            return;
        }

        for (int i = 0 ; i < N-1 ; i++){
            if (v[i]) continue;
            v[i] =true;
            res[cnt] = i;
            dfs(cnt + 1 );
            v[i] = false;
        }
    }
}
