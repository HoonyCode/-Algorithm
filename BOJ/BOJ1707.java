import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1707 {

    static int V;
    static int E;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine().trim());



        String res;
        for (int t = 0 ; t < K ; t++){
            String[] input = br.readLine().trim().split(" ");
            res = "YES";
            V = Integer.parseInt(input[0]);
            E = Integer.parseInt(input[1]);

            list = new ArrayList[V+1];

            for (int i = 1; i <= V ; i++){
                list[V] = new ArrayList();
            }

            for (int i = 0; i < E ; i++){
                input = br.readLine().trim().split(" ");
                list[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
                list[Integer.parseInt(input[1])].add(Integer.parseInt(input[0]));
            }

            for (int i = 1 ; i < V+1; i++){
                if (!bfs()){
                    res = "NO";
                }
            }


        }

        System.out.println(sb.toString());
    }

    static boolean bfs(){
        Queue<Integer> que = new LinkedList<>();




        return true;
    }
}
