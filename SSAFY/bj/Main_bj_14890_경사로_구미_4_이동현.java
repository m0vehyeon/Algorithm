package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_14890_경사로_구미_4_이동현 {
	static int T, N, X, result;
	static int[][] map, tmap;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		result = 0;
		N = stoi(st.nextToken());
		X = stoi(st.nextToken());
		map = new int[N][N];
		tmap = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				tmap[j][i] = map[i][j] = stoi(st.nextToken());
			}
		}
		for (int k = 0; k < N; k++) {
			if (check(map[k])) result++;
			if (check(tmap[k])) result++;
		}
		System.out.println(result);
	}

	static boolean check(int[] arr) {
		int j = 0, cnt = 0, prev = arr[j];
		
		while (j < N) {
			if (prev == arr[j]) {
				cnt++;
				j++;
			}
			else if (prev + 1 == arr[j]) {
				if (cnt < X) return false;
				prev++;
				cnt = 1;
				j++;
			} else if (prev - 1 == arr[j]) {
				int tc = 0;
				for (int k = j; k < N; k++) {
					if (arr[k] != prev - 1) break;
					if (++tc == X) break;
				}
				if (tc < X) return false;
				prev--;
				cnt = 0;
				j += tc;
			}else return false;
		}
		
		return true;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
