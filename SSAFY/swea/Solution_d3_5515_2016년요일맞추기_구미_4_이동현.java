package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_d3_5515_2016년요일맞추기_구미_4_이동현 {
	static int[] day = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static int[] r = {4,5,6,0,1,2,3};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		for (int t = 1; t<= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = stoi(st.nextToken()); int d = stoi(st.nextToken());
			int sumday = 0;
			for (int i = 1; i < m; i++) {
				sumday += day[i];
			}
			sumday += d;
			sumday-=1;
			System.out.println("#" + t + " " + r[sumday % 7]);
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
