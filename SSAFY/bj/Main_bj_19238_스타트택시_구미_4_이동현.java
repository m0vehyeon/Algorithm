package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_19238_스타트택시_구미_4_이동현 {
	static int N, M, fuel, startX, startY, peopleNum;
	static int[][] map;
	static final int INF = Integer.MAX_VALUE;
	static int[][] people;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); M = stoi(st.nextToken());
		fuel = stoi(st.nextToken());
		map = new int[N+1][N+1];
		for (int i = 1; i <= N; i++ ) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = stoi(st.nextToken());
				if (map[i][j] == 1) map[i][j] = INF;
			}
		}
		st = new StringTokenizer(br.readLine());
		startX = stoi(st.nextToken()); startY = stoi(st.nextToken());
		people = new int[M+1][2];
		for (int i = 1; i<= M; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = stoi(st.nextToken());
			int sy = stoi(st.nextToken());
			int ex = stoi(st.nextToken());
			int ey = stoi(st.nextToken());
			map[sx][sy] = i;
			people[i][0] = ex; people[i][1] = ey;
		}
		while (M > 0) {
			if(!findPeople()) {
				System.out.println(-1);
				return;
			}
			if(!goEnd()) {
				System.out.println(-1);
				return;
			}
			M--;
		}
		System.out.println(fuel);
	}
	static boolean goEnd() {
		boolean[][] check = new boolean[N+1][N+1];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {startX, startY, 0});
		check[startX][startY] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == people[peopleNum][0] && cur[1] == people[peopleNum][1]) {
				fuel -= cur[2];
				if(fuel < 0) return false;
				startX = cur[0]; startY = cur[1];
				fuel += (cur[2]) * 2;
				return true;
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (isRange(nx,ny) && !check[nx][ny] && map[nx][ny] != INF) {
					check[nx][ny] = true;
					q.offer(new int[] {nx,ny,cur[2] + 1});
				}
			}
		}
		return false;
	}
	static boolean findPeople() {
		boolean[][] check = new boolean[N+1][N+1];
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int diff = Integer.compare(o1[2], o2[2]);
				int diff2 = diff==0 ? Integer.compare(o1[0], o2[0]) : diff;
				int diff3 = diff2 == 0 ? Integer.compare(o1[1], o2[1]) : diff2;
				return diff3;
			}
		});
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {startX, startY, 0});
		check[startX][startY] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (map[cur[0]][cur[1]] > 0) {
				pq.offer(new int[] {cur[0],cur[1],cur[2]});
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (isRange(nx,ny) && !check[nx][ny] && map[nx][ny] != INF) {
					
					check[nx][ny] = true;
					q.offer(new int[] {nx,ny,cur[2] + 1});
				}
			}
		}
		if (pq.isEmpty()) {
			return false;
		}
		int[] cur = pq.poll();
		
		startX = cur[0]; startY = cur[1];
		if (fuel - cur[2] > 0) {
			fuel -= cur[2];
			peopleNum = map[startX][startY];
			map[cur[0]][cur[1]] = 0;
			return true;
		}
		else return false;
	}
	static boolean isRange(int x, int y) {
		if (1<=x && x <= N && 1<= y && y <= N) return true;
		return false;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
