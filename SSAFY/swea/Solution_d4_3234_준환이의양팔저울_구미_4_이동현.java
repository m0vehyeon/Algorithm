package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_d4_3234_준환이의양팔저울_구미_4_이동현 {
	static int N;
	static int result, total;
	static int[] pow = new int[10];
	static int[] fact = new int[10];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3234.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		init();
		for (int t = 1; t <= T;t++) {
			N = stoi(br.readLine());
			result = 0;
			total = 0;
			int[] weights = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean[] checkPerm = new boolean[N];
			for (int n = 0; n < N; n++) {
				weights[n] = stoi(st.nextToken());
				total += weights[n];
			}
			permu(0, 0, 0, total, weights, checkPerm);
			System.out.println("#" + t + " " + result);
			
		}
	}
	static void init() {
		pow[0] = 1;
		fact[0] = 1;
		for (int i = 1; i <= 9; i++) {
			pow[i]= pow[i-1]*2;
			fact[i] = fact[i-1] * i;
		}
	}
	static void permu(int cnt, int left, int right, int remain,int[] weights, boolean[] checkPerm) {
		if (left >= remain + right) {
			result += pow[N - cnt] * fact[N - cnt];
			return;
		}
		if (cnt == N) {
			result++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!checkPerm[i]) {
				checkPerm[i] = true;
				int cur = weights[i];
				permu(cnt+1, left+ cur, right, remain - cur, weights,checkPerm);
				if (left >= right + cur)
					permu(cnt+1, left, right +cur, remain - cur, weights,checkPerm);
				checkPerm[i] = false;
			}
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
