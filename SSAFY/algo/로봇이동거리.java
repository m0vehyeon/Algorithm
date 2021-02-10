package com.ssafy.algo;
import java.io.*;
import java.util.*;

public class 로봇이동거리 {
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	// 상,하,좌,우
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/로봇이동거리.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int count = 0;
			int N = sc.nextInt();
			char[][] arr = new char[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.next().charAt(0);
				}
			}
//			for (char[] ct : arr) System.out.println(Arrays.toString(ct));
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) { 
					// 0 : 상 1 : 하 2 : 좌  3 : 우
					if (arr[x][y] == 'A') {
						count += search(arr,x,y,3,N);
					} else if (arr[x][y] == 'B') {
						count += search(arr,x,y,3,N);
						count += search(arr,x,y,2,N);
					} else if (arr[x][y] == 'C') {
						for (int k = 0; k < 4; k++) {
							count += search(arr,x,y,k,N);
						}
					}
				}
			}
			System.out.println("#" + (t+1) + " " + count);
		}
	}
	
	public static int search(char[][] arr, int x, int y, int vec, int size) { //상하좌우 탐색 함수
		int count = 0;
		for (int p = 1; p < size; p++) {
			int nx = x + (dx[vec] * p);
			int ny = y + (dy[vec] * p);
			if (0 <= nx && nx < size && 0 <= ny && ny < size && arr[nx][ny] == 'S') {
				count++;
			}
			else break;
		}
		return count;
	}
}
