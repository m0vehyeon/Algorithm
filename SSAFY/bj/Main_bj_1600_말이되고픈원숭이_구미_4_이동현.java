package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_1600_말이되고픈원숭이_구미_4_이동현 {
	static int[] dx1 = {-2,-1,-2,-1,1,2,2,1};
	static int[] dy1 = {-1,-2,1,2,-2,-1,1,2};
	static int[] dx2 = {-1,1,0,0};
	static int[] dy2 = {0,0,-1,1};
	static int K, W, H, min = Integer.MAX_VALUE;
	static int map[][];
	static Queue<int[]> q;
	static boolean[][][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = stoi(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = stoi(st.nextToken());
		H = stoi(st.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W][31];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				int num = stoi(st.nextToken());
				map[i][j] = num;
			}
		}
		q = new LinkedList<int[]>();
		q.offer(new int[] {0,0,0,K});
		visited[0][0][0] = true;
		bfs();
		
	}
	
	static void bfs() {
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tx = tmp[0];
			int ty = tmp[1];
			int count = tmp[2];
			int k = tmp[3];

			if (tx == W -1 && ty == H-1) {
				System.out.println(count);
				return;
			}
			
			if (!isAvailable(tx, ty)) continue;
			if (map[ty][tx] == 1) continue;
			if (visited[ty][tx][k]) continue;
			visited[ty][tx][k] = true;
			for (int i = 0; i < 4; i++) {
				int nx = tx + dx2[i];
				int ny = ty + dy2[i];
				q.offer(new int[] {nx,ny,count+1,k});
			}
			if (k == 0) continue;
			for (int i = 0; i <8; i++) {
				int nx = tx + dx1[i];
				int ny = ty + dy1[i];
				q.offer(new int[] {nx,ny,count+1,k-1});
			}
		}
		System.out.println(-1);
	}
	static boolean isAvailable(int x, int y) {
		if (0 <= x && x < W && 0 <= y && y < H) return true;
		return false;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
