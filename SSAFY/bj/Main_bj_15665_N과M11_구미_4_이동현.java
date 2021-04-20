package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_15665_N과M11_구미_4_이동현 {
	static int N, M;
	static int[] nums;
	static StringBuilder sb;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); M = stoi(st.nextToken());
		nums = new int[M];
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		Set<Integer> set = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			int num = stoi(st.nextToken());
			set.add(num);
		}
		list = new ArrayList<>(set);
		permu(0);
		System.out.println(sb);
	}
	static void permu(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			nums[idx] = list.get(i);
			permu(idx+1);
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
