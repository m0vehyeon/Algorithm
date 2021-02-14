package com.ssafy.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_15654_N과M5_구미_4_이동현 {
	static StringBuilder sb;
	static int[] input;
	static int[] nums;
	static boolean[] visit;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		nums = new int[N];
		visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) input[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(input);
		subset(0);
	}
	static void subset(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++)  System.out.print(nums[i] + " ");
			System.out.println();
			return;
		}
		for (int i = 0; i < input.length; i++) {
			if (visit[i]) continue;
			visit[i] = true;
			nums[cnt] = input[i];
			subset(cnt+1);
			visit[i] = false;
		}
	}
}
