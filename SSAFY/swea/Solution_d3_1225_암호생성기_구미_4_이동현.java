package com.ssafy.swea;

import java.util.*;
import java.io.*;
public class Solution_d3_1225_암호생성기_구미_4_이동현 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> q;
		for (int t = 1; t < 11; t++) {
			q = new LinkedList<>();
			int minus = 1;
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			int num = 0;
			while (!q.isEmpty()) {
				num = q.poll() - minus;
				if (num <= 0) {
					num = 0;
					q.add(num);
					break;
				}
				else q.add(num);
				minus++;
				if (minus == 6) minus = 1;
			}
			System.out.print("#" + N);
			for (int a : q) System.out.print(" " + a);
			System.out.println();
		}
	}
}
