import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> que = new LinkedList<>();


        for (int i = 0 ; i < N ; i++){
            String[] input = br.readLine().trim().split(" ");
            String str = input[0];
            if (str.equals("push")){
                que.add(Integer.parseInt(input[1]));
                continue;
            }else if(str.equals("front")){
                if (que.isEmpty())
                    sb.append(-1);
                else
                    sb.append(que.peekFirst());
            }else if( str.equals("back")) {
                if (que.isEmpty())
                    sb.append(-1);
                else
                    sb.append(que.peekLast());
            }else if(str.equals("empty")){
                if (que.isEmpty()){
                    sb.append(1);
                }else
                    sb.append(0);
            }else if(str.equals("pop")){
                if (que.isEmpty()){
                    sb.append(-1);
                }else
                    sb.append(que.poll());
            }else if(str.equals("size")){
                sb.append(que.size());
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
