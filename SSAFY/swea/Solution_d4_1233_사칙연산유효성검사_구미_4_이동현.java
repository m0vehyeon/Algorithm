package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_d4_1233_사칙연산유효성검사_구미_4_이동현 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr;
		StringTokenizer st;
		loop: for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new String[N+1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[Integer.parseInt(st.nextToken())] = st.nextToken();
			}
			if (N % 2 == 0) {
				System.out.println("#" + t + " " + 0);
				continue loop;
			}
			try {
				for (int i = N; i >=3; i-=2) {
					int v;
					if (arr[i/2].equals("+")) {
						v =  Integer.parseInt(arr[i-1]) + Integer.parseInt(arr[i]);
						arr[i/2] = Integer.toString(v);
					} else if (arr[i/2].equals("-")) {
						v =  Integer.parseInt(arr[i-1]) - Integer.parseInt(arr[i]);
						arr[i/2] = Integer.toString(v);
					} else if (arr[i/2].equals("*")) {
						v =  Integer.parseInt(arr[i-1]) * Integer.parseInt(arr[i]);
						arr[i/2] = Integer.toString(v);
					} else if (arr[i/2].equals("/")) {
						v =  Integer.parseInt(arr[i-1]) / Integer.parseInt(arr[i]);
						arr[i/2] = Integer.toString(v);
					} else {
						System.out.println("#" + t + " " + 0);
						continue loop;
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("#" + t + " " + 0);
				continue loop;
			}
			System.out.println("#" + t + " " + 1);
		}
	}
}
