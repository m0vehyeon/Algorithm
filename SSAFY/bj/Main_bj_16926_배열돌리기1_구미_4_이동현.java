package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_16926_배열돌리기1_구미_4_이동현 {
	static int[][] arr;
	static int N, M, num;
	//우 하 좌 상
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		num = Math.min(N, M) / 2;
		for (int i = 0; i < R; i++) {
			rotate();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void rotate() {
		
		for(int i = 0; i < num; i++) {
			int idx = 0;
			int tmp = arr[i][i];
			
			int x = i;
			int y = i;
			
			while (idx < 4) {
				int nx = x + dx[idx];
				int ny = y + dy[idx];
				if (nx >= i && ny >= i && nx < N - i && ny < M - i) {
					arr[x][y] = arr[nx][ny];
					x = nx;
					y = ny;
				} else idx++;
			}
			arr[i+1][i] = tmp;
		}
	}
}
