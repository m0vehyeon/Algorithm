package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_16948_데스나이트_구미_4_이동현 {
	static int N, r1,c1,r2,c2, result;
	static int[][] map;
	static boolean[][] check;
	static int[] dx = {-2,-2,0,0,2,2};
	static int[] dy = {-1,1,-2,2,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = stoi(br.readLine());
		
		map = new int[N][N];
		check = new boolean[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r1 = stoi(st.nextToken()); c1 = stoi(st.nextToken());
		r2 = stoi(st.nextToken()); c2 = stoi(st.nextToken());
		
		System.out.println(bfs(r1,c1));
		
	}
	static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {x,y,0});
		check[x][y] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 6; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (0<=nx && nx< N && 0<=ny && ny < N && !check[nx][ny]) {
					if (nx == r2 && ny == c2) {
						return cur[2] + 1;
					}
					check[nx][ny] = true;
					q.offer(new int[] {nx,ny,cur[2] + 1});
				}
			}
		}
		return -1;
	}
	
	static int stoi(String s ) {
		return Integer.parseInt(s);
	}

}
