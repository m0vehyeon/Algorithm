package com.ssafy.jo;

import java.util.*;
import java.io.*;

public class Main_jo_1863_종교_구미_4_이동현 {
	static int N, M, sum;
	static int[] tree;
	static void make() {
		for (int i = 1; i <= N; i++) {
			tree[i] = i;
		}
	}
	static int findSet(int a) {
		if(tree[a] == a) return a;
		return tree[a] = findSet(tree[a]);
	}
	static boolean union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if (rootA == rootB) return false;
		tree[rootB] = rootA;
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		tree = new int[N+1];
		make();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			union(stoi(st.nextToken()), stoi(st.nextToken()));
		}
		for (int i = 1; i <= N; i++) {
			if(i == tree[i]) sum++;
		}
		System.out.println(sum);
		
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
