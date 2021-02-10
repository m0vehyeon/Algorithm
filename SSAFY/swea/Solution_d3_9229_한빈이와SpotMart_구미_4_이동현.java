package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_d3_9229_한빈이와SpotMart_구미_4_이동현 {
	static int[] height;
	static boolean[] check;
	static int N, M ,max;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_9229.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			max = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			height = new int[N];
			for (int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			subset(0,0,0);
			if (max == 0) max -=1;
			System.out.println("#" + t + " " + max);
		}
	}
	static void subset(int idx,  int weight, int cnt) {
		if (weight > M) return;
		if (cnt == 2) {
			max = Math.max(max,weight);
			return;
		}
		if (idx == N) return;
		
		subset(idx+1, weight + height[idx], cnt+1);
		subset(idx+1, weight, cnt);
	}
}
