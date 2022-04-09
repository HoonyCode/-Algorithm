# 성곽

난이도: 골드
링크: https://www.acmicpc.net/problem/2234
문제번호: BOJ 2234
유형: 그래프이론
작성일시: 2022년 1월 8일 오전 9:43

## 문제

![https://www.acmicpc.net/JudgeOnline/upload/201008/cas.PNG](https://www.acmicpc.net/JudgeOnline/upload/201008/cas.PNG)

대략 위의 그림과 같이 생긴 성곽이 있다. 굵은 선은 벽을 나타내고, 점선은 벽이 없어서 지나다닐 수 있는 통로를 나타낸다. 이러한 형태의 성의 지도를 입력받아서 다음을 계산하는 프로그램을 작성하시오.

1. 이 성에 있는 방의 개수
2. 가장 넓은 방의 넓이
3. 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기

위의 예에서는 방은 5개고, 가장 큰 방은 9개의 칸으로 이루어져 있으며, 위의 그림에서 화살표가 가리키는 벽을 제거하면 16인 크기의 방을 얻을 수 있다.

성은 M × N(1 ≤ M, N ≤ 50)개의 정사각형 칸으로 이루어진다. 성에는 최소 두 개의 방이 있어서, 항상 하나의 벽을 제거하여 두 방을 합치는 경우가 있다.

---

## 입력

첫째 줄에 두 정수 N, M이 주어진다. 다음 M개의 줄에는 N개의 정수로 벽에 대한 정보가 주어진다. 벽에 대한 정보는 한 정수로 주어지는데, 서쪽에 벽이 있을 때는 1을, 북쪽에 벽이 있을 때는 2를, 동쪽에 벽이 있을 때는 4를, 남쪽에 벽이 있을 때는 8을 더한 값이 주어진다. 참고로 이진수의 각 비트를 생각하면 쉽다. 따라서 이 값은 0부터 15까지의 범위 안에 있다.

---

## 출력

첫째 줄에 1의 답을, 둘째 줄에 2의 답을, 셋째 줄에 3의 답을 출력한다.

---

## 풀이과정

- 먼저 int[][] 배열에 각 숫자를 입력받고
- BFS 와 비트연산을통해 구역을 나눈다
- 나눈 구역을 통해 1,2번 출력값을 계산하고
- 나눈 구역을 활용하여 HashSet을 이용해서 붙어있는 두 구역 더한값은 넣는다.

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2234 {

    static int R, C;
    static int[][] map;
    static int[][] checkmap;
    static List<Integer> mapSizeList = new ArrayList<>();
    static int maxSize = 0;
    static Set<Integer> sizeSet = new HashSet<>();

    //서 북 동 남
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        C = Integer.parseInt(in[0]);
        R = Integer.parseInt(in[1]);

        map = new int[R][C];
        checkmap = new int[R][C];

        for (int i = 0; i < R; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(in[j]);
            }
        }

        int cnt = 1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (checkmap[i][j] != 0) continue;
                bfs(new int[]{i, j}, cnt);
                cnt++;
            }
        }

        System.out.println(mapSizeList.size());
        System.out.println(maxSize);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (checkmap[i][j] == 0) continue;
                bfs2(new int[]{i, j}, checkmap[i][j]);
            }
        }

        int answer = 0;
        for (int size : sizeSet){
            answer = Math.max(size, answer);
        }

        System.out.println(answer);

    }

    private static void bfs2(int[] start, int now) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(start);
        checkmap[start[0]][start[1]] = 0;

        int[] cur;
        int drow, dcol;
        while (!que.isEmpty()) {
            cur = que.poll();

            for (int d = 0; d < 4; d++) {
                drow = cur[0] + dr[d];
                dcol = cur[1] + dc[d];

                if (drow < 0 || drow >= R || dcol < 0 || dcol >= C) continue;
                if (checkmap[drow][dcol] != now) {
                    if (checkmap[drow][dcol] != 0)
                        sizeSet.add(mapSizeList.get(now - 1) + mapSizeList.get(checkmap[drow][dcol] - 1));
                    continue;
                }
                checkmap[drow][dcol] = 0;
                que.offer(new int[]{drow, dcol});

            }
        }

    }

    private static void bfs(int[] start, int cnt) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(start);
        checkmap[start[0]][start[1]] = cnt;

        int[] cur;
        int drow, dcol;
        int size = 0;
        while (!que.isEmpty()) {
            cur = que.poll();
            size++;

            for (int d = 0; d < 4; d++) {
                if ((map[cur[0]][cur[1]] & (1 << d)) != 0) continue;

                drow = cur[0] + dr[d];
                dcol = cur[1] + dc[d];

                if (checkmap[drow][dcol] != 0) continue;
                checkmap[drow][dcol] = cnt;
                que.offer(new int[]{drow, dcol});
            }
        }
        mapSizeList.add(size);
        maxSize = Math.max(maxSize, size);
    }
}
```