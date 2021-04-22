package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_14503_로봇청소기_구미_4_이동현 {
	static int N,M, result;
	
	static int x, y, dir;
	static int[][] map;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); M = stoi(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		x = stoi(st.nextToken()); y = stoi(st.nextToken());
		dir = stoi(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		
		while(true) {
			result++;
			map[x][y] = -1;
			int cnt = 0;
			
			while(true) {
				int res = find();
				if (res == 0) {
					break;
				} else if (res == 1) {
					cnt++;
				}
				if (cnt == 4) {
					int back = (dir + 2) % 4; 
					int nx = x + dx[back];
					int ny = y + dy[back];
					if (map[nx][ny] == 1) {
						System.out.println(result);
						return;
					} else {
						cnt = 0;
						x = nx;
						y = ny;
						continue;
					}
				}
			}
		}
		
	}
	// 0 : 	전진		1 : 2번으로 돌아가라
	static int find() {
		int tdir = dir-1 < 0 ? 3: dir-1;
		int nx = x + dx[tdir];
		int ny = y + dy[tdir];
		if (isRange(nx,ny)) {
			if (map[nx][ny] == 0) {
				dir = tdir;
				x = nx; y = ny;
				return 0;
			} else {
				dir = tdir;
				return 1;
			}
		} else {
			dir = tdir;
			return 1;
		}
	}
	static boolean isRange(int x, int y) {
		if (0<=x && x < N && 0 <= y && y < M) return true;
		return false;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
