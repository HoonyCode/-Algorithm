# 영역 구하기

난이도: 실버
링크: https://www.acmicpc.net/problem/2583
문제번호: BOJ 2583
유형: 깊이우선탐색, 완전탐색
작성일시: 2022년 1월 7일 오후 6:46

## 문제

눈금의 간격이 1인 M×N(M,N≤100)크기의 모눈종이가 있다. 이 모눈종이 위에 눈금에 맞추어 K개의 직사각형을 그릴 때, 이들 K개의 직사각형의 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어진다.

예를 들어 M=5, N=7 인 모눈종이 위에 <그림 1>과 같이 직사각형 3개를 그렸다면, 그 나머지 영역은 <그림 2>와 같이 3개의 분리된 영역으로 나누어지게 된다.

![https://www.acmicpc.net/upload/images/zzJD2aQyF5Rm4IlOt.png](https://www.acmicpc.net/upload/images/zzJD2aQyF5Rm4IlOt.png)

<그림 2>와 같이 분리된 세 영역의 넓이는 각각 1, 7, 13이 된다.

M, N과 K 그리고 K개의 직사각형의 좌표가 주어질 때, K개의 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어지는지, 그리고 분리된 각 영역의 넓이가 얼마인지를 구하여 이를 출력하는 프로그램을 작성하시오.

---

## 입력

첫째 줄에 M과 N, 그리고 K가 빈칸을 사이에 두고 차례로 주어진다. M, N, K는 모두 100 이하의 자연수이다. 둘째 줄부터 K개의 줄에는 한 줄에 하나씩 직사각형의 왼쪽 아래 꼭짓점의 x, y좌표값과 오른쪽 위 꼭짓점의 x, y좌표값이 빈칸을 사이에 두고 차례로 주어진다. 모눈종이의 왼쪽 아래 꼭짓점의 좌표는 (0,0)이고, 오른쪽 위 꼭짓점의 좌표는(N,M)이다. 입력되는 K개의 직사각형들이 모눈종이 전체를 채우는 경우는 없다.

---

## 출력

첫째 줄에 분리되어 나누어지는 영역의 개수를 출력한다. 둘째 줄에는 각 영역의 넓이를 오름차순으로 정렬하여 빈칸을 사이에 두고 출력한다.

---

## 풀이과정

- Boolean 베열을 사용하여 색칠된 칸을 표시한다.
- for문을 사용하여 완전 탐색하면서 false 칸에서 깊이우선탐색(BFS) 한다.
- 깊이우선 탐색을 하면서 크기를 `mapSizeList` ArrayList에 저장한다.
- `mapSizeList` 를 Collections.sort를 이용해서 정렬한다.
- mapSizeList.size()를 출력한다.
- 정렬된 List를 출력한다.

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// bfs sort

public class BOJ2583 {

    static int M, N, K;
    static boolean[][] visit;
    static List<Integer> mapSizeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        M = Integer.parseInt(in[0]);
        N = Integer.parseInt(in[1]);
        K = Integer.parseInt(in[2]);

        visit = new boolean[M][N];

        int x1, y1, x2, y2;
        for (int i = 0 ; i < K ; i++){
            in = br.readLine().split(" ");
            x1 = Integer.parseInt(in[0]);
            y1 = Integer.parseInt(in[1]);
            x2 = Integer.parseInt(in[2]);
            y2 = Integer.parseInt(in[3]);
            checkmap(x1,y1,x2,y2);
        }

        for (int i = 0 ; i < M ; i++){
            for (int j = 0 ; j < N ; j++ ){
                if(visit[i][j]) continue;
                bfs(new Pair(i,j));
            }
        }

        Collections.sort(mapSizeList);
        System.out.println(mapSizeList.size());
        for (Integer answer : mapSizeList){
            System.out.print(answer + " ");
        }

    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    private static void bfs(Pair start) {
        int cnt = 0;
        Queue<Pair> que = new LinkedList<>();
        que.offer(start);
        visit[start.x][start.y] = true;

        Pair cur;
        int xx, yy;
        while (!que.isEmpty()){
            cnt++;
            cur = que.poll();

            for (int d = 0 ; d < 4 ; d++){
                xx = cur.x + dx[d];
                yy = cur.y + dy[d];

                if (xx < 0 || xx >= M || yy < 0 || yy >= N || visit[xx][yy]) continue;
                visit[xx][yy] = true;
                que.offer(new Pair(xx,yy));
            }
        }

        mapSizeList.add(cnt);
    }

    private static void checkmap(int x1, int y1, int x2, int y2) {
        for (int i = y1 ; i < y2 ; i++) {
            for (int j = x1; j < x2; j++) {
                visit[i][j] = true;
            }
        }
    }

    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
```