package com.ssafy.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_15655_N과M6_구미_4_이동현 {
	static StringBuilder sb;
	static int[] input;
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
		visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) input[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(input);
		subset(0);
		System.out.println(sb);
	}
	
	static void subset(int cnt) {
		if (cnt == N) {
			int len = 0;
			for (int i = 0; i < visit.length; i++) if (visit[i]) len++;
			if (len == M) {
				for (int i = 0; i < N; i++) {
					if (visit[i]) sb.append(input[i] + " ");
				}
				sb.append("\n");
			}
			return;
		}
		visit[cnt] = true;
		subset(cnt+1);
		
		visit[cnt] = false;
		subset(cnt+1);
	}
}
