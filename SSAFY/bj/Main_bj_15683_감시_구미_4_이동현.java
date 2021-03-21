package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_15683_감시_구미_4_이동현 {
	static int N, M, min = Integer.MAX_VALUE;
	static int[][] map, tmap;
	static int[] nums;
	static List<int[]> cctv;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		map = new int[N][M];
		tmap = new int[N][M];
		cctv = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = stoi(st.nextToken());
				map[i][j] = num;
				tmap[i][j] = num;
				if (num > 0 && num != 6) cctv.add(new int[] {i,j,num});
			}
		}
		nums = new int[cctv.size()];
		solve(0);
		System.out.println(min);
	}
	static void solve(int idx) {
		if (idx == cctv.size()) {
			dir();
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tmap[i][j] == 0) sum++;
				}
			}
			min = Math.min(min,sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			nums[idx] = i;
			solve(idx+1);
		}
	}
	static void dir() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) tmap[i][j] = map[i][j];
		}
		for (int i = 0; i < cctv.size(); i++) {
			int tx = cctv.get(i)[0];
			int ty = cctv.get(i)[1];
			int num = cctv.get(i)[2];
			
			check(tx,ty,num,nums[i]);
		}
	}
	static void check(int x, int y, int num, int dir) {
		if (num == 1) {
			mark(x,y,dir);
		} else if (num == 2) {
			mark(x, y, dir);
			mark(x, y, (dir+2)%4);
		} else if (num == 3) {
			mark(x, y, dir);
			mark(x, y, (dir+1)%4);
		} else if (num == 4) {
			if (dir -1 < 0) mark(x,y,3);
			else mark(x,y,dir-1);
			mark(x, y, dir);
			mark(x,y,(dir+1)%4);
		} else {
			for(int i = 0; i < 4; i++) mark(x,y,i);
		}
	}
	static void mark(int x , int y, int dir) {
		int size = 0;
		if (N > M) size = N;
		else size = M;
		for (int i = 1; i < size; i++) {
			int nx = x + dx[dir] * i;
			int ny = y + dy[dir] * i;
			if (!isAvailable(nx,ny)) break;
			if (tmap[nx][ny] == 6) break;
			if (tmap[nx][ny] > 0) continue;
			tmap[nx][ny] = -1;
		}
	}
	static boolean isAvailable(int x, int y) {
		if (0<=x && x < N && 0<= y && y < M) {
			return true;
		}
		return false;
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
