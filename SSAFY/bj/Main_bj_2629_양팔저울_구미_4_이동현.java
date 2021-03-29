package com.ssafy.bj;
import java.util.*;
import java.io.*;
public class Main_bj_2629_양팔저울_구미_4_이동현 {
	static int chu, ball;
	static int[] cWeight, bWeight;
	static boolean[][] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		chu = stoi(br.readLine());
		cWeight = new int[chu]; // 추의 무게 배열
		check = new boolean[chu+1][40001]; // 나올 수 있는 무게 배열 체크
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < chu; i++) cWeight[i] = stoi(st.nextToken()); // 추 입력
		
		ball = stoi(br.readLine());
		bWeight = new int[ball];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < ball; i++) bWeight[i] = stoi(st.nextToken()); // 구슬 입력

		dfs(0,0); // 부분집합

		for (int b : bWeight) { // check 배열에서 true인지 확인하고 맞으면 Y 아니면 N
			if (check[chu][b]) sb.append("Y" + " ");
			else sb.append("N" + " ");
		}
		System.out.println(sb);
		
	}
	static void dfs(int cnt, int w) {
		if (check[cnt][w]) return;
		check[cnt][w] = true;
		
		if (cnt == chu) return;
		
		dfs(cnt+1, w + cWeight[cnt]);
		dfs(cnt+1, w);
		dfs(cnt+1, Math.abs(w - cWeight[cnt]));
	}
	

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
