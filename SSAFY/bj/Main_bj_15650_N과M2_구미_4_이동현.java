package com.ssafy.bj;

import java.io.*;
import java.util.*;

public class Main_bj_15650_N과M2_구미_4_이동현 {
	static int N;
	static int M;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[M];
		combination(0,1);
	}
	static void combination(int cnt, int start) {
		if (cnt == M) {
			for(int a : nums) System.out.print(a + " ");
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) {
			nums[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
}
