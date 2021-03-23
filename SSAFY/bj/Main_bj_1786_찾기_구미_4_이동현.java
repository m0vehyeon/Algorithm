package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_1786_찾기_구미_4_이동현 {
	static char[] text,pattern;
	static int[] fail;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		text = br.readLine().toCharArray();
		pattern = br.readLine().toCharArray();
		int tLen = text.length;
		int pLen = pattern.length;
		fail = new int[pLen];
		fail[0] = 0;
		int cnt = 0;
		ArrayList<Integer> index = new ArrayList<>();
		
		for (int i = 1, j = 0; i < pLen; i++) {
			while (j > 0 && pattern[i]!=pattern[j]) {
				j = fail[j-1];
			}
			if (pattern[i] == pattern[j]) fail[i] = ++j;
		}
		
		for (int i = 0, j = 0; i < tLen; i++) {
			while (j > 0 && text[i] != pattern[j]) j = fail[j-1];
			if (text[i] == pattern[j]) {
				if (j == pLen-1) {
					cnt++;
					index.add((i+1) - pLen + 1);
					j = fail[j];
				} else j++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt + "\n");
		for(int a : index) sb.append(a + " ");
		System.out.println(sb);
	}
}
