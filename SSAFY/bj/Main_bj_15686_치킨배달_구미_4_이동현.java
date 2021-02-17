package com.ssafy.bj;

import java.util.*;
import java.io.*;

//1. 치킨집 중에 M 개 고르기
//2. M개의 케이스를 돌면서
//3. 각 집을 돌며 치킨거리 계산 => 최소값 초기화

public class Main_bj_15686_치킨배달_구미_4_이동현 {
	static int[][] arr;
	static List<int[]> chickens, homes;
	static int[] nums;
	static int N,M;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		arr = new int[N+1][N+1];
		chickens = new ArrayList<>();
		homes = new ArrayList<>();
		nums = new int[M];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = stoi(st.nextToken());
				if (arr[i][j] == 2) chickens.add(new int[] {i,j});
				else if (arr[i][j] == 1) homes.add(new int[] {i,j});
			}
		}
		combi(0,0);
		System.out.println(min);
		
	}
	static void combi(int cnt, int start) {
		if (cnt == M) {
			search(nums);
			return;
		}
		for (int i = start; i< chickens.size(); i++) {
			nums[cnt] = i;
			combi(cnt+1, i+1);
		}
		
	}
	static void search(int[] num) {
		int sum = 0;
		for (int h = 0; h < homes.size(); h++) {
			int tmin = Integer.MAX_VALUE;
			int dist = 0;
			for (int n = 0; n < nums.length; n++) {
				dist= Math.abs(chickens.get(num[n])[0] - homes.get(h)[0]) + Math.abs(chickens.get(num[n])[1] - homes.get(h)[1]);
				if (tmin > dist) tmin = dist;
			}
			sum += tmin;
		}
		if ( min > sum){
			min = sum;
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
