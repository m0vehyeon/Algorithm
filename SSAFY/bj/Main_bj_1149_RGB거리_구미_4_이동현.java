package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_1149_RGB거리_구미_4_이동현 {
	static int[][] costs;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = stoi(br.readLine());
		costs = new int[N][3];
		dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			costs[i][0] = stoi(st.nextToken());
			costs[i][1] = stoi(st.nextToken());
			costs[i][2] = stoi(st.nextToken());
		}
		for (int i = 0; i < 3; i++) dp[0][i] = costs[0][i];
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < 3; k++) {
					if (j == k) continue;
					min = Math.min(min, dp[i-1][k] + costs[i][j]);
				}
				dp[i][j] = min;
			}
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			result = Math.min(result, dp[N-1][i]);
		}
		System.out.println(result);
	}
	static int stoi(String s ) {
		return Integer.parseInt(s);
	}
}
