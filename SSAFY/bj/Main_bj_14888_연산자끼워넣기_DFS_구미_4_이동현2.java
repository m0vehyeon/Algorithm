package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_14888_연산자끼워넣기_DFS_구미_4_이동현2 {
	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] nums;
	static int[] opers;
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
		opers = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			opers[i] = stoi(st.nextToken());
		}
		dfs(1, nums[0]);
		System.out.println(max);
		System.out.println(min);
	}
	static void dfs(int idx,int num) {
		if (idx == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (opers[i] > 0) {
				opers[i]--;
				int result = 0;
				if (i == 0) {
					result = num + nums[idx];
				} else if (i == 1) {
					result = num - nums[idx];
				} else if (i == 2) {
					result = num * nums[idx];
				} else if (i == 3) {
					result = num / nums[idx];
				}
				dfs(idx+1, result);
				opers[i]++;
			}
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
}
