package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_1158_요세푸스문제_구미_4_이동현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int cnt = 1;
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Integer> ad = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			ad.offerLast(i+1);
		}
		sb.append("<");
		while (!ad.isEmpty()) {
			if (cnt % K == 0) {
				sb.append(ad.pollFirst()).append(", ");
			} else {
				ad.offerLast(ad.pollFirst());
			}
			cnt++;
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb);
	}
}
