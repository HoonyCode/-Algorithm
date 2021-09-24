import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2252 {

    static int N, M;
    static int[] connectionCnt; // -> 화살표를 받는 갯수
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        list = new ArrayList<>();
        connectionCnt = new int[N+1]; //연결된 노드 수
        for(int i = 0 ; i < N+1 ; i++)
            list.add(new ArrayList<Integer>());

        int A;
        int B;
        for(int i = 0; i < M ; i++){
            // A가 B보다 크다 A<-B
            input = br.readLine().split(" ");
            A = Integer.parseInt(input[0]);
            B = Integer.parseInt(input[1]);
            connectionCnt[A]++; //화살표 받는 개수 count;
            list.get(B).add(A);
        };

        exe();

    }

    static void exe(){
        ArrayList<Integer> res = new ArrayList<>(); // 키 작은 순서로 대로 넣음
        Queue<Integer> que = new LinkedList();

        for (int i = 1 ; i <= N ; i++){
            if(connectionCnt[i] == 0) //화살표 받는 개수가 없으면 맨뒤에 설 수 있다.
                que.add(i);
        }

        int temp;
        while (!que.isEmpty()){
            temp = que.poll();
            res.add(temp);

            for (int i = 0 ; i < list.get(temp).size(); i++){
                connectionCnt[list.get(temp).get(i)]--;
                if(connectionCnt[list.get(temp).get(i)] == 0)
                    que.offer(list.get(temp).get(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = res.size()-1 ; i >= 0 ; i--){ //거꾸로 하면 키 순서대로
            sb.append(res.get(i) + " ");
        }

        System.out.println(sb.toString());
        return;
    }
}
