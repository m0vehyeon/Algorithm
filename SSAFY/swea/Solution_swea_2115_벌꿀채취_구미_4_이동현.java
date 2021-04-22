package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_swea_2115_벌꿀채취_구미_4_이동현 {
	static int N, M, C, max;
	static int[][] map;
	
	static int[] lNums;
	static int[] sNums;
	static boolean[] sCheck;
	
	static ArrayList<int[]> lList;
	static ArrayList<int[]> sList;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_swea_2115.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = stoi(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken()); M = stoi(st.nextToken());
			C = stoi(st.nextToken());
			map = new int[N][N];
			lList = new ArrayList<>();
			max = Integer.MIN_VALUE;
			lNums = new int[2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0 ; j< N; j++) {
					map[i][j] = stoi(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					lList.add(new int[] {i,j});
				}
			}
			combi(0,0);
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
	static void subset(int idx, int size) {
		if (idx == size) {
			int fcheck = 0;
			int scheck = 0;
			int sum = 0;
			for (int i = 0; i < size; i++) {
				if (sCheck[i]) {
					if (i%2==0) fcheck += map[sList.get(i)[0]][sList.get(i)[1]];
					else scheck += map[sList.get(i)[0]][sList.get(i)[1]];
					sum += map[sList.get(i)[0]][sList.get(i)[1]] * map[sList.get(i)[0]][sList.get(i)[1]];
				}
				if (fcheck > C || scheck > C) return;
			}
			max = Math.max(sum, max);
			return;
		}
		sCheck[idx] = true;
		subset(idx+1, size);
		
		sCheck[idx] = false;
		subset(idx+1, size);
	}
	static void combi(int idx, int start) {
		if (idx == 2) {
			sList = new ArrayList<>();
			if (!check(lNums)) return;
			int size = sList.size();
			sCheck = new boolean[size];
			subset(0, size);
			return;
		}
		for (int i = start; i < lList.size(); i++) {
			lNums[idx] = i;
			combi(idx+1, i + 1);
		}
	}

	static boolean check(int[] nums) {
		ArrayList<int[]> first = new ArrayList<>();
		ArrayList<int[]> second = new ArrayList<>();
		
		int[] f = lList.get(nums[0]);
		int[] s = lList.get(nums[1]);
		for (int i = 0; i < M; i++) {
			first.add(new int[] {f[0], f[1] + i});
			second.add(new int[] {s[0], s[1] + i});
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if (first.get(i)[0] == second.get(j)[0] && first.get(i)[1] == second.get(j)[1]) return false;
			}
		}
		
		for (int i = 0; i < M; i++) {
			sList.add(first.get(i));
			sList.add(second.get(i));
		}
		return true;
	} 
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
