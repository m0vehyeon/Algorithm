package com.ssafy.swea;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_d2_1954_달팽이숫자_구미_4_이동현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			System.out.println("#" + (t+1));
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int num = 2*N - 1;
			int[] narr = new int[num];
			narr[0] = N;
			int count = 0;
			for (int i = 1; i < num; i++) {
				narr[i] = N-1;
				count++;
				if(count==2) {
					count = 0;
					N--;
				}
			}
			//우,하,좌,상
			int[] dx = {0,1,0,-1};
			int[] dy = {1,0,-1,0};
			int x = 0;
			int y = 0;
			for (int i = 0; i < narr.length; i++) {
				if (i == 0) {
					for (int j = 0; j < narr[i]-1;j++) {
						arr[x][y] = count+1;
						x=x+dx[i%4];
						y=y+dy[i%4];
						count++;
					}
				} else {
					for (int j = 0; j < narr[i];j++) {
						arr[x][y] = count+1;
						x=x+dx[i%4];
						y=y+dy[i%4];
						count++;
					}
				}
				arr[x][y] = count+1;
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
		}
		
}
