package com.ssafy.bj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_bj_2563_색종이_구미_4_이동현 {
	static int sum;
	static int[][] map = new int[100][100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int p = 0; p < 10;p++) {
				for (int q = 0; q < 10; q++) {
					if (map[100 - y-p][x+q] == 0) {
						map[100 - y-p][x+q] = 1;
					}
				}
			}
		}
		for (int j = 0; j < 100; j++) {
			int cnt = 0;
			for (int i = 99; i >= 0; i--) {
				if (map[i][j] == 1) cnt++;
			}
			sum+=cnt;
		}
		System.out.println(sum);
	}
}
