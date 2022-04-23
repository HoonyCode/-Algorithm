package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_7662 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        int T = Integer.parseInt(br.readLine());
        //출력
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < T ; i++){
            treeMap.clear();
            int k = Integer.parseInt(br.readLine());

            for (int j = 0 ; j < k ; j++){
                String[] in = br.readLine().split(" ");

                char ch = in[0].charAt(0);
                int n = Integer.parseInt(in[1]);

                if (ch == 'I'){
                    treeMap.put(n, treeMap.getOrDefault(n,0) + 1);
                }else{
                    if (treeMap.isEmpty()) continue;

                    int num = n == 1 ? treeMap.lastKey() : treeMap.firstKey();
                    if (treeMap.put(num, treeMap.get(num) - 1) == 1)
                        treeMap.remove(num);
                }
            }

            sb.append(treeMap.isEmpty() ? "EMPTY" : treeMap.lastKey() + " " + treeMap.firstKey()).append('\n');
        }


        System.out.print(sb.toString());

    }
}
