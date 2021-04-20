package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_11727_2xn타일링2_구미_4_이동현 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i <= 1000; i++) {
			dp[i] = dp[i-1] + dp[i-2] * 2;
			dp[i] %= 10007;
		}
		System.out.println(dp[n]);
 	}
}
