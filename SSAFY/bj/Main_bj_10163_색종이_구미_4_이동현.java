package com.ssafy.bj;

import java.util.*;
import java.io.*;


public class Main_bj_10163_색종이_구미_4_이동현 {
	static int[] res;
	public static void main(String[] args) {
		int[][] map = new int[101][101];
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		res = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int[] com = new int[4];
			for (int j = 0; j < 4; j++) {
				com[j] = sc.nextInt();
			}
			for (int p = 0; p < com[2]; p++) {
				for (int q = 0; q < com[3]; q++) {
					map[com[0] + p][com[1] + q] = i;
				}
			}
		}
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				res[map[i][j]] += 1;
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.println(res[i]);
		}
	}
}
