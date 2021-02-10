package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_d3_5215_햄버거다이어트_구미_4_이동현 {
	static int N;
	static int L;
	static List<int[]> score;
	static boolean[] check;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t<= T; t++) {
			max = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			score = new ArrayList<>();
			check = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
			}
			subset(0);
			System.out.println("#" + t + " " + max);
		}
		
	}
	static void subset(int cnt) {
		if (cnt == N) {
			int Csum = 0;
			int Ssum = 0;
			for (int i = 0; i < N; i++) if(check[i]) {
				Csum+= score.get(i)[1];
				Ssum+= score.get(i)[0];
			}
			if (Csum <=L && Ssum > max) max = Ssum;
			return;
		}
		check[cnt] = true;
		subset(cnt+1);
		
		check[cnt] = false;
		subset(cnt+1);
	}
}
