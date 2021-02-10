package com.ssafy.bj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_bj_10972_다음순열_구미_4_이동현 {
	static int N;
	static int[] num;
	static int[] comp;
	static boolean[] visit;
	static boolean check1 = true;
	static boolean check2 = true;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		num = new int[N];
		visit = new boolean[N+1];
		comp = new int[N];
		/*for (int i = 0; i < N; i++) {
			comp[i] = sc.nextInt();
		}*/
		permutation(0);
	}
	
	static void permutation(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) System.out.print(num[i] + " ");
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (visit[i]) continue;
			num[cnt] = i;
			visit[i] = true;
			permutation(cnt+1);
			visit[i] = false;
		}
	}
}
