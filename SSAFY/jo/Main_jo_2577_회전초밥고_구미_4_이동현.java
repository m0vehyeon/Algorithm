package com.ssafy.jo;

import java.util.*;
import java.io.*;

public class Main_jo_2577_회전초밥고_구미_4_이동현 {
	static int N, d, k, c, max, kind;
	static int[] dp;
	static int[] check;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); d = stoi(st.nextToken());
		k = stoi(st.nextToken()); c = stoi(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = stoi(br.readLine());
		}
		max = Integer.MIN_VALUE;
		dp = new int[N];
		check = new int[d+1];
		
		for (int i = 0; i < k; i++) {
			if(check[arr[i]]==0) kind++; 
			check[arr[i]]+=1;
		}
		if (check[c] == 0) max = Math.max(max, kind+1);
		else max = Math.max(max, kind);
		
		
		for (int i = k; i < N+k-1; i++) {
			int cnt = 0;
			if(--check[arr[i-k]] == 0) {
				kind--;
			}
			if (check[arr[i%N]] == 0) {
				kind++;
			}
			check[arr[i%N]]++;
			if (check[c] == 0) cnt++;
			cnt += kind;
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
