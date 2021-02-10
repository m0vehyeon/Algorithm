package com.ssafy.swea;
import java.io.*;
import java.util.*;

public class Solution_d1_2072_홀수만더하기_구미4반_이동현 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d1_2072.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc=1; tc<=T; tc++)
		{
			int sum = 0;
			for (int j = 0; j < 10; j++)
			{
				int num = sc.nextInt();
				if (num % 2 == 1) {
					sum += num;
				}
			}
			
			System.out.println("#"+tc+" " + sum);
		}
		sc.close();
	}
}
