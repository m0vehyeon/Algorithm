package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_3040_백설공주와일곱난쟁이_구미_4_이동현 {
	static int[] input;
	static int[] nums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = new int[9];
		nums = new int[7];
		for (int i = 0; i < 9; i++) {
			input[i] = sc.nextInt();
		}
		combi(0,0);
	}
	public static void combi(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) sum += nums[i];
			if (sum == 100) {
				for (int i = 0; i < 7; i++) System.out.println(nums[i]);;
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			nums[cnt] = input[i];
			combi(cnt+1,i+1);
		}
	}
}
