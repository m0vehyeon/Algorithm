package com.ssafy.jo;

import java.util.*;
import java.io.*;

public class Main_jo_1681_해밀턴순환회로_구미_4_이동현 {
	static int N, min = Integer.MAX_VALUE;
	static int[][] costs;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		costs = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				costs[i][j] = stoi(st.nextToken());
			}
		}
		visited[0] = true;
		dfs(0,0,1);
		System.out.println(min);
	}
	static void dfs(int idx, int sum, int count) {
		if (count == N) {
			if (costs[idx][0] != 0) min = Math.min(min, sum + costs[idx][0]);
			return;
		}
		for (int i = 1; i < N; i++) {
			if (!visited[i] && sum < min && costs[idx][i] != 0) {
				visited[i] = true;
				dfs(i,sum + costs[idx][i],count+1);
				visited[i] = false;
			}
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
