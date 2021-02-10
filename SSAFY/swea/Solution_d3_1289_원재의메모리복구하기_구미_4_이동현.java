package com.ssafy.swea;

import java.util.*;
import java.io.*;
public class Solution_d3_1289_원재의메모리복구하기_구미_4_이동현 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1289.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			char[] arr = br.readLine().toCharArray();
			char[] tmp = new char[arr.length];
			for (int i = 0; i < tmp.length; i++) {
				tmp[i] = '0';
			}
			int cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] != tmp[i]) {
					for (int j = i; j < arr.length; j++) {
						if (arr[j] == '1') arr[j] ='0';
						else arr[j] = '1';
					}
					cnt++;
				}
			}
			bw.write("#"+ (tc+1) + " " + cnt + "\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
}
