package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_2493_탑_구미_4_이동현 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<int[]> tower = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(st.nextToken());
			while(!tower.isEmpty()) {
				if (tower.peek()[0] >= height) {
					sb.append(tower.peek()[1]+1).append(" ");
					break;
				}
				tower.pop();
			}
			if (tower.isEmpty()) sb.append(0).append(" ");
			tower.add(new int[] {height,i});
		}
		System.out.println(sb);
		br.close();
	}
}
