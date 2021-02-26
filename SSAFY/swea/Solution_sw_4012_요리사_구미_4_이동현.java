package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_sw_4012_요리사_구미_4_이동현 {
	static int N, taste1, taste2, min = Integer.MAX_VALUE;
	static int[][] tastes;
	static boolean[] check,visit;
	static List<Integer> gr1,gr2;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_sw_4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = stoi(br.readLine());
		for (int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;
			N = stoi(br.readLine());
			tastes = new int[N][N];
			check = new boolean[N+1];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) tastes[i][j] = stoi(st.nextToken());
			}
			combi(0,1);
//			for (int[] a :tastes) System.out.println(Arrays.toString(a));
			System.out.println("#" + t + " " + min);
		}
	}
	static void combi(int cnt, int start) {
		if (cnt == N/2) {
			int[] nums1 = new int[2];
			int[] nums2 = new int[2];
			gr1 = new ArrayList<>();
			gr2 = new ArrayList<>();
			visit = new boolean[N/2];
			for (int i = 1; i <= N; i++) {
				if (check[i]) gr1.add(i);
				else gr2.add(i);
			}
/*			for (int a : gr1) System.out.print(a + " ");
			System.out.println();
			for (int a : gr2) System.out.print(a + " ");
			System.out.println();*/
			taste1 = 0;
			taste2 = 0;
			permu(0, nums1,gr1);
			permu(0, nums2,gr2);
//			System.out.println(taste1 + " " + taste2 + " " + (Math.abs(taste1 - taste2)));
			min = Math.min(min, Math.abs(taste1 - taste2));
			
			return;
		}
		for (int i = start; i <= N; i++) {
			check[i] = true;
			combi(cnt+1, i + 1);
			check[i] = false;
		}
	}
	static void permu(int cnt, int[] nums, List<Integer> gr) {
		if (cnt == 2) {
//			System.out.println(Arrays.toString(nums) + "pp");
			if (gr == gr1) taste1 += tastes[nums[0]-1][nums[1]-1];
			else taste2 += tastes[nums[0]-1][nums[1]-1];
			return;
		}
		for (int i = 0; i < gr1.size(); i++) {
			if (visit[i]) continue;
			nums[cnt] = gr.get(i);
			visit[i] = true;
			permu(cnt+1, nums,gr );
			visit[i] = false;
			
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
