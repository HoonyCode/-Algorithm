import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        char[] map;
        Stack<Character> stack = new Stack<>();
        loop : for (int t = 1 ; t <= T ; t++){
            stack.clear();
            map = br.readLine().toCharArray();
            for (int i = 0; i < map.length; i++){
                if (map[i] == ')'){
                    if(stack.size() > 0)
                        stack.pop();
                    else{
                        sb.append("NO\n");
                        continue loop;
                    }
                }else{
                    stack.add(map[i]);
                }
            }

            if (stack.isEmpty()){
                sb.append("YES\n");
                continue loop;
            }else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb.toString());
    }
}
