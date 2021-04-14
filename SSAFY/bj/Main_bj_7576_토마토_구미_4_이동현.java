package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_7576_토마토_구미_4_이동현 {
	static int M,N,total,day,prevTotal;
	static int[][] box;
	static boolean[][] check;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<int[]> q;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = stoi(st.nextToken()); N = stoi(st.nextToken());
		box = new int[N][M];
		check = new boolean[N][M];
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = stoi(st.nextToken());
				if (box[i][j] == 0) total++;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <M; j++) {
				if(box[i][j] == 1) {
					check[i][j] = true;
					q.add(new int[] {i,j,0});
				}
			}
		}
		bfs();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(day);
	}
	static void bfs() {
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			day = cur[2];
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (!isRange(nx,ny)) continue;
				if (box[nx][ny] == 0) {
					box[nx][ny] = 1;
					check[nx][ny] = true;
					q.add(new int[] {nx,ny,cur[2] + 1});
				}
			}
		}
	}
	static boolean isRange(int x, int y) {
		if (0<=x && x < N && 0 <= y && y < M&& !check[x][y]) return true;
		return false;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
