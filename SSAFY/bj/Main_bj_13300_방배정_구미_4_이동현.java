package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_13300_방배정_구미_4_이동현 {
	static int[][] student;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int res = 0;
		int N = sc.nextInt();
		int K = sc.nextInt();
		student = new int[7][2]; // 1~6학년 0번방은 여자 1번방은 남자
		for (int i = 0 ; i < N; i++) {
			int sex = sc.nextInt();
			int grade = sc.nextInt();
			student[grade][sex] += 1;
		}
		for (int[] a : student) {
			if (a[0] % K == 0) res += a[0] / K;
			else res += a[0] / K + 1;
			
			if (a[1] % K == 0) res += a[1] / K;
			else res += a[1] / K + 1;
			
		}
		System.out.println(res);
	}
}
