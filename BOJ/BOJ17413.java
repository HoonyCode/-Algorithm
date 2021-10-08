import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17413 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();

		for (int i = 0; i < input.length(); i++) {
			// < > 
			if (input.charAt(i) == '<') {
				while (true) {
					sb.append(input.charAt(i));
					if (input.charAt(i) == '>')
						break;
					i++;
				}
				continue;
			}
			if (input.charAt(i) != ' ') {
				StringBuilder nsb = new StringBuilder();
				for(  ; i < input.length() ; i++) {
					if(input.charAt(i) == ' ' || input.charAt(i) == '<') {
						i--;
						break;
					}
					nsb.append(input.charAt(i));
				}
				for(int j = nsb.length()-1; j > -1 ; j--) {
					sb.append(nsb.charAt(j));
				}
				continue;
			}
			sb.append(input.charAt(i));
		}
		
		System.out.println(sb.toString());
	}
}
