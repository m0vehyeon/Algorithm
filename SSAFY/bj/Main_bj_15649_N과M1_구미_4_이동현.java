package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_15649_N과M1_구미_4_이동현 {
	static int N;
	static int M;
	static int[] num;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N+1];
		num = new int[M];
		permutation(0);
	}
	static void permutation(int cnt) {
		if (cnt == M) {
			for(int a : num) System.out.print(a + " ");
			System.out.println();
			return;
		}
		for (int i = 1 ; i <= N; i++) {
			if (visit[i] == true) continue;
			num[cnt] = i;
			visit[i] = true;
			permutation(cnt+1);
			visit[i] = false;
		}
	}
}
