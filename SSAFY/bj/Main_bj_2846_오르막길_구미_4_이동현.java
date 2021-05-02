package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_2846_오르막길_구미_4_이동현 {
	static int N, answer = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		
		N = stoi(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int prev = 0;
		for (int i = 0; i < N; i++) {
			int cur = stoi(st.nextToken());
			if (prev < cur) {
				prev = cur;
				list.add(cur);
			} else {
				prev = cur;
				if (list.size()>=2) {
					answer = Math.max(answer,list.get(list.size()-1) - list.get(0));
				}
				list.clear();
				list.add(cur);
			}
		}
		if (list.size() >= 2) {
			answer = Math.max(answer,list.get(list.size()-1) - list.get(0));
		}
		if (answer == Integer.MIN_VALUE) answer = 0;
		System.out.println(answer);
		
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
