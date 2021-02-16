package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_2839_설탕배달_구미_4_이동현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max5 = N/5;
		int max3 = N/3;
		int min = Integer.MAX_VALUE;
		boolean flag = false;
		for (int i = 0; i <= max5;i++) {
			for (int j = 0; j <= max3; j++) {
				if (i * 5 + j * 3 == N && min > i+j) {
					min = i+j;
					flag = true;
				}
			}
		}
		if (flag) System.out.println(min);
		else System.out.println(-1);
	}
}
