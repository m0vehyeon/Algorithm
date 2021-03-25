package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_9205_맥주마시면서걸어가기_구미_4_이동현 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int n = stoi(br.readLine());
			int[][] site = new int[n+2][2];
			int[][] dist = new int[n+2][n+2];
			for (int j = 0; j < n+2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				site[j][0] = stoi(st.nextToken());
				site[j][1] = stoi(st.nextToken());
				
			}

			for (int i = 0; i < n+2; i++) {
				for (int j = i+1; j < n+2; j++) {
					int d = getDist(site[i][0], site[i][1], site[j][0],site[j][1]);
					if (d <= 1000) {
						dist[i][j] = d;
					} else dist[i][j] = Integer.MAX_VALUE;
					dist[j][i] = dist[i][j];
				}
			}
			for (int k = 0; k < n+2; k++) {
				for (int i = 0; i < n+2; i++) {
					if (k == i) continue;
					for (int j = 0; j < n+2; j++) {
						if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE || j == k || i == j) continue;
						dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
					}
				}
			}
			if (dist[0][n+1] == Integer.MAX_VALUE) sb.append("sad\n");
			else sb.append("happy\n");
		}
		System.out.println(sb);
	}
	static int getDist(int x1, int y1, int x2, int y2) {
		return Math.abs(x2-x1) + Math.abs(y2-y1);
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
