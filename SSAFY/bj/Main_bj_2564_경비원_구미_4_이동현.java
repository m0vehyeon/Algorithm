package com.ssafy.bj;

import java.util.*;
import java.io.*;
public class Main_bj_2564_경비원_구미_4_이동현 {
	static int X, Y, N, min;
	static int[][] shops;
	static int[] home;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = stoi(st.nextToken());
		Y = stoi(st.nextToken());
		N = stoi(br.readLine());
		shops = new int[N][2];
		home = new int[2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			shops[i][0] = stoi(st.nextToken());
			shops[i][1] = stoi(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		home[0] = stoi(st.nextToken()); home[1] = stoi(st.nextToken());
		
		switch(home[0]) {
		case 1:
			for (int i = 0; i < N; i++) {
				int left = 0, right = 0, result = 0;
				switch(shops[i][0]) {
				case 1:
					result = Math.abs(home[1] - shops[i][1]);
					break;
				case 2:
					left = home[1]+ Y + shops[i][1];
					right = (X-home[1]) + Y + (X-shops[i][1]);
					result = Math.min(left,right);
					break;
				case 3:
					result = home[1] + shops[i][1];
					break;
				case 4:
					result = (X-home[1]) + shops[i][1];
					break;
				}
				min += result;
			}
			break;
		case 2:
			for (int i = 0; i < N; i++) {
				int left = 0, right = 0, result = 0;
				switch(shops[i][0]) {
				case 1:
					left = home[1]+ Y + shops[i][1];
					right = (X-home[1]) + Y + (X-shops[i][1]);
					result = Math.min(left,right);
					break;
				case 2:
					result = Math.abs(home[1] - shops[i][1]);
					break;
				case 3:
					result = home[1] + (Y-shops[i][1]);
					break;
				case 4:
					result = (X-home[1]) + (Y-shops[i][1]);
					break;
				}
				min += result;
			}
			break;
		case 3:
			for (int i = 0; i < N; i++) {
				int left = 0, right = 0, result = 0;
				switch(shops[i][0]) {
				case 1:
					result = home[1] + shops[i][1];
					break;
				case 2:
					result = (Y-home[1]) + shops[i][1];
					break;
				case 3:
					result = Math.abs(home[1] - shops[i][1]);
					break;
				case 4:
					left = home[1]+ X + shops[i][1];
					right = (Y-home[1]) + X + (Y-shops[i][1]);
					result = Math.min(left,right);
					break;
				}
				min += result;
			}
			break;
		case 4:
			for (int i = 0; i < N; i++) {
				int left = 0, right = 0, result = 0;
				switch(shops[i][0]) {
				case 1:
					result = home[1] + (X-shops[i][1]);
					break;
				case 2:
					result = (Y-home[1]) + (X-shops[i][1]);
					break;
				case 3:
					left = home[1]+ X + shops[i][1];
					right = (Y-home[1]) + X + (Y-shops[i][1]);
					result = Math.min(left,right);
					break;
				case 4:
					result = Math.abs(home[1] - shops[i][1]);
					break;
				}
				min += result;
			}
			break;
		}
		System.out.println(min);
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
