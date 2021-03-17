package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_14891_톱니바퀴_구미_4_이동현 {
	static int sum;
	static char[][] chain;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		chain = new char[5][8];
		for(int i = 1; i <= 4; i++) chain[i] = br.readLine().toCharArray();
		int N = stoi(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			change(stoi(st.nextToken()), stoi(st.nextToken()));
		}
		
		if (chain[1][0] == '1') sum+=1;
		if (chain[2][0] == '1') sum+=2;
		if (chain[3][0] == '1') sum+=4;
		if (chain[4][0] == '1') sum+=8;
		System.out.println(sum);
	}
	static void change(int num, int vec) {
		
		leftCheck(num-1, vec );
		rightCheck(num+1, vec );
		cycle(num, vec);
	}
	static void leftCheck(int num, int vec) {
		if (num <= 0) return;
		if (chain[num][2] != chain[num+1][6]) {
			leftCheck(num - 1, vec * -1);
			cycle(num, vec * -1);
		} else return;

	}
	static void rightCheck(int num, int vec) {
		if (num > 4) return;

		if (chain[num-1][2] != chain[num][6]) {
			rightCheck(num + 1, vec * -1);
			cycle(num, vec * -1);
		} else return;
	}
	static void cycle(int num, int vec) {
		// 정방향
		if (vec == 1) {
			char tmp = chain[num][7];
			for (int i = 7; i >= 1; i--) {
				chain[num][i] = chain[num][i-1];
			}
			chain[num][0] = tmp;
		} else { // 역방향
			char tmp = chain[num][0];
			for (int i = 0; i < 7;i++) {
				chain[num][i] = chain[num][i+1];
			}
			chain[num][7] = tmp;
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
