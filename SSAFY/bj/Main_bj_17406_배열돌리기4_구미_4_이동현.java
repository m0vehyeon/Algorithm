package com.ssafy.bj;

import java.io.*;
import java.util.*;

public class Main_bj_17406_배열돌리기4_구미_4_이동현 {
	static boolean[] visit;
	// 하 우 상 좌
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static List<int[]> narr;
	static List<int[]> sarr;
	static int[][] tarr,arr;
	static int min = Integer.MAX_VALUE;
	static int N,M,K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());
		arr = new int[N][M];
		tarr = new int[N][M];
		visit = new boolean[K];
		narr = new ArrayList<>();
		sarr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = stoi(st.nextToken());
				tarr[i][j] = arr[i][j];
			}
		}
		for (int k = 0; k < K; k++) {
			int[] tmp = new int[3];
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < 3; n++) {
				if (n < 2) tmp[n] = stoi(st.nextToken()) - 1;
				else tmp[n] = stoi(st.nextToken());
			}
			narr.add(tmp);
		}
		permutation();
		System.out.println(min);
	}
	static void permutation() {
		if (sarr.size() == K) {
			for (int i = 0; i < N; i++) tarr[i] = arr[i].clone();
			for (int i = 0; i < sarr.size(); i++) rotate(tarr, sarr.get(i));
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += tarr[i][j];
				}
				min = Math.min(sum, min);
			}
			return;
		}
		for (int i = 0; i < K; i++) {
			if (visit[i] == true) continue;
			visit[i] = true;
			sarr.add(narr.get(i));
			permutation();
			sarr.remove(sarr.size()-1);
			visit[i] = false;
		}
	}
	
	static void rotate(int[][] arr, int[] com) {
		int i = 0;
		while(true) {
			int X = com[0] - com[2] + i;
			int Y = com[1] - com[2] + i;
			int endX = com[0] + com[2] - i;
			int endY = com[1] + com[2] - i;
			if ((X == endX && Y == endY) || (endX - X == 1) && (endY - Y == 1) ) break;
			int nx, ny, ox, oy;
			ox = X;
			oy = Y;
			int tmp = arr[ox][oy];
			int idx = 0;
			while (idx < 4) {
				nx = ox + dx[idx];
				ny = oy + dy[idx];
				if (nx >= X && ny >= Y && nx <= endX && ny <= endY) {
					arr[ox][oy] = arr[nx][ny];
					ox = nx;
					oy = ny;
				} else idx++;
			}
			arr[X][Y + 1] = tmp;
			i++;
			
			
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
