package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_15656_N과M7_구미_4_이동현 {
	static int N, M;
	static int[] nums;
	static int[] input;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); M = stoi(st.nextToken());
		st = new StringTokenizer(br.readLine());
		nums = new int[M];
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = stoi(st.nextToken());
		}
		Arrays.sort(input);
		permu(0);
		System.out.println(sb);
	}
	static void permu(int idx) {
		if (idx == M) {
			for (int a : nums) sb.append(a).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			nums[idx] = input[i];
			permu(idx+1);
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
