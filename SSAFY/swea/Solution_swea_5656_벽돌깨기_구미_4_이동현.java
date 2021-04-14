package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_swea_5656_벽돌깨기_구미_4_이동현 {
	static int N, W, H, min;
	static int[][] map;
	static int[][] tmap;
	static boolean[][] check;
	static int[] nums;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_swea_5656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		for(int t = 1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken()); W = stoi(st.nextToken()); H = stoi(st.nextToken());
			min = Integer.MAX_VALUE;
			map = new int[H][W];
			nums = new int[N];
			for (int i = 0; i < H ;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = stoi(st.nextToken());
				}
			}
			
			permu(0);
			System.out.println("#" + t + " " + min);
		}
	}
	static void permu(int idx) {
		if (idx == N) {
			tmap = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					tmap[i][j] = map[i][j];
				}
			}
			for (int i = 0; i < nums.length; i++) {
				drop(nums[i]);
			}
			min = Math.min(min, remain());
			return;
		}
		for (int i = 0; i < W; i++) {
			nums[idx] = i;
			permu(idx+1);
		}
	}
	static void drop(int n) {
		for (int i = 0; i < H; i++) {
			if (tmap[i][n] > 0) {
				bomb(i, n);
				break;
			}
		}
	}
	static void bomb(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		check = new boolean[H][W];
		q.add(new int[] {x,y,tmap[x][y]});
		check[x][y] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int tx = cur[0], ty = cur[1], range = cur[2];
			tmap[tx][ty] = 0;
			if(range == 1) continue;
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j<=range-1; j++) {
					int nx = tx + dx[i] * j;
					int ny = ty + dy[i] * j;
					if (0 <= nx && nx < H && 0<=ny && ny < W && !check[nx][ny]) {
						check[nx][ny] = true;
						if (tmap[nx][ny] == 1) tmap[nx][ny] = 0;
						else if (tmap[nx][ny] > 0) q.add(new int[] {nx,ny,tmap[nx][ny]});
					}
				}
			}
		}

		reArrange();
	}
	static void reArrange() {
		for (int i = 0; i < W; i++) {
			Stack<Integer> st = new Stack<>();
			for (int j = 0; j < H; j++) {
				if (tmap[j][i] > 0) {
					st.add(tmap[j][i]);
					tmap[j][i] = 0;
				}
			}
			int idx = H-1;
			while(!st.isEmpty()) {
				tmap[idx--][i] = st.pop();
			}
		}
	}
	static int remain() {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (tmap[i][j] > 0) cnt++;
			}
		}
		return cnt;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
