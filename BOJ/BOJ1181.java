import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class BOJ1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            hashSet.add(br.readLine());
        }

        String[] res = new String[hashSet.size()];

        hashSet.toArray(res);


        Arrays.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                else
                    return o1.length() - o2.length();
            }
        });

        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]).append('\n');
        }

        System.out.println(sb.toString());

    }

}
