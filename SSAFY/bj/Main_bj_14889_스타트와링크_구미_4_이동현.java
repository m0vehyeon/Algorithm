package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_14889_스타트와링크_구미_4_이동현 {
	static int N, min = Integer.MAX_VALUE, linkSum,startSum;
	static int map[][];
	static int startT[];
	static boolean visited[];
	static int nums[];
	static List<Integer> link;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		
		map = new int[N][N];
		startT = new int[N/2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		combi(0,1);
		System.out.println(min);
	}
	
	static void combi(int cnt, int start) {
		if (cnt == N/2) {
			linkSum = 0;
			startSum = 0;
			link = new ArrayList<>();
			boolean[] check = new boolean[N+1];
			for (int a : startT) check[a] = true;
			for (int i = 1; i <= N; i++) {
				if (!check[i]) link.add(i);
			}
			visited = new boolean[N/2];
			nums = new int[2];
			permu(0, 1);
			nums = new int[2];
			visited = new boolean[N/2];
			permu(0, 2);
			min = Math.min(Math.abs(startSum - linkSum), min);
			return;
		}
		for (int i = start; i <= N; i++) {
			startT[cnt] = i;
			combi(cnt+1, i+1);
		}
	}
	static void permu(int cnt, int team) {
		if (cnt == 2) {
			if (team == 1) startSum+=map[nums[0]-1][nums[1]-1];
			else linkSum+=map[nums[0]-1][nums[1]-1];
			return;
		}
		for (int i = 0; i < N/2; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			if (team == 1) nums[cnt] = startT[i];
			else nums[cnt] = link.get(i);
			permu(cnt+1, team);
			visited[i] = false;
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
