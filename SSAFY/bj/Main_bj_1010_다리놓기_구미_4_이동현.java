package com.ssafy.bj;

import java.math.BigInteger;
import java.util.Scanner;
public class Main_bj_1010_다리놓기_구미_4_이동현 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int tM = M;
			int tN = M - N;
			BigInteger mom = new BigInteger("1");
			BigInteger son = new BigInteger("1");
			if (N == M) {
				System.out.println(1);
				continue;
			}
			for (int i = 0; i < M - N; i++) {
				mom = mom.multiply(BigInteger.valueOf(tM--));
				son = son.multiply(BigInteger.valueOf(tN--));
			}
			
			System.out.println(mom.divide(son));
		}
	}
}
