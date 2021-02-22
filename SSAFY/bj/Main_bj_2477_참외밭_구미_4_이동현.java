package com.ssafy.bj;

import java.util.*;
import java.io.*;
public class Main_bj_2477_참외밭_구미_4_이동현 {
	static int[] vec;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int bigSquare = 1;
		int K = sc.nextInt();
		int maxW = 0, maxH = 0;
		int maxWi = 0, maxHi = 0;
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < 6;i++) {
			int tvec = sc.nextInt();
			int length = sc.nextInt();
			list.add(new int[] {tvec,length});
			if (tvec == 1 || tvec == 2) {
				if (maxW < length) {
					maxW = length;
					maxWi = i;
				}
			}
			else if (tvec == 3 || tvec == 4) {
				maxH = Math.max(length, maxH);
				if (maxH < length) {
					maxH = length;
					maxHi = i;
				}
			}
		}
		int minH, minW;
		if (maxHi == 0) {
			minW = Math.abs(list.get(5)[1] - list.get(1)[1]);
		} else if (maxHi == 5) {
			minW = Math.abs(list.get(4)[1] - list.get(0)[1]);
		} else {
			minW = Math.abs(list.get(maxHi + 1)[1] - list.get(maxHi - 1)[1]);
		}
		if (maxWi == 0) {
			minH = Math.abs(list.get(5)[1] - list.get(1)[1]);
		} else if (maxWi == 5) {
			minH = Math.abs(list.get(4)[1] - list.get(0)[1]);
		} else {
			minH = Math.abs(list.get(maxWi + 1)[1] - list.get(maxWi - 1)[1]);
		}
		System.out.println(((maxH*maxW) - (minH * minW)) * K);
		
	}

}
