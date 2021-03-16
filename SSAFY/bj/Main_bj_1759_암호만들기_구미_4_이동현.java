package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_1759_암호만들기_구미_4_이동현 {
	static int L, C;
	static char[] alphas,result;
	static boolean[] visited;
	static char[] check = {'a', 'e','i','o','u'};
    static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alphas = new char[C];
		result = new char[L];
		sb = new StringBuilder();
		visited = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++)  alphas[i] = st.nextToken().charAt(0);
		Arrays.sort(alphas);
		combi(0, 0);
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	static void combi(int cnt, int idx) {
		if (cnt == L) {
			int a = 0;
			int b = 0;
			for (int i = 0; i < L; i++) {
				if (isMoum(result[i])) a++;
				else b++;
			}
			if (a>=1 && b>=2) for(char c : result) sb.append(c);
			else return;
			sb.append("\n");
			return;
		}
		for (int i = idx; i < C; i++) {
			result[cnt] = alphas[i];
			combi(cnt+1, i+1);
		}
	}
	static boolean isMoum(char s) {
		for (int i = 0; i < 5; i++) {
			if (s == check[i]) return true;
		}
		return false;
	}
}
