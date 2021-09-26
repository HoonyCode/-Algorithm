# 알고리즘 정리

> 목차

- [알고리즘 정리](#알고리즘-정리)
  - [MST](#mst)
  - [Kruskal](#kruskal)
  - [Prim](#prim)
  - [Dijkstra](#dijkstra)
  - [DP](#dp)
  - [Knapsack](#knapsack)
  - [공부법](#공부법)

---

## MST

`최소 신장 트리`<br>
신장 트리 : n개의 정점으로 이루어진 무향(방향이 없는) 그래프에서 n개의 정점과 n-1개의 간선으로 이루어진 트리 <br>
최소 신장 트리 : 무향 가중치 그래프에서 신장 트리를 구성하는 간선들의 가중치의 합이 최소인 신장 트리 <br>

---

## Kruskal

간선을 하나씩 선택해서 MST 를 찾는 알고리즘

1. 최초, 모든 간선을 가중치에 따라 `오름차순`으로 정렬
2. 가중치가 가장 낮은 간선부터 선택하면서 트리를 증가시킴

- `사이클`이 존재하면 다음으로 가중치가 낮은 간선 선택

3. n-1 개의 간선이 선택될 때까지 2를 반복

<details>
<summary> Kruskal Code </summary>
<div markdown = "1">

```java
import java.util.Arrays;
import java.util.Scanner;

public class MSTKruskalTest {
    static int V; //정점의 갯수
    static int E; //간선의 갯수
    static int[] P; //부모를 나타냄
    static Edge[] edgeList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();

//        간선 중심임으로 간선리스트 활용
        edgeList = new Edge[E];
        for(int i = 0; i < E; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            edgeList[i] = new Edge(start, end, weight);
        }
//        그리디한 문제 접근으로 오름차순 정렬 시도
        Arrays.sort(edgeList);

//        union-find 알고리즘 적용해서 MST 생성
        makeSet();

//        간선 하나씩 사이클 여부를 판단하면서 전체 간선 만큼 반복
//          중간에 MST 완성되면 중간에서 break 구문 활용
        int cnt = 0; // 간선의 갯수
        int res = 0; // 결과치 값
        for(Edge e : edgeList) {
            if(union(e.start, e.end)) {
                res += e.weight;
                cnt++;
                if(cnt == V-1) { // MST 완료됨
                    break;
                }
            }
        }
        System.out.println(res);
    }
    static int findSet(int a) {
        if(a == P[a]) {
            return a;
        }
        return P[a] = findSet(P[a]);
    }
    static void makeSet() {
        P = new int[V]; // 정점의 갯수 만큼 부모 배열 만듬
        for(int i =0; i < V; i++) {
            P[i] = i; //자신의 값을 초기화 설정
        }
    }
    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) {
            return false;
        }
        P[bRoot] = aRoot;
        return true;
    }

    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;
        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return (Integer.compare(this.weight, o.weight));
//            return (this.weight - o.weight);
        }
    }

}
```

</div>
</details>

---

## Prim

- 하나의 정점에서 연결된 간선들 중에 하나씩 선택하면서 `MST`를 만들어 가는 방식
  1.  임의 정점을 하나 선택해서 시작
  2.  선택한 정점과 인접하는 정점들 중의 최소 비용의 간선이 존재하는 정점을 선택
  3.  모든 정점이 선택될 때 까지 1, 2 과정을 반복

<details>
<summary> Prim Code </summary>
<div markdown = "1">

```java
import java.util.Scanner;

public class PrimTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // V 개수
        int[][] input = new int[N][N];
        boolean[] v = new boolean[N]; // 탐색 체크 배열
        int[] minEdge = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                input[i][j] = sc.nextInt();
            }
            minEdge[i] = Integer.MAX_VALUE; //시작점 초기화
        }// i노드에서 j노드까지의 비용을 모두 배열에 저장

        int res = 0;
        minEdge[0] = 0; // 임의의 시작점인 0을 최소 비용으로 선택되기 위해서 최소값 설정

        for(int i = 0; i < N; i++) { //모든 정점이 MST에 포함될때까지 반복
//            1. MST에 포함되지 않은 정점 중에서 최소간선비용의 정점 찾기
            int min = Integer.MAX_VALUE;
            int minVertex = -1; // 최소 간선 비용의 정점 번호
            for(int j = 0; j < N; j++) {
                if(v[j]) { // MST에 포함된것은 무시
                    continue;
                }
                if(min > minEdge[j]) { // 최소값의 위치를 찾으면, 최소값과 위치 저장
                    min = minEdge[j];
                    minVertex = j;

                }
            }
            v[minVertex] = true; // 신장트리에 포함시킴으로
            res += min; // MST 비용에 추가하기

//            2. 선택된 정점 기준으로 MST에 연결되지 않는 타 정점과의  최소비용 수정
            for(int j = 0; j < N; j++) {
                if(v[j]) {
                    continue; // 포함된 정점 무시
                }
                if(input[minVertex][j] == 0) { // 연결 안되면 무시
                    continue;
                }
                if(minEdge[j] > input[minVertex][j]) { // 새로운 연결이 유리하면 minEdge 배열값 업데이트
                    minEdge[j] = input[minVertex][j];
                }
            }
        }
        System.out.println(res);
    }

}
```

</div>
</details>

---

## Dijkstra

- 최단 경로 정의
  - 간선의 가중치가 있는 그래프에서 두 정점 사이의 경로들 중에 간선의 가중치의 합이 최소인 경로

`다이스트라 알고리즘`

- 하나의 시작 정점에서 끝 정점까지의 최단 경로
- 음의 가중치를 허용하지 않음

방법

- 시작 정점에서의 거리가 최소인 정점을 선택해 나가면서 최단 경로를 구하는 방식이다.
- 탐욕 기법을 사용한 알고리즘으로 MST의 프림 알고리즘과 유사하다.

<details>
<summary> Dijkstra Code </summary>
<div markdown = "1">

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		int V = Integer.parseInt(st.nextToken()); //정점 갯수
		int start = 0;
		int end =  V-1; //도착점 인덱스
		final int INFINITY = Integer.MAX_VALUE;

		int[][] matrix = new int[V][V]; // 연결된 간선 받기
		int[] D = new int[V];
		boolean[] v = new boolean[V]; // 탐색체크 배열

		for(int i=0; i<V; ++i){
			st = new StringTokenizer(in.readLine().trim(), " ");
			for(int j=0; j<V; ++j){
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.fill(D, INFINITY);
		D[start] = 0; //시작점

		int min=0, current=0;
		for(int i=0; i<V; ++i){
			//a단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
			min = INFINITY;
			for(int j=0; j<V; ++j){
				if(v[j]) {
					continue;
				}
				if(D[j] < min){
					min = D[j];
					current = j;
				}
			}
			v[current] = true; // 선택 정점 방문 처리
			if(current == end){ // 선택 정점이 도착정점이면 탈출.
				break;
			}

			//b단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
			for(int c=0; c<V; ++c){
				if(v[c]) {
					continue;
				}
				if(matrix[current][c] == 0) {
					continue;
				}
				if(D[c] > min+matrix[current][c]){
					D[c] = min+matrix[current][c];
				}
			}
		}
		System.out.println(D[end]);
	}

}
```

</div>
</details>

---

## DP

- Dynamic Programming `동적 계획법`

  - 그리디 알고리즘과 같이 최적화 문제를 해결하는 알고리즘이다.
  - DP는 먼저 작은 부분 문제들의 해를 구하고 이들을 이용하여 보다 큰 크기의 부분 문제들을 해결하여, 최종적으로 원래 주어진 문제를 해결하는 알고리즘 설계 기법이다.

- `동적 계획법`의 적용 요건

  - 중복 부분문제 구조(Overlapping subproblems)
  - 최적 부분문제 구조(Optimal substructure)

- 중복 부분문제 구조

  - DP는 큰 문제를 이루는 작은 문제를 먼저 해결 -> 작은 문제들의 해를 이용해서 -> 순환적으로 큰 문제 해결
    - 순환적인 관계를 명시적으로 표현하기 위해서 동적 계획법에서는 일반적으로 수학적 도구인 점화식을 사용한다.
  - DP는 문제의 순환적인 성질 때문에 이전에 계산되어졌던 작은 문제의 해가 다른 어딘가에서 필요하게 되는 이를 위해 DP에서는 이미 해결된 작은 문제들의 해들을 어떤 저장 공간에 저장하게 된다.
  - 이렇게 저장된 해들이 다시 필요할 때 마다 해를 얻기 위해 다시 문제를 재계산하지 않고 table의 참조를 통해서 중복돈 계산을 피하게 된다.

- 최적 부분문제 구조

  - 동적 계획법이 최적화에 대한 어느 문제에나 적용될 수 있는 것은 아니다. 주어진 문제가 최적화의 원칙을 만족해야만 동적 계획법을 효율적으로 사용할 수 있다.
  - 최적화의 원칙이란 어떤 문제에 대한 해가 최적일 때 그 해를 구성하는 작은 문제들의 해 역시 최적이어야 한다는 것이다.]

- 메모리제이션
  - 컴퓨터 프로그램을 실행할 때 이전에 계산한 값을 메모리에 저장해서 매번 다시 계산하지 않도록 하여 전체적인 실행속도를 빠르게 하는 기술이다. -> 동적 계획법의 핵심이 되는 기술이다.

---

## Knapsack

![image width="50%" height="50%"](https://user-images.githubusercontent.com/44612896/133530191-b6efd8dc-ca34-4119-afbe-d86b7adad4aa.png)

<details>
<summary> Knapsack Code </summary>
<div markdown = "1">

```java
import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();

		int[] weights = new int[N + 1];
		int[] profits = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		int[][] dp = new int[N + 1][W + 1];

		// 0번 무게 0별 초기화

		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= W; w++) {
				if (weights[i] > w) { // 현재 물건 넣을 수 없으면 이전값으로 넣어주기
					dp[i][w] = dp[i - 1][w];
				} else { // 넣을 수 있다.
					dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i]] + profits[i]);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= W; w++) {
				System.out.print(dp[i][w] + " ");
			}
			System.out.println();
		}
		System.out.println(dp[N][W]);
	}
}
```

```java
import java.util.Arrays;
import java.util.Scanner;

public class Knapsack2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();

		int[] weights = new int[N + 1];
		int[] profits = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		int[] dp = new int[W + 1];

		for (int i = 1; i <= N; i++) {
			for (int w = W; w >= weights[i]; w--) {
				dp[w] = Math.max(dp[w], dp[w - weights[i]] + profits[i]);
			}
			System.out.println(Arrays.toString(dp));
		}

		System.out.println(dp[W]);
	}
}
```

</div>
</details>

---

## 공부법

- 알고리즘 문제
  - 코드업: 기초 100제
  - 백준 온라인 저지: 삼성
  - 코드포스 - 블루레벨 정도의 실력까지.
  - 탑코더 알고리즘 튜토리얼: 초심자 추천
  - 프로그래머스: 카카오
  - 알고스팟
  - 코딩도장
  - Hackerearth
  - Hackerrank

- 알고리즘 공부 방법
  - 기본 개념/문법 이해하기
  - 책
    - 프로그래밍 대회에서 배우는 알고리즘 문제 해결 전략(종만북)
    - 프로그래밍 콘테스트 챌린징(노란책)
    - Competitive Programming 3 by Steven Halim
    - Introduction to Algorithms(CLRS)
  - 인터넷
    - [LibreWiki](https://librewiki.net/wiki/%EC%8B%9C%EB%A6%AC%EC%A6%88:%EC%88%98%ED%95%99%EC%9D%B8%EB%93%AF_%EA%B3%BC%ED%95%99%EC%95%84%EB%8B%8C_%EA%B3%B5%ED%95%99%EA%B0%99%EC%9D%80_%EC%BB%B4%ED%93%A8%ED%84%B0%EA%B3%BC%ED%95%99/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98_%EA%B8%B0%EC%B4%88): 이론 한 눈에 정리
    - [visulgo](https://visualgo.net/ko): 정렬, 트리 등 원리 시각화
    - [Geeksforgeeks](https://www.geeksforgeeks.org/)
    - 기본 코드 학습: [Geeks for Geeks 풀이 샘플](https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/)
    - 앱
      - 알고리즘 도감
      - Geeksforgeeks
  - 기본 알고리즘 코드 학습하기
  - 백준에서 아래의 문제를 50문제씩 풀어보기
    - 그리디 알고리즘 문제
    - 탐색 문제(완전 탐색, BFS, DFS)
    - 기본 동적 프로그래밍
    - 기출문제

- 고급
  - 그래프이론
  - 중급 및 고급 동적 프로그래밍
  - 문자열

- 알고리즘 기본 개념
  - 시간 복잡도(중요! 계산해보아야 함)
  - 자료구조: 선형/비선형
  - 정렬

- 좋은 알고리즘의 조건
  - 입력: 외부에서 제공되는 자료가 0개 이상 존재
  - 출력: 적어도 2개 이상의 서로 다른 결과를 내야 한다.
  - 명확성: 수행과정은 명확하고 모호하지 않은 명령어로 구성된다.
  - 유한성: 유한 번의 명령어를 수행한 후 유한 시간 내에 종료한다.
  - 효율성: 모든 과정은 명백하게 실행가능(검증 가능)한 것이어야 한다.

--- 