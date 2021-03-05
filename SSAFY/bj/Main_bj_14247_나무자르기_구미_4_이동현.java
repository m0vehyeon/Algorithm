package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_14247_나무자르기_구미_4_이동현 {
	static int n;
	static long result;
	static int[][] tree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		tree = new int[n][2];
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			tree[i][0] = stoi(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			tree[i][1] = stoi(st.nextToken());
		}
		Arrays.sort(tree, (o1,o2) -> {
			return Integer.compare(o1[1], o2[1]);
		});
		for (int i = 0; i < n; i++) {
			result+= tree[i][0] + i * tree[i][1];
		}
		System.out.println(result);
		
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
