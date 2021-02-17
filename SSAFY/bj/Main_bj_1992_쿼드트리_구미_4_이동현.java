package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_1992_쿼드트리_구미_4_이동현 {
	static int[][] arr;
	static StringBuilder sb;
	static String tsb = "";
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] s = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s[j] - '0';
			}
		}
		search(0,0,N);
		System.out.println(sb);
	}

	static void search(int x, int y, int size ) {
		if (size == 1) {
			sb.append(arr[x][y]);
			return;
		}
		
		int t = arr[x][y];
		boolean check = true;
		loop:for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (arr[i][j] != t) {
					check = false;
					break loop;
				}
			}
		}
		if (check) {
			sb.append(t);
			return;
		}
		int half = size / 2;
		sb.append("(");
		search(x, y, half);
		search(x, y + half, half);
		search(x + half, y, half);
		search(x + half, y + half, half);
		sb.append(")");
	}
}
