package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_16953_AB_구미_4_이동현 {
	static long start,dest,result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = stol(st.nextToken());
		dest = stol(st.nextToken());
		
		dfs(start, 0);
		if (result == 0) System.out.println(-1);
		else System.out.println(result);
	}
	static void dfs(long n, long cnt) {
		if (n == dest) {
			result = cnt+1;
			return;
		}
		if (n > dest) {
			return;
		}
		dfs(n * 2, cnt+1);
		dfs(n *10 + 1 , cnt+1);
	}
	static long stol(String s) {
		return Long.parseLong(s);
	}

}
