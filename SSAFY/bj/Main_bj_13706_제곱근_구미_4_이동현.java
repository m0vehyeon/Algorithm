package com.ssafy.bj;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main_bj_13706_제곱근_구미_4_이동현 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sqrt(br.readLine());
	}
	
	static void sqrt(String num) {
		BigInteger one = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		
		BigInteger n = new BigInteger(num);
		
		BigInteger left = new BigInteger("1");
		BigInteger right = new BigInteger(num);
		
		BigInteger mid = left.add(right).divide(two);
		
		while (left.compareTo(right) <= 0) {
			mid = left.add(right).divide(two);
			
			int c = mid.multiply(mid).compareTo(n);
			if (c == 0) {
				System.out.println(mid);
				return;
			} else if (c < 0) {
				left = mid.add(one);
			} else {
				right = mid.subtract(one);
			}
		}
	}

}
