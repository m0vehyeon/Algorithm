package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_1074_Z_구미_4_이동현 {
	static int N,r,c,cnt;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		int size = 1<<N;
		search(0,0,size);
	}
	public static void search(int x, int y, int size) {
		if(flag) return;
		if (size == 1 ) {
			if(x == r && y == c) {
				System.out.println(cnt);
				flag = true;
			}
			cnt += 1;
			return;
		}
		if (x <= r && r < (x + size) && y <= c && c < (y + size)) {
			int t = size/2;
			search(x, y, t);
			search(x, y + t, t);
			search(x + t, y, t);
			search(x + t, y + t, t);
		} else cnt += size * size;
	}
}
