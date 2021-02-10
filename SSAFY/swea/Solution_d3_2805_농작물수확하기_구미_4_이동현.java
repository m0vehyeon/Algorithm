package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_d3_2805_농작물수확하기_구미_4_이동현 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			String[][] arr = new String[N][N];
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine().split("");
			}
			// 1 3 5 3 1
			boolean check = true;
			int num = 1;
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < num/2 + 1; j++) {
					if (N/2+j == N/2-j) {
						sum+=Integer.parseInt(arr[i][N/2 + j]);
					} else {
						sum+=Integer.parseInt(arr[i][N/2 + j]);
						sum+=Integer.parseInt(arr[i][N/2 - j]);
					}
				}
				if (check) {
					num+=2;
					if (i >= N/2 - 1) check = false;
				} else {
					num-=2;
				}
			}
			sb.append("#").append(t+1).append(" ").append(sum);
			System.out.println(sb);
		}
	}
}
