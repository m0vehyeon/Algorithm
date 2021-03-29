package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_12871_무한문자열_구미_4_이동현 {
	static String a,b;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = br.readLine();
		b= br.readLine();
		
		StringBuilder asb = new StringBuilder();
		StringBuilder bsb = new StringBuilder();
		while (asb.length() < 100) {
			asb.append(a);
		}
		while (bsb.length() < 100) {
			bsb.append(b);
		}
		if (asb.substring(0, 100).equals(bsb.substring(0, 100))) System.out.println(1);
		else System.out.println(0);
	}

}
