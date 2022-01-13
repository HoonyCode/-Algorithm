# DSLR

난이도: 골드
링크: https://www.acmicpc.net/problem/9019
문제번호: BOJ 9019
유형: 그래프이론
작성일시: 2022년 1월 8일 오전 11:41

## 문제

네 개의 명령어 D, S, L, R 을 이용하는 간단한 계산기가 있다. 이 계산기에는 레지스터가 하나 있는데, 이 레지스터에는 0 이상 10,000 미만의 십진수를 저장할 수 있다. 각 명령어는 이 레지스터에 저장된 n을 다음과 같이 변환한다. n의 네 자릿수를 d1, d2, d3, d4라고 하자(즉 n = ((d1 × 10 + d2) × 10 + d3) × 10 + d4라고 하자)

1. D: D 는 n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다. 그 결과 값(2n mod 10000)을 레지스터에 저장한다.
2. S: S 는 n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다. n이 0 이라면 9999 가 대신 레지스터에 저장된다.
3. L: L 은 n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d, d, d, d이 된다.
    
    2
    
    3
    
    4
    
    1
    
4. R: R 은 n의 각 자릿수를 오른편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d, d, d, d이 된다.
    
    4
    
    1
    
    2
    
    3
    

위에서 언급한 것처럼, L 과 R 명령어는 십진 자릿수를 가정하고 연산을 수행한다. 예를 들어서 n = 1234 라면 여기에 L 을 적용하면 2341 이 되고 R 을 적용하면 4123 이 된다.

여러분이 작성할 프로그램은 주어진 서로 다른 두 정수 A와 B(A ≠ B)에 대하여 A를 B로 바꾸는 최소한의 명령어를 생성하는 프로그램이다. 예를 들어서 A = 1234, B = 3412 라면 다음과 같이 두 개의 명령어를 적용하면 A를 B로 변환할 수 있다.

1234 →L 2341 →L 34121234 →R 4123 →R 3412

따라서 여러분의 프로그램은 이 경우에 LL 이나 RR 을 출력해야 한다.

n의 자릿수로 0 이 포함된 경우에 주의해야 한다. 예를 들어서 1000 에 L 을 적용하면 0001 이 되므로 결과는 1 이 된다. 그러나 R 을 적용하면 0100 이 되므로 결과는 100 이 된다.

---

## 입력

프로그램 입력은 T 개의 테스트 케이스로 구성된다. 테스트 케이스 개수 T 는 입력의 첫 줄에 주어진다. 각 테스트 케이스로는 두 개의 정수 A와 B(A ≠ B)가 공백으로 분리되어 차례로 주어지는데 A는 레지스터의 초기 값을 나타내고 B는 최종 값을 나타낸다. A 와 B는 모두 0 이상 10,000 미만이다.

---

## 출력

A에서 B로 변환하기 위해 필요한 최소한의 명령어 나열을 출력한다. 가능한 명령어 나열이 여러가지면, 아무거나 출력한다.

---

## 풀이과정

- 처음에 메모리초과 나는 이유를 알지 못했다

<aside>
💡 String 계속 받는 짓을 해서 메모가 엄청 먹었다 이부분을 어떻게 수정할까 생각했다

</aside>

- 그래서 설계를 다시하기 시작했다.
- 원래의 코드는 set을 이용해서 값을 찾는 작업을 했었는데  그것보다 boolean[] 배열을 만들서 찾은것을 체크하는 것이 효율적이라고 생각했다
- DSLR 값을 저장한뒤
- boolean[] 배열에 이용해 다음수를 방문했는지 찾았고
- 방문하지 않았으면 que에 넣고 다시 DSLR 을 반복해서 원하는 A → B로 바꾸게 했다.
- 그리고 문제가된 String[] 배열을 10000개 선언해서 담았다.

<aside>
💡 중요한 점은 숫자만큼 배열 선언하는 부분이다.
어떻게 설계를 해서 효율적으로 문제를 풀까? 라는 것을 되돌아 볼 수 있는 문제였다!

</aside>

![Untitled](DSLR%2045bb94aa80c745329ffdec48142342a9/Untitled.png)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ9019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        String[] in;
        for (int i = 0 ; i < T ; i++){
            in = br.readLine().split(" ");
            int A, B;
            A = Integer.parseInt(in[0]);
            B = Integer.parseInt(in[1]);
            sb.append(bfs(A, B)).append('\n');
        }
        System.out.print(sb.toString());
    }

    static char[] d = {'D', 'S', 'L', 'R'};

    private static String bfs(int start, int end) {
        boolean[] v = new boolean[10000];
        String[] answer = new String[10000];
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        v[start] = true;
        answer[start] = "";

        Integer cur;
        while (!que.isEmpty()) {
            cur = que.poll();

            int D = (cur * 2) % 10000;
            int S = (cur == 0) ? 9999 : cur-1;
            int L = (cur % 1000) * 10 + cur/1000;
            int R = (cur % 10) * 1000 + cur/10;

            if (!v[D]){
                que.offer(D);
                v[D] = true;
                answer[D] = answer[cur] + 'D';
            }
            if (!v[S]){
                que.offer(S);
                v[S] = true;
                answer[S] = answer[cur] + 'S';
            }
            if (!v[L]) {
                que.offer(L);
                v[L] = true;
                answer[L] = answer[cur] + 'L';
            }
            if (!v[R]) {
                que.offer(R);
                v[R] = true;
                answer[R] = answer[cur] + 'R';
            }

            if (v[end]) {
                break;
            }
        }
        return answer[end];
    }
}
```