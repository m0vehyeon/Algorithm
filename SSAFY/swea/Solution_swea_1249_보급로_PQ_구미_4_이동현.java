package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_swea_1249_보급로_PQ_구미_4_이동현 {
	static int T,N,min= Integer.MAX_VALUE;
	static int[][] map,tmap;
	static boolean[][] check;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_swea_1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = stoi(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = stoi(br.readLine());
			map = new int[N][N];
			tmap = new int[N][N];
			check = new boolean[N][N];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				char[] tmp = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = tmp[j] - '0';
				}
				Arrays.fill(tmap[i],Integer.MAX_VALUE);
			}
			tmap[0][0] = 0;
			bfs();
			sb.append("#").append(t).append(" ").append(tmap[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
	}
	static void bfs() {
		PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2],o2[2]));
		q.offer(new int[] {0,0,0});
		check[0][0] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (0<= nx && nx < N && 0<= ny && ny <N) {
					if(tmap[nx][ny] > cur[2] + map[nx][ny]) {
						tmap[nx][ny] = cur[2] + map[nx][ny];
						q.add(new int[] {nx,ny,cur[2]+map[nx][ny]});
					}
				}
			}
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
