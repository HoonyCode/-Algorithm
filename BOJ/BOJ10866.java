import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> que = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        String[] input;
        String str;
        for (int i = 0; i < N; i++) {
            input = br.readLine().trim().split(" ");
            str = input[0];

            if (str.equals("push_front")) {
                que.offerFirst(Integer.parseInt(input[1]));
                continue;
            } else if (str.equals("push_back")) {
                que.offerLast(Integer.parseInt(input[1]));
                continue;
            } else if (str.equals("pop_front")) {
                if (que.isEmpty()){
                    sb.append(-1);
                }else
                    sb.append(que.poll());
            } else if (str.equals("pop_back")) {
                if (que.isEmpty()){
                    sb.append(-1);
                }else
                    sb.append(que.pollLast());
            } else if (str.equals("size")) {
                sb.append(que.size());
            } else if (str.equals("empty")) {
                if (que.isEmpty()){
                    sb.append(1);
                }else
                    sb.append(0);
            } else if (str.equals("back")) {
                if (que.isEmpty())
                    sb.append(-1);
                else
                    sb.append(que.peekLast());
            }else if(str.equals("front")){
                if (que.isEmpty())
                    sb.append(-1);
                else
                    sb.append(que.peek());
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
