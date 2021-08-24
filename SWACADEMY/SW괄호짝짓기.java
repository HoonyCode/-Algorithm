package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


//종류의 괄호문자들 
//'()', '[]', '{}', '<>'
public class SW괄호짝짓기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		for(int t = 1 ; t < 2; t++) {
			int result = 1;
			int N = Integer.parseInt(br.readLine());
			char[] str = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<Character>();
			for(int i = 0 ; i < N ; i++) {
				if(str[i] == '(' || str[i] == '[' || str[i] == '{' || str[i] == '<') {
					stack.add(str[i]);
				}
				else {
					if(stack.peek() == null) {
						result = 0;
						break;
					}
					if(str[i] == ')') {
						if(stack.peek() == '(') {
							stack.pop();
						}else {
							result = 0;
							break;
						}
					}else if (str [i] == ']') {
						if(stack.peek() == '[') {
							stack.pop();
						}else {
							result = 0;
							break;
						}
					}else if (str [i] == '}') {
						if(stack.peek() == '{') {
							stack.pop();
						}else {
							result = 0;
							break;
						}
					}else { // > 
						if(stack.peek() == '<') {
							stack.pop();
						}else {
							result = 0;
							break;
						}
					}
				}
			}
			
			if(stack.size() != 0) result = 0;
			
			sb.append("#" + t + " " +result + "\n");
		}
		System.out.println(sb.toString());
	}

}
