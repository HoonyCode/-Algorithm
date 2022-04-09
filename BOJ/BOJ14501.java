import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ14501 {

    static int N;
    static Data[] data;
    static int Max;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        data = new Data[N+1];
        String[] input;
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            data[i+1] = new Data(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        bfs();

        System.out.println(Max);

    }

    static void bfs(){
        Queue<Data> que = new LinkedList<>();
        que.offer(new Data(1,0));

        Data cur;
        while (!que.isEmpty()){
            cur = que.poll();

            if (cur.date > N+1){
                continue;
            }

            if (cur.date == N+1){
                Max = Math.max(Max, cur.profit);
                continue;
            }

            que.offer(new Data(cur.date+1, cur.profit));
            que.offer(new Data(cur.date + data[cur.date].date, cur.profit + data[cur.date].profit));

        }

    }


    static class Data{
        int date;
        int profit;

        public Data(int date, int profit) {
            this.date = date;
            this.profit = profit;
        }
    }

}
