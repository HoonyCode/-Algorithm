import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 투포인터
// 슬라이딩 윈도우
// hashMap으로도 풀 수 있을꺼 같다.

public class JOL2577 {

    // 접시의 수 N, 초밥의 가지수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
    static int N, d, k, c;
    static int[] food; // 회전초밥의 음식 번호를 담는다
    static int Max; // 최대값
    static int[] v; // 먹었던 음식의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        N = Integer.parseInt(input[0]); //돌고 있는 회전초밥의 개수
        d = Integer.parseInt(input[1]); //음식의 가지수
        k = Integer.parseInt(input[2]); //연속해서 먹는 접시의 수
        c = Integer.parseInt(input[3]); //쿠폰번호

        food = new int[N]; // 회전초밥 food 넣기
        v = new int[d + 1]; // d+1 해주는것은 1 ~ 가지수 만큼 있기 때문에

        for (int i = 0; i < N; i++) { // 회전초밥을 -> food에 넣는다
            food[i] = Integer.parseInt(br.readLine().trim());
        }

        int total = 0; // 현재의 total

        for (int i = 0; i < k; i++) { // 먼저 0 ~ k개 만큼 담는다.
            if (v[food[i]] == 0) total++;
            v[food[i]]++;
        }

        for (int i = 1; i < N; i++) {

            // 최대인지 검사 하고
            if (Max <= total) { // 검사
                if (v[c] == 0) { //쿠폰이 없으면 +1 추가
                    Max = total + 1;
                } else
                    Max = total;
            }


            v[food[i - 1]]--; //음식 뺴기
            if (v[food[i - 1]] == 0) total--;
            if (v[food[(i + k - 1) % N]] == 0) total++; // %N을 해준 이유는 회전 초밥이라 돌아 갔을때도 생각해야한다
            v[food[(i + k - 1) % N]]++; //음식 넣기
        }

        System.out.println(Max);

    }

}
