package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_swea_1953_탈주범검거_구미_4_이동현 {
	static int N,M,R,C,L, cnt;
	static int[][] map;
	static boolean[][] check;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] tunnel = {{},{0,1,2,3},{0,1},{2,3},{0,3},{1,3},{1,2},{0,2}};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_swea_1953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		for (int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken()); M = stoi(st.nextToken());
			R = stoi(st.nextToken()); C = stoi(st.nextToken());
			L = stoi(st.nextToken()); cnt = 1;

			map = new int[N][M];
			check = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = stoi(st.nextToken());
				}
			}
			bfs();
			System.out.println("#" + t + " " + cnt);
		}
	}
	static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {R,C,1});
		check[R][C] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0], y = cur[1], time = cur[2]; 
			for (int i = 0; i < tunnel[map[x][y]].length; i++) {
				int nx = x + dx[tunnel[map[x][y]][i]];
				int ny = y + dy[tunnel[map[x][y]][i]];
				if (!isPossible(nx,ny,map[x][y],tunnel[map[x][y]][i])) continue;
				if (time+1 > L) continue;
				q.offer(new int[] {nx, ny, time+1});
				cnt++;
				check[nx][ny] = true;
			}
		}
	}
	static boolean isPossible(int x, int y, int cur, int dir) {
		if (0<= x && x < N && 0 <= y && y <M && map[x][y] != 0 && !check[x][y]) {
			int next = map[x][y];
			if (dir == 0) {
				for (int i = 0; i < tunnel[next].length; i++) {
					if (tunnel[next][i] == 1) return true;
				}
			} else if (dir == 1) {
				for (int i = 0; i < tunnel[next].length; i++) {
					if (tunnel[next][i] == 0) return true;
				}
			} else if (dir == 2) {
				for (int i = 0; i < tunnel[next].length; i++) {
					if (tunnel[next][i] == 3) return true;
				}
			} else if (dir == 3) {
				for (int i = 0; i < tunnel[next].length; i++) {
					if (tunnel[next][i] == 2) return true;
				}
			}
		}
		return false;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
