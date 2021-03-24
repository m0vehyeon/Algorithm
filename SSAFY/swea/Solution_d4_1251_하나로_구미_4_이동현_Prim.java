package com.ssafy.swea;

import java.util.*;
import java.io.*;
public class Solution_d4_1251_하나로_구미_4_이동현_Prim {
	static int N;
	static long[][] location;
	static long[][] weight;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1251.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		for (int t = 1; t<=T; t++) {
			N = stoi(br.readLine());
			double E = 0;
			
			long[] minEdge = new long[N];
			boolean[] visited = new boolean[N];
			location = new long[N][2];
			weight = new long[N][N];
			StringTokenizer st = null;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				location[i][0] = stoi(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				location[i][1] = stoi(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					if (i != j) {
						long dist = ((location[i][0] - location[j][0])*(location[i][0] - location[j][0]))
								+ ((location[i][1] - location[j][1])*(location[i][1] - location[j][1]));
						weight[i][j] = dist;
						weight[j][i] = dist;
					}
				}
				minEdge[i] = Long.MAX_VALUE;
				visited[i] = false;
			}
			minEdge[0] = 0;
			long result = 0;
			
			for (int i = 0; i < N; i++) {
				long min = Long.MAX_VALUE;
				int minIdx = 0;
				
				for (int j = 0; j < N; j++) {
					if (!visited[j] && min > minEdge[j]) {
						min = minEdge[j];
						minIdx = j;
					}
				}
				visited[minIdx] = true;
				result += min;
				
				for (int j = 0; j < N; j++) {
					if (!visited[j] && weight[minIdx][j] != 0 && minEdge[j] > weight[minIdx][j]) {
						minEdge[j] = weight[minIdx][j];
					}
				}
			}
			
			sb.append("#" + t + " " + Math.round(E * result)+ "\n");
		}
		System.out.println(sb);
	}
	static Long stol(String s ) {
		return Long.parseLong(s);
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
