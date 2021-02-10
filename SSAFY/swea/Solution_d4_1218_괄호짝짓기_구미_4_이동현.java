package com.ssafy.swea;
import java.util.*;
import java.io.*;
public class Solution_d4_1218_괄호짝짓기_구미_4_이동현 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t < 11; t++) {
			Stack<Character> stack = new Stack<>();
			int N = Integer.parseInt(br.readLine());
			char[] in = br.readLine().toCharArray();
			for (char c : in) {
				if (c == '(' || c == '[' || c == '{' || c == '<') stack.push(c);
				else {
					if (stack.empty()) {
						System.out.println("#" + (t) + " " +"0");
						break;
					}
					char cmp = stack.peek();
					if ((cmp == '(' && c == ')') || (cmp == '[' && c == ']') || (cmp == '{' && c == '}') || (cmp == '<' && c == '>') )
						stack.pop();
					else {
						System.out.println("#" + (t) + " " +"0");
						break;
					}
				}
			}
			if (stack.empty()) System.out.println("#" + (t) + " " +"1");
		}
		
	}

}
