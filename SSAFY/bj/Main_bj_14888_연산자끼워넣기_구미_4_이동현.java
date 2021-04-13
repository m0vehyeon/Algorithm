package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_14888_연산자끼워넣기_구미_4_이동현 {
	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE,operCnt;
	static int[] nums;
	static char[] opers;
	static boolean[] check;
	static List<Character> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		nums = new int[N];
		list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++ ) {
			nums[i] = stoi(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			int n = stoi(st.nextToken());
			operCnt += n;
			switch(i) {
			case 0:
				for (int j = 0; j < n; j++) list.add('+');
				break;
			case 1:
				for (int j = 0; j < n; j++) list.add('-');
				break;
			case 2:
				for (int j = 0; j < n; j++) list.add('*');
				break;
			case 3:
				for (int j = 0; j < n; j++) list.add('/');
				break;
			}
		}
		check = new boolean[operCnt];
		opers = new char[operCnt];
		permu(0);
		System.out.println(max);
		System.out.println(min);
	}
	static void permu(int idx) {
		if (idx == operCnt) {
			oper();
			return;
		}
		for (int i = 0; i < operCnt; i++) {
			if (check[i]) continue;
			opers[idx] = list.get(i);
			check[i] = true;
			permu(idx+1);
			check[i] = false;
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static void oper() {
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) q.offer(nums[i]);
		for(int i = 0; i < operCnt; i++) {
			int a = q.poll(), b = q.poll(), tmp = 0;
			switch(opers[i]) {
			case '+':
				tmp = a+b;
				break;
			case '-':
				tmp = a-b;
				break;
			case '*':
				tmp = a*b;
				break;
			case '/':
				if (a < 0) {
					a *= -1;
					tmp = -(a/b);
				} else tmp = a/b;
				break;
			}
			q.offerFirst(tmp);
		}
		int result = q.poll();
		max = Math.max(max, result);
		min = Math.min(min, result);
	}
}
