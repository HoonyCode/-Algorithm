# 알고리즘 정리

> 목차  


-  [Knapsack](#Knapsack)

---

## Knapsack  

![image](https://user-images.githubusercontent.com/44612896/133530191-b6efd8dc-ca34-4119-afbe-d86b7adad4aa.png)

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
