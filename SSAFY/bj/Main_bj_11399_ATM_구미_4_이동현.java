package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_11399_ATM_구미_4_이동현 {
	static int N;
	static int[] people;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		int result = 0;
		people = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			people[i] = stoi(st.nextToken());
		}
		
		Arrays.sort(people);
		for (int i = 1; i< N; i++) people[i] = people[i-1] + people[i];
		for (int a : people) result += a;
		System.out.println(result);
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
