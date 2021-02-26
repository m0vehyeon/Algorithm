package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_10799_쇠막대기_구미_4_이동현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.next().toCharArray();
		int res = 0;
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') s.push(arr[i]);
			else {
				s.pop();
				if (arr[i - 1] == '(') {
					res += s.size();
				} else res++;
			}
		}
		System.out.println(res);
	}
}
