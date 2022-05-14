package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_최소힙 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        while (N-- > 0){
            int input = Integer.parseInt(br.readLine());

            if (input == 0){
                if (queue.isEmpty()){
                    sb.append(0);
                }else{
                    sb.append(queue.poll());
                }
                sb.append('\n');
            }else{
                queue.offer(input);
            }
        }

        System.out.println(sb);

    }

}
