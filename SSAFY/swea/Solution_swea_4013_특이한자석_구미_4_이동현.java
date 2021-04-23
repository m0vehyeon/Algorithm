package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_swea_4013_특이한자석_구미_4_이동현 {
	static int K;
	static int[][] chain;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_swea_4013.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = stoi(br.readLine());
		
		for (int t=1; t<= T; t++) {
			K = stoi(br.readLine());
			chain = new int[5][8];
			int score = 0;
			for (int i = 1; i<=4;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) chain[i][j] = stoi(st.nextToken());
			}
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = stoi(st.nextToken()); int dir = stoi(st.nextToken());
				left(num - 1, dir);
				right(num + 1, dir);
				rotate(num,dir);
			}
			if(chain[1][0] == 1) score+=1;
			if (chain[2][0] == 1) score+=2;
			if (chain[3][0] == 1) score+=4;
			if (chain[4][0] == 1) score+=8;
			sb.append("#").append(t).append(" ").append(score).append("\n");
		}
		System.out.println(sb);
	}
	// 1이면 시계방향, -1이면 반시계방향 
	// N극이 0, S극이 1
	static void left(int num, int dir) {
		if (num <= 0) return;
		int tdir = dir;
		if (chain[num+1][6] != chain[num][2]) {
			tdir = dir * -1;
			left(num-1,tdir);
			rotate(num,tdir);
		} else return;
	}
	static void right(int num, int dir) {
		if (num >=5) return;
		int tdir = dir;
		if (chain[num-1][2] != chain[num][6]) {
			tdir = dir * -1;
			right(num+1,tdir);
			rotate(num,tdir);
		} else return;
	}
	static void rotate(int num, int dir) {
		if (dir == 1) {
			int tmp = chain[num][7];
			for (int i = 7; i > 0; i--) {
				chain[num][i] = chain[num][i-1];
			}
			chain[num][0] = tmp;
		} else {
			int tmp = chain[num][0];
			for (int i = 0; i < 7; i++) {
				chain[num][i] = chain[num][i+1];
			}
			chain[num][7] = tmp;
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
