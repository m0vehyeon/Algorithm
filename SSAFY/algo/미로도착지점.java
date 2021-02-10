package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class 미로도착지점 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	//상 우 하 좌
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/미로도착지점.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt(); //배열크기
			int[][] arr = new int[N+1][N+1]; //미로
			
			int x = sc.nextInt(); //시작 x좌표
			int y = sc.nextInt(); //시작 y좌표
			int jumper = sc.nextInt(); //점퍼 개수
			
			for (int j = 0; j < jumper;j++) {
				int jx = sc.nextInt(); //점퍼 x좌표
				int jy = sc.nextInt(); //점퍼 y좌표
				arr[jx][jy] = 1;
			}
//			for (int[] v : arr ) System.out.println(Arrays.toString(v));
			int com = sc.nextInt(); // 이동지시 개수
			loop:for (int c = 0; c < com; c++) {
				int vec = sc.nextInt();
				int num = sc.nextInt();
				for (int n = 0; n < num; n++) {
					int nx = x + (dx[vec - 1]);
					int ny = y + (dy[vec - 1]);
					if (1 <= nx && nx < N && 1 <= ny && ny < N && arr[nx][ny] != 1) {
						x = nx;
						y = ny;
					} else {
						x = 0;
						y = 0;
						break loop;
					}
				}
			}
			System.out.println("#" + (t+1) + " " + x + " " + y);
			
		}
	}

}
