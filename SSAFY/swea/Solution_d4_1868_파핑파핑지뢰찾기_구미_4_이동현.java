package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_d4_1868_파핑파핑지뢰찾기_구미_4_이동현 {
	static int N, result;
	
	static char[][] map;
	static boolean[][] check;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1868.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = stoi(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = stoi(br.readLine());
			map = new char[N][N];
			check = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == '.' && !check[i][j]) {
						int mine = 0;
						for (int d = 0; d < 8; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							if (0<=nx && nx < N && 0<=ny && ny < N) {
								if (map[nx][ny] == '*') mine++;
							}
						}
						if(mine == 0) {
							check[i][j] = true;
							bfs(i,j);
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.') result++;
				}
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	static void bfs(int x, int y) {
		result++;
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[]{x,y});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			ArrayList<int[]> tmp = new ArrayList<>();
			int cnt = 0;
			for (int i = 0; i < 8; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (0<=nx && nx < N && 0 <= ny && ny < N) {
					if (map[nx][ny] == '.' && !check[nx][ny]) {
						tmp.add(new int[] {nx,ny});
					} else if (map[nx][ny] == '*') cnt++;
				}
			}
			if (cnt > 0) {
				map[cur[0]][cur[1]] = (char)(cnt + '0');
			}
			else {
				for(int[] a : tmp) {
					q.offer(a);
					check[a[0]][a[1]] = true;
				}
				map[cur[0]][cur[1]] = '0';
			}
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
