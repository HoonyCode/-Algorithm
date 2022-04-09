import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16987 {

    static int Max;



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //각 계란의 내구도는 상대 계란의 무게만큼 깍이게 된다
        //내구도가 0이하가 되는 순간 계란은 깨지게 된다.
        //내구도 - 상대 계란의 무게

        Data[] data = new Data[N];

        String[] input;
        for (int i = 0; i < N ; i++){
            input = br.readLine().split(" ");
            data[i] = new Data(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
        }




    }

    static class Data{
        int durability; //내구도
        int weight; //무게
        public Data(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }
}
