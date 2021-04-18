package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_20057_마법사상어와토네이도_구미_4_이동현 {
	static int N;
	static long result;
	static int[][] map;
	// 좌, 하 , 우, 상
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int[] tdx = {0,1,0,-1,-1,-1,1,1};
	static int[] tdy = {-1,0,1,0,-1,1,1,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]= stoi(st.nextToken());
			}
		}
		int x = N/2;
		int y = N/2;
		int t = 0;
		int cnt = 0;
		int cur = 1;
		int d = 0;
		while(true) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			divide(nx, ny, d);
			t++;
			if (t == cur) {
				t = 0;
				d = (d+1)%4;
				cnt++;
			}
			if (cur != N-1 && cnt ==2) {
				cur++;
				cnt = 0;
			}
			x = nx;
			y = ny;
			if (nx == 0 && ny == 0) break;
		}
		System.out.println(result);
	}
	static void divide(int x, int y, int dir) {
		// 0 : 좌	1 : 하	2 : 우	3 :	상	4 : 좌상 		5 : 우상 		6 : 우하	7 : 좌하
		int cur = map[x][y];
		int per1 = (cur * 1) / 100, per2 = (cur * 2) / 100;
		int per5 = (cur * 5) / 100, per7 = (cur * 7) / 100, per10 = (cur * 10) / 100;
		int alpha = cur - (per1 * 2 + per2 * 2 + per5 + per7 * 2 + per10 * 2);
		map[x][y] = 0; // 현재를 0으로 만든다
		switch (dir) {
			case 0: // 좌 일때
				isPossible(x + tdx[3], y + tdy[3], per7); isPossible(x + tdx[1], y + tdy[1], per7); // 상,하
				isPossible(x + tdx[3]*2, y + tdy[3]*2, per2); isPossible(x + tdx[1]*2, y + tdy[1]*2, per2); // 상x2,하x2
				isPossible(x + tdx[5], y + tdy[5], per1); isPossible(x + tdx[6], y + tdy[6], per1); // 우상,우하
				isPossible(x + tdx[4], y + tdy[4], per10); isPossible(x + tdx[7], y + tdy[7], per10); // 좌상,좌하
				isPossible(x + tdx[0] * 2, y + tdy[0] * 2, per5); // 좌x2
				isPossible(x + tdx[0], y + tdy[0], alpha); // 좌
				break;
			case 1: // 하 일때
				isPossible(x + tdx[0], y + tdy[0], per7); isPossible(x + tdx[2], y + tdy[2], per7); // 좌,우
				isPossible(x + tdx[0]*2, y + tdy[0]*2, per2); isPossible(x + tdx[2]*2, y + tdy[2]*2, per2); // 좌x2,우x2
				isPossible(x + tdx[4], y + tdy[4], per1); isPossible(x + tdx[5], y + tdy[5], per1);// 좌상 우상
				isPossible(x + tdx[7], y + tdy[7], per10); isPossible(x + tdx[6], y + tdy[6], per10); // 좌하 우하
				isPossible(x + tdx[1]*2, y + tdy[1]*2, per5); //하x2
				isPossible(x + tdx[1], y + tdy[1], alpha);
				break;
			case 2: // 우 일때
				isPossible(x + tdx[3], y + tdy[3], per7); isPossible(x + tdx[1], y + tdy[1], per7); // 상,하
				isPossible(x + tdx[3]*2, y + tdy[3]*2, per2); isPossible(x + tdx[1]*2, y + tdy[1]*2, per2); // 상x2,하x2
				isPossible(x + tdx[4], y + tdy[4], per1); isPossible(x + tdx[7], y + tdy[7], per1); // 좌상,좌하
				isPossible(x + tdx[5], y + tdy[5], per10); isPossible(x + tdx[6], y + tdy[6], per10); // 우상,우하
				isPossible(x + tdx[2]*2, y + tdy[2]*2, per5); // 우 x 2
				isPossible(x + tdx[2], y + tdy[2], alpha); // 우
				break;
			case 3: // 상 일때
				isPossible(x + tdx[0], y + tdy[0], per7); isPossible(x + tdx[2], y + tdy[2], per7); // 좌,우
				isPossible(x + tdx[0]*2, y + tdy[0]*2, per2); isPossible(x + tdx[2]*2, y + tdy[2]*2, per2); // 좌x2,우x2
				isPossible(x + tdx[4], y + tdy[4], per10); isPossible(x + tdx[5], y + tdy[5], per10);// 좌상 우상
				isPossible(x + tdx[7], y + tdy[7], per1); isPossible(x + tdx[6], y + tdy[6], per1); // 좌하 우하
				isPossible(x + tdx[3] * 2, y + tdy[3] * 2, per5); // 상x2
				isPossible(x + tdx[3], y + tdy[3], alpha); // 상
				break;
		}
	}
	static void isPossible(int x, int y, int num) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			map[x][y] += num;
		} else {
			result += num;
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
