package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_swea_1949_등산로조성_구미_4_이동현 {
	static int N, result, K;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map, tmap;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_sw_1949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken());
			K = stoi(st.nextToken());
			int max = 0;
			result = 0;
			map = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int num = stoi(st.nextToken());
					map[i][j] = num;
					max = Math.max(max, num);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						visited[i][j] = true;
						dfs(i, j, max,0, 1);
						visited[i][j] = false;
						
					}
				}
			}
			System.out.println("#" + t + " " + result);
			
		}
	}
	static void dfs(int x, int y, int cur, int check, int count) {
		result = Math.max(result, count);
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (!isRange(nx,ny)) continue;
			if (map[nx][ny] >= cur) {
				if(check == 0) {
					if (map[nx][ny] - K < cur) {
						visited[nx][ny] = true;
						dfs(nx,ny,cur - 1,check + 1,count+1);
						visited[nx][ny] = false;
					}
				}

			} else {
				visited[nx][ny] = true;
				dfs(nx,ny,map[nx][ny],check,count+1);
				visited[nx][ny] = false;
			}
				
			
			
		}
	}
	static boolean isRange(int x, int y) {
		if (0<= x && x < N && 0 <= y && y < N && visited[x][y] != true) return true;
		return false;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
