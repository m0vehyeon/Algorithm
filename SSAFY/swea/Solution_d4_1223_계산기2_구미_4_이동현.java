package com.ssafy.swea;

import java.util.*;
import java.io.*;
public class Solution_d4_1223_계산기2_구미_4_이동현 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1223.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Character> backs;
		ArrayDeque<Character> opers;
		ArrayDeque<Integer> result;
		char[] com;
		for (int t = 1; t < 11; t++) {
			int N = Integer.parseInt(br.readLine());
			com  = new char[N];
			opers = new ArrayDeque<>();
			backs = new ArrayDeque<>();
			com = br.readLine().toCharArray();
			
			for (int i = 0; i < N; i++) {
				if (0 <= com[i] - '0' && com[i] - '0' <=9 ) {
					backs.offerLast(com[i]);
				}
				else {
					if (opers.isEmpty()) opers.offerLast(com[i]);
					else {
						if (com[i] == '*') {
							while (!opers.isEmpty() && opers.peek() != '+') backs.offerLast(opers.pollLast());
							opers.offerLast(com[i]);
						}
						else {
							while (!opers.isEmpty()) backs.offer(opers.pollLast());
							opers.offerLast(com[i]);
						}
					}
				}
			}
			while(!opers.isEmpty()) backs.offer(opers.pollLast());
			result = new ArrayDeque<>();
			while(!backs.isEmpty()) {
				char tmp = backs.pollFirst();
				int num1 = 0, num2 = 0;
				if (0<= tmp - '0' && tmp - '0' <= 9) result.offerLast(tmp - '0');
				else {
					num1 = result.pollLast();
					num2 = result.pollLast();
					int tn;
					if (tmp == '+') {
						tn = num1 + num2;
						result.offerLast(tn);
					}
					else {
						tn = num1*num2;
						result.offerLast(tn);
					}
				}
			}
			System.out.println("#" +t + " "+ result.getFirst());
		}
	}
}
