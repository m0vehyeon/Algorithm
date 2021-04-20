package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_15664_N과M10_구미_4_이동현 {
	static int N, M;
	static int[] nums, check;
	static StringBuilder sb;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); M = stoi(st.nextToken());
		nums = new int[M];
		check = new int[10001];
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		Set<Integer> set = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			int num = stoi(st.nextToken());
			set.add(num);
			check[num]++;
		}
		list = new ArrayList<>(set);
		combi(0,0);
		System.out.println(sb);
	}
	static void combi(int idx, int start) { 
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < list.size(); i++) {
			if (check[list.get(i)] > 0) {
				nums[idx] = list.get(i);
				check[list.get(i)]--;
				combi(idx+1,i);
				check[list.get(i)]++;
			}
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
