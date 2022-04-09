import java.io.*;
import java.util.*;


public class BOJ1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();


        Arrays.sort(str);

        StringBuilder sb = new StringBuilder();

        for (int i = str.length - 1; i > -1; i--) {
            sb.append(str[i]);
        }

        System.out.print(sb.toString());


    }
}
