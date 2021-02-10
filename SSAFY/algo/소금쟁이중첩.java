package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class 소금쟁이중첩 {
	private static int[] dx = {0,1,0};
	private static int[] dy = {0,0,1};
	// 하 우
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int count = 0;
			int N = sc.nextInt();
			int salt_num = sc.nextInt();
			int[][] pond = new int[N][N];
			int[][] salt = new int[salt_num][3];
			
			for (int i = 0; i < salt_num; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int vec = sc.nextInt();
				if (pond[x][y] == 1) continue;
				pond[x][y] = 1;
				salt[i][0] = x;
				salt[i][1] = y;
				salt[i][2] = vec;
			}
			//for (int[] z : salt) System.out.println(Arrays.toString(z));
			int check = 0;
			loop:for (int j = 0; j < salt.length; j++) {
				for (int k = 3; k > 0; k--) {
					
					int nx = salt[j][0] + dx[salt[j][2]] * k;
					int ny = salt[j][1] + dy[salt[j][2]] * k;
					if (0 <= nx && nx < N && 0 <= ny && ny < N ) {
						salt[j][0] = nx;
						salt[j][1] = ny;
						pond[nx][ny]++;
						if (pond[nx][ny] == 2) 
						{
							System.out.println("#" + (t+1) + " " + (j+1));
							check = 1;
							break loop;
						}
					} else {
						continue loop;
					}
				}
			}
			if (check == 0) System.out.println("#" + (t+1) + " " + 0);


			
		}
	}

}
