package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_d2_2001_파리퇴치_구미_4_이동현 {
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			for (int i = 0; i <= N-M;i++) {
				for (int j = 0; j <= N - M; j++) {
					int sum = 0;
					for (int p = 0; p < M; p++) {
						for (int q = 0; q < M; q++) {
							sum += arr[i+p][j+q];
						}
					}
					if (sum > max) max = sum;
				}
			}
			System.out.println("#"+(t+1) + " " + max);
		}
	}
}
