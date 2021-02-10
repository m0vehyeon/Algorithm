package com.ssafy.swea;

import java.util.*;
import java.io.*;
public class Solution_d3_3499_퍼펙트셔플_구미_4_이동현 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_3499.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			ArrayDeque<String> first = new ArrayDeque<>();
			ArrayDeque<String> second = new ArrayDeque<>();
			
			sb.append("#").append(t+1).append(" ");
			for (int i = 0; i < N; i++) {
				if (N%2 == 0) {
					if (i < N/2) first.offerLast(st.nextToken());
					else second.offerLast(st.nextToken());
				} else {
					if (i <= N/2) first.offerLast(st.nextToken());
					else second.offerLast(st.nextToken());
				}
			}
			for (int i = 1; i <= N; i++) {
				if (i % 2 == 1) sb.append(first.pollFirst()).append(" ");
				else sb.append(second.pollFirst()).append(" ");
			}
			System.out.println(sb);
		}
	}
}
