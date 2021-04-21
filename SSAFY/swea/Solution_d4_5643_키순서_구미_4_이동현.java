package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_d4_5643_키순서_구미_4_이동현 {
	static int N,M,cnt;
	static int[][] map;
	static ArrayList<Integer>[] visit;
	static boolean[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = stoi(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = stoi(br.readLine());
			M = stoi(br.readLine());
			cnt = 0;
			map = new int[N+1][N+1];
			visit = new ArrayList[N+1];
			for (int i = 0; i <= N; i++) visit[i] = new ArrayList<>();
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				map[stoi(st.nextToken())][stoi(st.nextToken())] = 1;
			}
			for (int i = 1; i <= N; i++) {
				check = new boolean[N+1];
				check[i] = true;
				dfs(i, i);
			}
			for (int i = 1; i <= N; i++) {
				Set<Integer> set = new TreeSet<>();
				for(int a : visit[i]) set.add(a);
				for (int j = 1; j <= N; j++) {
					if (i == j) continue;
					for(int a : visit[j]) if(a == i) set.add(j);
				}
				if (set.size() == N-1) cnt++;
				System.out.println(set.size());
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	static void dfs(int num, int idx) {
		for (int i = 1; i <= N; i++) {
			if (num == i) continue;
			if (map[num][i] == 1 && !check[i]) {
				visit[idx].add(i);
				check[i] = true;
				dfs(i, idx);
			}
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
