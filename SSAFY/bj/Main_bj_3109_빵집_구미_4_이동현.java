package com.ssafy.bj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_3109_빵집_구미_4_이동현 {
	static int R,C,cnt;
	static char[][] map;
	static boolean[][] visited;
	static int[] dn = {-1,0,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) map[i] = br.readLine().toCharArray();
		
		for (int i = 0; i < R; i++) {
			visited[i][0] = true;
			dfs(i,0);
		}
		System.out.println(cnt);
	}
	private static boolean dfs(int x, int y) {
		
		if (y == C-1) {
			cnt++;
			return true;
		}
		for (int i = 0;i < 3; i++) {
			int nx = x + dn[i];
			int ny = y + 1;
			if (0 <= nx && nx < R && map[nx][ny] != 'x' && !visited[nx][ny]) {
				visited[x][y] = true;
				if(dfs(nx, ny)) return true;
				
			}
		}
		return false;
	}
	

}
