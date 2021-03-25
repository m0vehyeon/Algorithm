package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_9205_맥주마시면서걸어가기_구미_4_이동현_bfs {
	static int n;
	static int[][] dist,site;
	static boolean[] visited;
	static StringBuilder sb; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			n = stoi(br.readLine());
			site = new int[n+2][2];
			dist = new int[n+2][n+2];
			visited = new boolean[n+2];
			for (int j = 0; j < n+2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				site[j][0] = stoi(st.nextToken());
				site[j][1] = stoi(st.nextToken());
				
			}

			for (int i = 0; i < n+2; i++) {
				for (int j = i+1; j < n+2; j++) {
					int d = getDist(site[i][0], site[i][1], site[j][0],site[j][1]);
					dist[i][j] = d;
					dist[j][i] = d;
				}
			}
			
			
			bfs(0);
		}
		System.out.println(sb);
	}
	static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(num);
		while (!q.isEmpty()) {
			int a = q.poll();
			visited[a] = true;
			for (int i = 0; i < n+2; i++) {
				if (visited[i]) continue;
				if (dist[a][i] <= 1000) {
					q.add(i);
				}
			}
		}
		if (visited[n+1]) sb.append("happy\n");
		else sb.append("sad\n");
		
	}
	static int getDist(int x1, int y1, int x2, int y2) {
		return Math.abs(x2-x1) + Math.abs(y2-y1);
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
