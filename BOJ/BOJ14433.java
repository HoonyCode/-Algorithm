import java.io.*;
import java.util.*;

public class BOJ14433 {

    static List<Integer>[] list;
    static boolean[] check;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int k1 = Integer.parseInt(st.nextToken());
        int k2 = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        check = new boolean[m + 1];
        d = new int[m + 1];

        for (int i = 0; i < k1; i++) {
            st = new StringTokenizer(br.readLine());
            list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        // 1번 ~ n번 소 순차대로 축사 배정
        for (int i = 1; i <= n; i++) {
            Arrays.fill(check, false);
            if (dfs(i)) cnt++; // 축사가 배정되었으면 cnt
        }


        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < k2; i++) {
            st = new StringTokenizer(br.readLine());
            list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        Arrays.fill(d, 0);

        int cnt2 = 0;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(check, false);
            if (dfs(i)) cnt2++;
        }

        if (cnt < cnt2) {
            System.out.println("네 다음 힐딱이");
        } else
            System.out.println("그만 알아보자");
    }

    static boolean dfs(int here) {
        for (int nxt : list[here]) {
            if (!check[nxt]) {
                check[nxt] = true;
                // 비어있거나 점유 노드에 더 들어갈 공간이 있는 경우
                if (d[nxt] == 0 || dfs(d[nxt])) {
                    d[nxt] = here;
                    return true;
                }
            }
        }
        return false;
    }
}