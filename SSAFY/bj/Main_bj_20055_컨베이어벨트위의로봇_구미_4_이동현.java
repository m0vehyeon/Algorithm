package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_20055_컨베이어벨트위의로봇_구미_4_이동현 {
	static int N, K, cnt;
	static int[][] velt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = stoi(st.nextToken()); K = stoi(st.nextToken());
		velt = new int[2*N][2];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2*N; i++) {
			velt[i][0] = stoi(st.nextToken());
		}
		while(findZero() < K) {
			veltMove();
			robotMove();
			upRobot();
			cnt++;
		}
		System.out.println(cnt);
	}
	static void upRobot() {
		if (velt[0][1] == 0 && velt[0][0] > 0) {
			velt[0][1] = 1;
			velt[0][0]--;
		}
	}
	static void robotMove() {
		
		for (int i = N-1; i > 0; i--) {
			if (i == N-1 && velt[i][1] == 1) {
				velt[i][1] = 0;
			}
			if (velt[i][0] > 0 && velt[i][1] == 0 && velt[i-1][1] == 1) {
				velt[i][0]--;
				velt[i][1] = 1;
				velt[i-1][1] = 0;
			}
		}
	}
	static void veltMove() {
		int[] last = velt[2*N - 1];
		for (int i = 2 * N - 1; i > 0; i--) {
			if (i== N - 1 && velt[i][1] == 1) {
				velt[i][1] = 0;
			}
			velt[i] = velt[i-1];
		}
		velt[0] = last;
	}
	static int findZero() {
		int cnt = 0;
		for (int i = 0; i < 2 * N; i++) {
			if (velt[i][0] <= 0) cnt++;
		}
		return cnt;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
