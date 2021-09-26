# 알고리즘 정리

> 목차  

- [알고리즘 정리](#알고리즘-정리)
	- [MST](#mst)
	- [Kruskal](#kruskal)
	- [Knapsack](#knapsack)

---

## MST
`최소 신장 트리`<br>
신장 트리 : n개의 정점으로 이루어진 무향(방향이 없는) 그래프에서 n개의 정점과 n-1개의 간선으로 이루어진 트리 <br>
최소 신장 트리 : 무향 가중치 그래프에서 신장 트리를 구성하는 간선들의 가중치의 합이 최소인 신장 트리 <br>

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



## Knapsack  

![image](https://user-images.githubusercontent.com/44612896/133530191-b6efd8dc-ca34-4119-afbe-d86b7adad4aa.png)

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