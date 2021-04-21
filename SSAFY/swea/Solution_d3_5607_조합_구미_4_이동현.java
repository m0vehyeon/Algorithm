package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_d3_5607_조합_구미_4_이동현 {
	static int N,R;
	static final long P = 1234567891;
	static long[] fac = new long[1000001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		fac[0] = 1;
		for (int i = 1; i <=1000000; i++) {
			fac[i] = (fac[i-1] * i) % P;
		}
		for (int t = 1; t<= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken()); R = stoi(st.nextToken());
			
			long left = fac[N];
			long right = ((fac[N-R]) * (fac[R])) % P;
			right = pow(right,P-2);
			System.out.println("#" + t + " " + (left*right)%P);
		}
	}
	static long pow(long a, long b) {
		if (b == 0) return 1;
		else {
			if (b%2 == 0) {
				long temp = pow(a,b/2);
				return (temp * temp) % P;
			} else {
				long temp = pow(a,b-1)%P;
				return (temp * a) % P;
			}
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
