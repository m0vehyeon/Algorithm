package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_15657_N과M8_구미_4_이동현 {
	static int N,M;
	static int[] nums;
	static int[] input;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); M = stoi(st.nextToken());
		nums = new int[M];
		input = new int[N];
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < N; i++) {
			input[i] = stoi(st.nextToken());
		}
		Arrays.sort(input);
		permu(0, 0);
		System.out.println(sb);
	}
	static void permu(int idx, int start) {
		if (idx == M) {
			for (int i = 0; i < M; i++) sb.append(nums[i]).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			nums[idx] = input[i];
			permu(idx+1, i);
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
