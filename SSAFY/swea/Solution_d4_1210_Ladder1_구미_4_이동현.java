package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_d4_1210_Ladder1_구미_4_이동현 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_d4_1210.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = 10;
		String[][] arr = new String[100][100];
		
		for (int t = 0; t < tc; t++) {
			int num = Integer.parseInt(br.readLine());
			for (int i = 0; i < 100; i++) {
				arr[i] = br.readLine().split(" ");
			}
			for(int y = 0; y < 100; y++) {
				if(arr[0][y].equals("1")) {
					int ty = y;
					for (int x = 0; x < 100; x++) {
						boolean check = true;
						if (arr[x][ty].equals("2")) System.out.println("#" + num + " " + y);
						if (ty <99 && arr[x][ty+1].equals("1")) {
							for (int i = ty+1; i <100; i++) {
								if (check && x < 99 && arr[x+1][i].equals("1")) {
									ty = i;
									check = false;
									break;
								}
							}
						} else if (ty > 0 && arr[x][ty-1].equals("1")) {
							for (int j = ty-1; j >= 0; j--) {
								if (check &&x < 99&& arr[x+1][j].equals("1")) {
									ty = j;
									check = false;
									break;
								}
							}
						}
						
					}
				}
			}
		}
	}

}
