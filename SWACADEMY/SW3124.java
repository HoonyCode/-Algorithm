
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class SW3124 {
    static int V; //정점의 갯수
    static int E; //간선의 갯수
    static Edge[] edgeList;

    static int[] P;
    static int findSet(int a) {
        if(a == P[a]) {
            return a;
        }
        return P[a] = findSet(P[a]);
    }
    static void makeSet() {
        P = new int[V+1]; // 정점의 갯수 만큼 부모 배열 만듬
        for(int i =1; i <= V; i++) {
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
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        
        for(int t = 1 ; t <= T ; t++) {
        	String[] input = br.readLine().split(" ");
            V = Integer.parseInt(input[0]);
            E = Integer.parseInt(input[1]);

            //간선 중심임으로 간선리스트 활용
            edgeList = new Edge[E];
            for(int i = 0; i < E; i++) {
            	input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                int weight = Integer.parseInt(input[2]);
                edgeList[i] = new Edge(start, end, weight);
            }
//            그리디한 문제 접근으로 오름차순 정렬 시도
            Arrays.sort(edgeList);

//            union-find 알고리즘 적용해서 MST 생성
            makeSet();

            //간선 하나씩 사이클 여부를 판단하면서 전체 간선 만큼 반복
//              중간에 MST 완성되면 중간에서 break 구문 활용
            int cnt = 0; // 간선의 갯수
            long res = 0; // 결과치 값
            for(Edge e : edgeList) {
                if(union(e.start, e.end)) {
                    res += e.weight;
                    cnt++;
                    if(cnt == V-1) { // MST 완료됨
                        break;
                    }
                }
            }
            sb.append("#" + t + " " + res + "\n");
        }
        System.out.println(sb.toString());

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
