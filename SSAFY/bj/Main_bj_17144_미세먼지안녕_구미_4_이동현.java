package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_17144_미세먼지안녕_구미_4_이동현 {
	static int R,C,T, time;
	static int[][] map, robot;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = stoi(st.nextToken()); C = stoi(st.nextToken()); T = stoi(st.nextToken());
		
		map = new int[R][C];
		robot = new int[2][2];
		int k = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = stoi(st.nextToken());
				if (map[i][j] == -1) {
					robot[k][0] = i;
					robot[k][1] = j;
					k++;
				}
			}
		}
		while (time < T) {
			spread();
			upCleaning();
			downCleaning();
			time++;
		}
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] >0) result+= map[i][j];
			}
		}
		System.out.println(result);
	}
	static void spread() {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j =0; j < C; j++) {
				if (map[i][j] > 0) q.add(new int[] {i,j,map[i][j]});
			}
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (!isPossible(nx,ny)) continue;
				map[nx][ny] += (cur[2] / 5);
				cnt++;
			}
			map[cur[0]][cur[1]] = map[cur[0]][cur[1]] - ((cur[2] / 5) * cnt);
		}
	}
	static void upCleaning() {
		int[] ax = {-1,0,1,0};
		int[] ay = {0,1,0,-1};
		int x = robot[0][0], y = robot[0][1];
		int startX = x-1, startY = y;
		int idx = 0;
		while (idx < 4) {
			if(startX == x && startY == y+1) {
				map[x][y+1] = 0;
				break;
			}
			int nx = startX + ax[idx];
			int ny = startY + ay[idx];
			
			if (0<= nx && nx <=x && 0<=ny && ny < C) {
				map[startX][startY] = map[nx][ny];
				startX = nx; startY = ny;
			} else idx++;
		}
	}
	static void downCleaning() {
		int[] ax = {1,0,-1,0};
		int[] ay = {0,1,0,-1};
		int x= robot[1][0], y = robot[1][1];
		int startX = x+1, startY = y;
		int idx = 0;
		while (idx < 4) {
			if(startX == x && startY == y+1) {
				map[x][y+1] = 0;
				break;
			}
			int nx = startX + ax[idx];
			int ny = startY + ay[idx];
			
			if (x<= nx && nx < R && 0<=ny && ny < C) {
				map[startX][startY] = map[nx][ny];
				startX = nx; startY = ny;
			} else idx++;
		}
	}

	static boolean isPossible(int x, int y) {
		if (0<= x && x < R && 0 <= y && y < C && map[x][y]!=-1) return true;
		return false;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
