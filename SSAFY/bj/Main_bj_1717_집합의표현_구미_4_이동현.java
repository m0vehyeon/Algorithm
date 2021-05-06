package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_1717_집합의표현_구미_4_이동현 {
	static int n,m;
	static int parents[];
	static void init() {
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}
	}
	static int find(int n) {
		if (parents[n] == n) return n;
		return parents[n] = find(parents[n]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken()); m = stoi(st.nextToken());
		
		parents = new int[n+1];
		
		init();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int com = stoi(st.nextToken());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			
			if (com == 0) {
				union(a,b);
			} else {
				int aRoot = find(a);
				int bRoot = find(b);
				if (aRoot == bRoot) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
