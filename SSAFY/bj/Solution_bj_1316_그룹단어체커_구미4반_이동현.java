package com.ssafy.bj;
import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_bj_1316_그룹단어체커_구미4반_이동현 {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input_bj_1316.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int count = T;
		for (int i = 0; i < T; i++) {
			String word = sc.next();
			for (int j = 1; j < word.length(); j++) {
				if (word.indexOf(word.charAt(j - 1)) > word.indexOf(word.charAt(j))) {
					count--;
					break;
				}
			}
		}
		System.out.println(count);
	}
}
