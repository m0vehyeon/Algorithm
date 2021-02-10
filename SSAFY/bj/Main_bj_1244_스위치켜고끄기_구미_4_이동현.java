package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_1244_스위치켜고끄기_구미_4_이동현 {
	static int num, stu;
	static int[] stat;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt() + 1;
		stat = new int[num];
		
		for (int i = 1; i < num; i++) {
			stat[i] = sc.nextInt();
		}
		
		stu = sc.nextInt();
		for (int i = 1; i <= stu; i++) {
			int sex = sc.nextInt();
			int key = sc.nextInt();
			
			if (sex == 1) {
				for (int j = key; j < num; j+=key) {
					stat[j]^=1;
				}
			} else  {
				int left = key - 1;
				int right = key + 1;
				
				while (true) {
					if (left < 1 || right >= num) break;
					if (stat[left] != stat[right]) {
						break;
					}
					left--;
					right++;
				}
				left++;
				right--;
				while(left<=right) {
					stat[left]^=1;
					left++;
				}
			}
		}
		for (int j = 1; j< num; j++) {
			System.out.print(stat[j] + " ");
			if(j%20 == 0) System.out.println();
		}
		
	}

}
