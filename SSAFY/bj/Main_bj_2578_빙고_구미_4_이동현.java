package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_2578_빙고_구미_4_이동현 {
	static int[][] map;
	static boolean[][] check;
	static int[] com;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];
		com = new int[25];
		check = new boolean[5][5];
		int res = 0;
		for (int i = 0 ; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		int k = 0;
		for (int i = 0 ; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				com[k++] = stoi(st.nextToken());
			}
		}
		outer:for (int i = 0; i < 25; i++) {
			inner:for (int p = 0; p < 5; p++) {
				for (int q = 0; q < 5; q++) {
					if (map[p][q] == com[i]) {
						check[p][q] = true;
						if (checkBingo() >= 3){
							res = i+1;
							break outer;
						}
						break inner;
					}
					
				}
			}
		}
		System.out.println(res);
	}
	static int checkBingo() {
		int bingo = 0;
		for (int i = 0; i < 5; i++) {
			boolean flag = true;
			for (int j = 0; j <5; j++) {
				if (!check[i][j]) flag = false;
			}
			if (flag) bingo++;
		}
		for (int i = 0; i < 5; i++) {
			boolean flag = true;
			for (int j = 0; j <5; j++) {
				if (!check[j][i]) flag = false;
			}
			if (flag) bingo++;
		}
		boolean flag = true;
		for (int i = 0; i < 5; i++) if(!check[i][i]) flag = false;
		if (flag) bingo++;
		boolean flag2 = true;
		for (int i = 0; i< 5; i++) if(!check[i][4-i]) flag2 = false;
		if (flag2) bingo++;
		return bingo;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
