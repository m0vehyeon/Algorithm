package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_2504_괄호의값_구미_4_이동현 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		Stack<Character> s = new Stack<>();
		Stack<Integer> is = new Stack<>();
		Stack<Integer> res = new Stack<>();
		int sum = 0;
		boolean check = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(' || arr[i] == '[') {
				s.add(arr[i]);
				int tnum = 1;
				while(!is.isEmpty()) {
					tnum*=is.pop();
				}
				if (tnum != 1) {
					if (s.size() - 1 != 0) {
						sum += tnum;
					} else {
						sum += tnum;
						res.add(sum);
						sum = 0;
					}
				}
				
				
			} else {
				if (s.isEmpty()) {
					check = false;
					break;
				}
				char tmp = s.peek();
				if(tmp == '(' && arr[i] == ')') {
					if (s.size() - 1 != 0 ) {
						is.add(2);
						
					} else {
						
							int tnum = 1;
							while(!is.isEmpty()) {
								tnum*=is.pop();
							}
							if (tnum != 1) sum += tnum;
							sum *=2;
							res.add(sum);
							sum = 0;
						
					}
					s.pop();
				}  else if ((tmp == '[' && arr[i] == ']')) {
					if (s.size() - 1 != 0) {
						is.add(3);
					} else {
						
							int tnum = 1;
							while(!is.isEmpty()) {
								tnum*=is.pop();
							}
							if (tnum != 1) sum += tnum;
							sum *=3;
							res.add(sum);
							sum = 0;
						
					}
					s.pop();
				}
			}
		}
		if (!check || !s.isEmpty()) {
			System.out.println(0);
		} else if (check && s.isEmpty()) {
			int result = 0;
			for (int i = 0; i < res.size(); i++) {
				result+= res.get(i);
			}
			System.out.println(result);
		}
	}
}
