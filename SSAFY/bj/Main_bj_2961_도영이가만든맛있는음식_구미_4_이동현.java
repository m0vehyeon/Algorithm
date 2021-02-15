package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_2961_도영이가만든맛있는음식_구미_4_이동현 {
	static int[][] arr,nums;
	static boolean[] check;
	static int N;
	static long min = Long.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = stoi(br.readLine());
		arr = new int[N][2];
		nums = new int[N][2];
		check = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = stoi(st.nextToken());
			}
		}
		subset(0);
		System.out.println(min);
		
	}
	public static void subset(int cnt) {
		if (cnt == N) {
			long sour = 1;
			long salt = 0;
			boolean c = false;
			for (int i = 0; i < N; i++) {
				if(check[i]) {
					c = true;
					sour *= arr[i][0];
					salt += arr[i][1];
				}
			}
			if (!c) return;
			long minus = Math.abs(sour - salt);
			if (min > minus) min = minus; 
			return;
		}
		check[cnt] = true;
		subset(cnt+1);
		
		check[cnt] = false;
		subset(cnt+1);
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
