package com.ssafy.swea;
import java.util.*;
import java.io.*;

class Solution_d1_1545_거꾸로출력해보아요_구미4반_이동현 {
	public static void main(String args[]) throws Exception {
	
		System.setIn(new FileInputStream("res/input_d1_1545.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = T; tc >= 0 ; tc--) {
			System.out.print(tc + " ");
		}
		sc.close();
	}
}