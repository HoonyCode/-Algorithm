import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2531 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        int N = Integer.parseInt(input[0]); // 접시의 수
        int d = Integer.parseInt(input[1]); // 초밥의 가짓수
        int k = Integer.parseInt(input[2]); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(input[3]); // 쿠폰 번호

        int[] food = new int[N];
        int[] eat_food = new int[d + 1];

        for (int i = 0; i < N; i++) {
            food[i] = Integer.parseInt(br.readLine());
        }
        int total = 0;
        int Max = 0;
        // 먼저 k개 만큼 먹어야함
        for (int i = 0; i < k; i++) {
            if (eat_food[food[i]] == 0) total++; //음식을 먹은적이 없으면 가지수 total 증가
            eat_food[food[i]]++;
        }

        for (int i = 1; i < N; i++) { // 회전초밥이라서 한 바퀴 도는것도 생각해야함
            if (Max <= total) {
                if (eat_food[c] == 0)
                    Max = total + 1;
                else
                    Max = total;
            }

            //이전에 먹었던것을 뺸다
            eat_food[food[i-1]]--;
            if (eat_food[food[i-1]] == 0) total--;
            // 지금 먹는 것을 넣는다
            if (eat_food[food[(i-1+k)%N]] == 0) total++;
            eat_food[food[(i-1+k)%N]]++;
        }

        System.out.print(Max);

    }
}
