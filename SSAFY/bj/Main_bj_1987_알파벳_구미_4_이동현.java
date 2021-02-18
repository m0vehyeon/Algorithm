package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_1987_알파벳_구미_4_이동현 {

	static int R,C,max;
	static char[][] arr;
	static boolean[] check;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		arr = new char[R][];
		visited = new boolean[R][C];
		check = new boolean[26];
		for(int i = 0; i < R; i++) {		
			arr[i] = sc.next().toCharArray();
		}
		visited[0][0] = true;
		check[arr[0][0] - 'A'] = true;
		dfs(0,0,0);
		System.out.println(max);
	}
	static void dfs(int x, int y, int sum) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < R && 0 <= ny && ny < C && !visited[nx][ny] && !check[arr[nx][ny] - 'A']) {
				visited[nx][ny] = true;
				check[arr[nx][ny] - 'A'] = true;
				dfs(nx, ny, sum+1);
				check[arr[nx][ny] - 'A'] = false;
				visited[nx][ny] = false;
			}
		}
		sum++;
		max = Math.max(max, sum);
		return;
	}
}
