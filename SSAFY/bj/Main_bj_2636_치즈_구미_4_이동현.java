package com.ssafy.bj;

import java.util.*;
import java.io.*;
public class Main_bj_2636_치즈_구미_4_이동현 {
	static int N, M, count, time, piece;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	static int[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = stoi(st.nextToken());
				if(map[i][j] == 1) count++;
			}
		}
		// 겉에 치즈 : -1 외부공기 : 2 내부공기 : -2 일반치즈 : 1
		while (count != 0) {
			visited = new int[N][M];
			init();
			dfs(0,0);
			clear();
			time++;
		}
		piece = search();
		System.out.println(time);
		System.out.println(piece);
	}
	static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = map[i][j];
			}
		}
	}
	static int search() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] == 1) {
					count++;
				}
			}
		}
		return count;
	}
	static void clear() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1) {
					map[i][j] = 0;
					count--;
				}
			}
		}
	}

	static void dfs(int x, int y) {
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (!isAvailable(nx, ny)) continue;
			if (map[nx][ny] == -1 || visited[nx][ny] == 2) continue;
			if (map[nx][ny] == 1) {
				map[nx][ny] = -1;
				continue;
			}
			visited[nx][ny] = 2;
			dfs(nx,ny);
			
		}
	}
	static boolean isAvailable(int x, int y) {
		if (0<=x && x < N && 0<=y && y < M) return true;
		return false;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
