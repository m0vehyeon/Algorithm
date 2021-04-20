package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_20058_마법사상어와파이어스톰_구미_4_이동현 {
	static int N,Q,mapSize, sum, cnt = Integer.MIN_VALUE, idx, temp;
	static int[][] map, check;
	static int[] com;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static ArrayList<int[]> remove;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); Q = stoi(st.nextToken());
		mapSize = (int)Math.pow(2, N);
		map = new int[mapSize][mapSize];
		check = new int[mapSize][mapSize];
		com = new int[Q];
		for (int i = 0; i < mapSize; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < mapSize;j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int L = stoi(st.nextToken());
			solve(L);
		}
		
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				if (map[i][j] > 0 && check[i][j] == 0) {
					temp = 1;
					idx++;
					check[i][j] = idx;
					dfs(i,j);
					cnt = Math.max(temp, cnt);
				}
			}
		}
		System.out.println(sum);
		if (cnt == Integer.MIN_VALUE) cnt = 0;
		System.out.println(cnt);
	}
	static void dfs(int x, int y) {
		sum += map[x][y];
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < mapSize && 0 <= ny && ny < mapSize && check[nx][ny] == 0 && map[nx][ny] > 0) {
				temp++;
				check[nx][ny] = idx;
				dfs(nx,ny);
			}
		}
	}
	static void solve(int L) {
		int size = (int)Math.pow(2, L);
		for (int i = 0; i < mapSize; i+=size) {
			for (int j = 0; j < mapSize; j+=size) {
				rotate(i, j, size);
			}
		}
		remove = new ArrayList<>();
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize;j++) {
				if (!find(i,j)) {
					remove.add(new int[] {i,j});
				}
			}
		}
		for (int[] a : remove) {
			if (map[a[0]][a[1]] != 0) map[a[0]][a[1]]--;
		}
	}
	static boolean find(int x, int y) {
		
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < mapSize && 0 <= ny && ny < mapSize && map[nx][ny] > 0) {
				cnt++;
			}
		}
		if (cnt >= 3) return true;
		return false;
	}
	static void rotate(int x, int y, int size) {
		int[][] tmp = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size;j++) {
				tmp[j][size - i - 1] = map[x + i][y + j];
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				map[x + i][y + j] = tmp[i][j];
			}
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
