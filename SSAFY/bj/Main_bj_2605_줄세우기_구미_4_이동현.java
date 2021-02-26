package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_2605_줄세우기_구미_4_이동현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			list.add(list.size() - sc.nextInt(), i);
		}
		for (int i = 0; i < N; i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
