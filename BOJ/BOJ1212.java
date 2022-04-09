import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1212 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] in = br.readLine().toCharArray();

        sb.append(Integer.toBinaryString(in[0] - '0'));
        int num;
        for (int i = 1 ; i < in.length ; i++){
            num = in[i] - '0';
            sb.append((num & (1 << 2)) != 0 ? 1 : 0);
            sb.append((num & (1 << 1)) != 0 ? 1 : 0);
            sb.append((num & 1) != 0 ? 1 : 0);
        }

        System.out.print(sb.toString());
    }
}
