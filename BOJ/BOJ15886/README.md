# 내 선물을 받아줘 2

난이도: 실버
링크: https://www.acmicpc.net/problem/15886
문제번호: BOJ 15886
유형: 그래프이론, 문자열
작성일시: 2021년 12월 15일 오후 4:18

## 내 선물을 받아줘 2

---

## 문제

---

욱제는 구사과의 열렬한 팬이다. 오늘 욱제는 구사과에게 선물을 전달해주려고 한다. 지난 며칠간의 관찰 끝에 욱제는 구사과의 이동 패턴을 모두 파악했다.

구사과가 있는 곳은 1×N 크기의 직사각형 지도로 나타낼 수 있으며, 1×1크기의 정사각형으로 나누어져 있다. 구사과의 위치는 (1, x)로 나타낼 수 있으며, (1, x)는 왼쪽에서부터 x번째 칸을 의미한다.

지도의 각 칸에는 E, W중의 한 문자가 쓰여져 있는데, 구사과는 이 문자를 이용해서 이동한다. 구사과의 위치가 (1, x)인 경우에 E가 쓰여져 있는 칸에 서 있었다면, (1, x+1)로, W의 경우에는 (1, x-1)로 순간이동한다. 구사과는 지치지 않기 때문에, 계속해서 이동한다.

욱제는 구사과의 위치를 모르기 때문에, 구사과가 이동을 시작하는 위치와 관계없이 선물을 주는 방법을 알아내려고 한다. 최소 몇 개의 칸 위에 선물을 놓으면, 구사과가 항상 선물을 가져가는지 구하는 프로그램을 작성하시오. 선물이 놓여진 칸에 구사과가 이동하면, 구사과는 항상 선물을 가져간다.

## 입력

---

첫째 줄에 골목길의 길이 N이 주어진다. (2 ≤ N ≤ 1,000)

둘째 줄에 길이 N짜리 구사과가 있는 곳의 지도가 주어진다.

지도에 쓰여 있는대로 이동했을 때, 지도를 벗어나는 경우는 없다.

## 출력

---

첫째 줄에 최소 몇 개의 칸에 선물을 놓아야 하는지 출력한다.

## 문제 풀이

구사과 1 X N → 1X1 크기의 정사각형으로 나누어져 있다.

처음 위치 (1, X)로 나타냄

E 이면 X + 1 /  W이면 X -1 이동 

- 그래프 이론
- 문자열
- 넓이 우선 탐색을 이용하여 문제를 품
- 언제 bfs를 탈출하는지가 관건

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ15886 {

    static boolean[] v;
    static int answer = 0;
    static char[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = br.readLine().toCharArray();
        v = new boolean[N];

        for (int i = 0; i < N; i++){
            if (v[i]) continue;
            bfs(i);
        }
        System.out.println(answer);
    }

    private static void bfs(int start) {
        v[start] = true;
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);

        int cur;
        int next;
        while (!que.isEmpty()){
            cur = que.poll();
            next = cur + (map[cur] == 'E' ? 1 : -1);

            if (map[cur] != map[next]){
                v[next] = true;
                break;
            }
            if (v[next]){
                return;
            }
            que.offer(next);
            v[next] = true;
        }

        answer++;
    }
}
```
