package com.ssafy.jo;

import java.util.*;
import java.io.*;

public class Main_jo_1037_오류교정_구미_4_이동현 {
	static int[][] map;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+1][N+1];
		for (int i = 1; i<=N; i++) {
			for (int j = 1; j<=N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int calc1 = calc(1);
		int calc2 = calc(2);
		if (calc1 > 1 || calc2 > 1) {
			System.out.println("Corrupt");
		} else if (calc1 == 1 && calc2 == 1) {
			int i,j,x = 0, y = 0;
			loop:for (i = 1; i <= N; i++) {
				int sum = 0;
				for (j = 1; j <=N; j++) {
					sum += map[i][j];
				}
				if (sum%2!=0) {
					x = i;
					break loop;
				}
			}
			loop:for (i = 1; i <= N; i++) {
				int sum = 0;
				for (j = 1; j <=N; j++) {
					sum += map[j][i];
				}
				if (sum%2!=0) {
					y = i;
					break loop;
				}
			}
			System.out.println("Change bit (" + x + "," + y + ")");
		}
		else if (calc1 == 0 && calc2 == 0) {
			System.out.println("OK");
		}
	}
	static int calc(int no) {
		int count = 0;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <=N; j++) {
				if (no == 1) sum += map[j][i];
				else if (no == 2) sum += map[i][j];
			}
			if (sum % 2 != 0) count++;
		}
		return count;
	}
}
