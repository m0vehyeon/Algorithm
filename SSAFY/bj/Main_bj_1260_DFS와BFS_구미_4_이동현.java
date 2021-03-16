package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_1260_DFS와BFS_구미_4_이동현 {
	static int N, M, V;
	static int[][] map;
	static boolean[] check;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		V = stoi(st.nextToken());
		map = new int[N+1][N+1];
		check = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = stoi(st.nextToken());
			int to = stoi(st.nextToken());
			map[from][to] = 1;
			map[to][from] = 1;
		}
		dfs(V);
		System.out.println();
		bfs(V);
	}
	static void dfs(int idx) {
		check[idx] = true;
		System.out.print(idx + " ");
		for (int i = 1; i <= N; i++) {
			if (map[idx][i] == 1 && !check[i]) {
				dfs(i);
			}
		}
	}
	static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		q.offer(idx);
		visited[idx] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			for (int i = 1; i <= N; i++) {
				if (map[cur][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
