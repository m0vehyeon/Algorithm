package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_d6_1263_사람네트워크2_구미_4_이동현 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d6_1263.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = stoi(st.nextToken());
			int[][] dist = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int tnum = stoi(st.nextToken());
					if (i == j) {
						dist[i][j] = 0;
						continue;
					}
					if (tnum == 0) tnum = Integer.MAX_VALUE;
					dist[i][j] = tnum;
				}
			}
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (i == k) continue;
					for (int j = 0; j < N; j++) {
						if (i == j || j == k) continue;
						if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += dist[i][j];
				}
				min = Math.min(sum, min);
			}
			System.out.println("#" + t + " " + min);
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
