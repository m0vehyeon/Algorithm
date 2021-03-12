package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_swea_1952_수영장_구미_4_이동현 {
	static int[] money,use,result;
	static int min;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_swea_1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			min = 0;
			money = new int[4];
			use = new int[13];
			result = new int[13];
			for (int i = 0; i < 4; i++) {
				money[i] = stoi(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				use[i] = stoi(st.nextToken());
				result[i] = Integer.MAX_VALUE;
			}
			
			dfs(0,0,0);
			System.out.println("#" + t + " " + result[12]);
		}
	}
	static void dfs(int month, int sum, int day) {
		if (month > 12) {
			return;
		}
		if (day == 0) result[month] = Math.min(result[month], sum+money[day] * use[month]);
		else result[month] = Math.min(result[month], sum+money[day]);

		dfs(month+1, result[month], 0);
		dfs(month+1, result[month], 1);
		dfs(month+3, result[month], 2);
		dfs(month+12, result[month], 3);

	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
