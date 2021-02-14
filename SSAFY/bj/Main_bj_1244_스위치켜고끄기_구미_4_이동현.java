package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_1244_스위치켜고끄기_구미_4_이동현 {
	static int num, stu;
	static int[] swit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt() + 1;
		swit = new int[num];
		
		for (int i = 1; i < num; i++) {
			swit[i] = sc.nextInt();
		}
		stu = sc.nextInt();
		for (int i = 1; i <= stu; i++) {
			int sex = sc.nextInt();
			int key = sc.nextInt();
			
			if (sex == 1) {
				for (int j = key; j < num; j++) {
					if (j % key == 0) change(j);
				}
			}
			else {
				int n = 1;
				change(key);
				while (n < swit.length/2) {
					if (key + n < swit.length && key - n >= 1 && swit[key+n] == swit[key - n]) {
						change(key+n);
						change(key-n);
					} else break;
					n++;
				}
			}
		}
		for (int i = 1; i < swit.length;i++) {
			System.out.print(swit[i] + " ");
			if (i%20 == 0) System.out.println();
		}
	}
	static void change(int idx) {
		if (swit[idx] == 0) swit[idx] = 1;
		else swit[idx] = 0;
	}
}
