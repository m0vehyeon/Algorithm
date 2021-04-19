package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_15663_N과M9_구미_4_이동현 {
	static int N, M;
	static int[] nums;
	static ArrayList<Integer> count;
	static Set<Integer> set;
	static int[] check;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); M = stoi(st.nextToken());
		nums = new int[M];
		check = new int[10001];
		set = new TreeSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int t = stoi(st.nextToken());
			set.add(t);
			check[t]++;
		}
		count = new ArrayList<>(set);
		permu(0);
		System.out.println(sb);
	}
	static void permu(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) sb.append(nums[i]).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = 0; i < count.size(); i++) {
			if (check[count.get(i)] > 0) {
				check[count.get(i)]--;
				nums[idx] = count.get(i);
				permu(idx+1);
				check[count.get(i)]++;
			}
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
