# 다리 만들기

난이도: 골드
링크: https://www.acmicpc.net/problem/2146
문제번호: BOJ 2146
유형: 그래프이론
작성일시: 2022년 1월 7일 오후 8:03

## 문제

여러 섬으로 이루어진 나라가 있다. 이 나라의 대통령은 섬을 잇는 다리를 만들겠다는 공약으로 인기몰이를 해 당선될 수 있었다. 하지만 막상 대통령에 취임하자, 다리를 놓는다는 것이 아깝다는 생각을 하게 되었다. 그래서 그는, 생색내는 식으로 한 섬과 다른 섬을 잇는 다리 하나만을 만들기로 하였고, 그 또한 다리를 가장 짧게 하여 돈을 아끼려 하였다.

이 나라는 N×N크기의 이차원 평면상에 존재한다. 이 나라는 여러 섬으로 이루어져 있으며, 섬이란 동서남북으로 육지가 붙어있는 덩어리를 말한다. 다음은 세 개의 섬으로 이루어진 나라의 지도이다.

![https://www.acmicpc.net/JudgeOnline/upload/201008/bri.PNG](https://www.acmicpc.net/JudgeOnline/upload/201008/bri.PNG)

위의 그림에서 색이 있는 부분이 육지이고, 색이 없는 부분이 바다이다. 이 바다에 가장 짧은 다리를 놓아 두 대륙을 연결하고자 한다. 가장 짧은 다리란, 다리가 격자에서 차지하는 칸의 수가 가장 작은 다리를 말한다. 다음 그림에서 두 대륙을 연결하는 다리를 볼 수 있다.

![https://www.acmicpc.net/JudgeOnline/upload/201008/b2.PNG](https://www.acmicpc.net/JudgeOnline/upload/201008/b2.PNG)

물론 위의 방법 외에도 다리를 놓는 방법이 여러 가지 있으나, 위의 경우가 놓는 다리의 길이가 3으로 가장 짧다(물론 길이가 3인 다른 다리를 놓을 수 있는 방법도 몇 가지 있다).

지도가 주어질 때, 가장 짧은 다리 하나를 놓아 두 대륙을 연결하는 방법을 찾으시오.

---

## 입력

첫 줄에는 지도의 크기 N(100이하의 자연수)가 주어진다. 그 다음 N줄에는 N개의 숫자가 빈칸을 사이에 두고 주어지며, 0은 바다, 1은 육지를 나타낸다. 항상 두 개 이상의 섬이 있는 데이터만 입력으로 주어진다.

---

## 출력

첫째 줄에 가장 짧은 다리의 길이를 출력한다.

---

## 풀이방법

- map[][] 배열을 만들어서 데이터를 입력받는다
- List<List<Pair>> 라는 리스트를 만들다
- 섬이 생기면 List<new ArrayList<>> 만든다
- 바다면과 맞 닿아 있는 블록은 배열에 넣는다.
- List를 돌면서 섬과 섬사이의 거리를 구한다
- answer에 거리를 계산해서 넣는다.
- answer - 1 을 출력한다.

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ2146 {

    static int N;
    static int[][] map;
    static List<List<Pair>> maplist = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        String[] in;

        for (int i = 0; i < N; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(in[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    bfs(new Pair(i, j));
                }
            }
        }

        //거리 계산
        int answer = Integer.MAX_VALUE;

        for (int i = 0 ; i < maplist.size()-1 ; i++){
            for (int j = i+1; j < maplist.size(); j++){
                for (Pair map1 : maplist.get(i)){
                    for (Pair map2 : maplist.get(j)){
                        answer = Math.min(answer, Math.abs(map1.r - map2.r) + Math.abs(map1.c - map2.c));
                    }
                }
            }
        }
        System.out.println(answer - 1);
    }

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    private static void bfs(Pair pair) {

        Queue<Pair> que = new LinkedList<>();
        que.offer(pair);
        map[pair.r][pair.c] = 2;
        maplist.add(new ArrayList<>());

        Pair cur;
        int row, col;
        boolean flag;
        while (!que.isEmpty()) {
            cur = que.poll();
            flag = false;

            for (int d = 0; d < 4; d++) {
                row = cur.r + dr[d];
                col = cur.c + dc[d];

                if (row < 0 || row >= N || col < 0 || col >= N) continue;
                if (map[row][col] != 1) {
                    flag = true;
                    continue;
                }

                map[row][col] = 2;
                que.offer(new Pair(row, col));
            }

            if (flag) maplist.get(maplist.size()-1).add(cur);
        }

    }

    static class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
```