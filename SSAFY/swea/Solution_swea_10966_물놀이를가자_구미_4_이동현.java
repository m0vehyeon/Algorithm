package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_swea_10966_물놀이를가자_구미_4_이동현 {
	static int N, M;
	static char[][] map;
	static Queue<int[]> water;
	static int[][] check;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_swea_10966.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		for (int t = 1; t <= T; t++) {
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken()); M = stoi(st.nextToken());
			water = new LinkedList<>();
			map = new char[N][M];
			check = new int[N][M];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'W') {
						water.offer(new int[] {i,j});
					}
				}
			}
			bfs();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sum += check[i][j];
				}
			}
			System.out.println("#" + t + " " + (sum - water.size()));
		}
		
	}
	static void bfs() {
		while(!water.isEmpty()) {
			int[] tmp = water.poll();
			int x = tmp[0];
			int y = tmp[1];
			for (int i =0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (!isRange(nx,ny)) continue;
				if (map[nx][ny] == 'L' && check[nx][ny] == 0) {
					check[nx][ny] = check[x][y] + 1;
					water.offer(new int[] {nx,ny});
				}
			}
		}
	}
	static boolean isRange(int x, int y) {
		if (0<= x && x < N && 0<=y && y < M) return true;
		return false;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
