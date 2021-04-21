package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_15685_드래곤커브_구미_4_이동현 {

	static int N;
	static int[] dy = {0,-1,0,1};
	static int[] dx = {1,0,-1,0};
	
	static int[][] map;
	static ArrayList<Integer>[] dir;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		dir = new ArrayList[N];
		for (int i = 0; i < N; i++) dir[i] = new ArrayList<>();
		map = new int[101][101];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = stoi(st.nextToken()); int y = stoi(st.nextToken());
			int d = stoi(st.nextToken()); int g = stoi(st.nextToken());
			
			makeCurve(i,x,y,d,g);
			mark(i,x,y);
		}
		System.out.println(find());
	}
	static int find() {
		int cnt = 0;
		for (int i = 0; i <= 99; i++) {
			for (int j = 0; j <= 99; j++) {
				int t = 1;
				if (map[i][j] == 1) {
					if(map[i + 1][j] == 1) t++;
					if(map[i][j+1] == 1) t++;
					if(map[i+1][j+1] == 1) t++;
				}
				if (t == 4) cnt++;
			}
		}
		return cnt;
	}
	static void mark(int n, int x, int y) {
		map[y][x] = 1;
		for (int a : dir[n]) {
			int nx = x + dx[a];
			int ny = y + dy[a];
			map[ny][nx] = 1;
			x = nx;
			y = ny;
		}
	}
	static void makeCurve(int n, int x, int y, int d, int g) {
		int cnt = 0;
		dir[n].add(d);
		while (cnt++ < g) {
			for (int i = dir[n].size()-1; i>=0; i--) {
				dir[n].add((dir[n].get(i)+1)%4);
			}
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
