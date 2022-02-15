import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < N; i++){
            String[] in = br.readLine().split(" ");

            if (in.length == 2){
                que.offer(Integer.parseInt(in[1]));
            }else{
                if (in[0].equals("empty")){
                    sb.append(que.isEmpty() ? 1 : 0).append('\n');
                    continue;
                }

                if (in[0].equals("size")){
                    sb.append(que.size()).append('\n');
                    continue;
                }

                if (que.isEmpty()){
                    sb.append(-1).append('\n');
                    continue;
                }

                if (in[0].equals("pop")){
                    sb.append(que.poll()).append('\n');
                    continue;
                }

                if (in[0].equals("front")){
                    sb.append(que.getFirst()).append('\n');
                    continue;
                }

                if (in[0].equals("back")) {
                    sb.append(que.getLast()).append('\n');
                }
            }
        }

        System.out.print(sb.toString());
    }
}
