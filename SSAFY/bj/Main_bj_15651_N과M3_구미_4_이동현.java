package com.ssafy.bj;


import java.util.*;
import java.io.*;

public class Main_bj_15651_N과M3_구미_4_이동현 {
	static int N;
	static int M;
	static int[] num;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[M];
		permutation(0);
		System.out.println(sb);
	}
	static void permutation(int cnt) {
		if (cnt == M) {
			for(int a : num) sb.append(a + " ");
			sb.append("\n");
			return;
		}
		for (int i = 1 ; i <= N; i++) {
			num[cnt] = i;
			permutation(cnt+1);
		}
	}
}

