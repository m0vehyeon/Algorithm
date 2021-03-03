package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_1463_1로만들기_구미_4_이동현 {
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new int[N+1];
		for (int i = 0; i <= N; i++) dp[i] = Integer.MAX_VALUE;
		dp[1] = 0;
		for (int i = 1; i < N; i++) {
			if ((i*3) <= N) dp[i * 3] = Math.min(dp[i*3], dp[i]+1);
			if ((i*2) <= N) dp[i * 2] = Math.min(dp[i*2], dp[i]+1);
			if ((i+1) <= N) dp[i + 1] = Math.min(dp[i+1], dp[i]+1);
		}
		System.out.println(dp[N]);
	}
}
