package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_d3_6808_규영이와인영이의카드게임_구미_4_이동현 {
	static int[] input, nums ,comp;
	static boolean[] check;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_6808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = stoi(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			input = new int[9];
			nums = new int[9];
			comp = new int[9];
			check = new boolean[19];
			for (int i = 0; i< 9; i++) {
				int num = stoi(st.nextToken());
				input[i] = num;
				check[num] = true;
			}
			int j = 0;
			for (int i = 1; i<=18;i++) {
				if (!check[i]) comp[j++] = i;
			}
			int win = 0;
			int lose = 0;
			do {
				int sum1 = 0;
				int sum2 = 0;
				for (int i = 0; i < 9; i++) {
					if (comp[i] > input[i]) sum2+=(comp[i] + input[i]);
					else if (comp[i] < input[i]) sum1 +=(comp[i] + input[i]);
				}
				if (sum1 > sum2) win+=1;
				else if (sum1 < sum2) lose +=1;
			} while(np());
			System.out.println("#" + t + " " + win + " " + lose);
		}
	}
	public static boolean np() {
		int i = 8;
		while (i > 0 && comp[i-1]>=comp[i]) --i;
		if (i == 0) return false;
		
		int j = 8;
		while(comp[i-1] >= comp[j]) --j;
		swap(i-1, j);
		
		int k = 8;
		while(i < k) swap(i++,k--);
		return true;
	}
	
	private static void swap(int i, int j) {
		int tmp = comp[i];
		comp[i] = comp[j];
		comp[j] = tmp;
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
