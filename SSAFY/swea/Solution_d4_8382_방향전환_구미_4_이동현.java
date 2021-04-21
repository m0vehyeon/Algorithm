package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_d4_8382_방향전환_구미_4_이동현 {
	static int x1, y1, x2, y2;
	static boolean[][][] check;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_8382.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = stoi(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = stoi(st.nextToken()); y1 = stoi(st.nextToken());
			x2 = stoi(st.nextToken()); y2 = stoi(st.nextToken());
			int tx = Math.abs(x2-x1);
			int ty = Math.abs(y2-y1);
			int m = (tx + ty) / 2;
			int res = 2 * m + Math.abs(tx-m) + Math.abs(ty-m);
			System.out.println("#" + t + " " + res);
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
