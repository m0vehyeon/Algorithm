package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Solution_bj_3052_나머지_구미4반_이동현 {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_bj_3052.txt"));
		Scanner sc = new Scanner(System.in);
		
		HashSet<Integer> set = new HashSet<Integer>(10);
		int T = 10;
		int count = 0;
		for (int i = 0; i < T; i++) {
			if (set.add(sc.nextInt() % 42)) count++;
		}
		System.out.println(count);
	}

}
