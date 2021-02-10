package com.ssafy.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_16935_배열돌리기3_구미_4_이동현 {
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		boolean check = true;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int q = 0; q < R; q++) {
			int com = Integer.parseInt(st.nextToken());
			if (com == 1) arr = changeArr1(arr.length,arr[0].length, arr);
			else if (com == 2) arr = changeArr2(arr.length,arr[0].length, arr);
			else if (com == 3) arr = changeArr3(arr.length,arr[0].length, arr);
			else if (com == 4) arr = changeArr4(arr.length,arr[0].length, arr);
			else if (com == 5) arr = changeArr5(arr.length,arr[0].length, arr);
			else if (com == 6) arr = changeArr6(arr.length,arr[0].length, arr);
			
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	static int[][] changeArr1(int N, int M, int[][] arr) {
		int[][] ret = new int[N][M];
		ret = arr;
		for (int i = 0; i < N/2;i++) {
			int[] tmp = new int[M];
			tmp = ret[i];
			ret[i] = ret[N - i - 1];
			ret[N - i - 1] = tmp;
		}
		return ret;
	}
	static int[][] changeArr2(int N, int M, int[][] arr) {
		int[][] ret = new int[N][M];
		ret = arr;
		for (int i = 0; i < M/2;i++) {
			for (int j = 0; j < N; j++) {
				int tmp = ret[j][i];
				ret[j][i] = ret[j][M - i - 1];
				ret[j][M - i - 1] = tmp;
			}
		}
		return ret;
	}
	static int[][] changeArr3(int N, int M, int[][] arr) {
		int[][] ret = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				ret[j][N - i - 1] = arr[i][j];
			}
		}
		return ret;
	}
	static int[][] changeArr4(int N, int M, int[][] arr) {
		int[][] ret = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				ret[M - j - 1][i] = arr[i][j];
			}
		}
		return ret;
	}
	static int[][] changeArr5(int N, int M, int[][] arr) {
		int[][] ret = new int[N][M];
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				ret[i][M/2 + j] = arr[i][j];
			}
		}
		for (int i = 0; i < N/2; i++) {
			for (int j = M/2; j < M; j++) {
				ret[N/2 + i][j] = arr[i][j];
			}
		}
		for (int i = N/2; i < N; i++) {
			for (int j = M/2; j <M; j++) {
				ret[i][j - M/2] = arr[i][j];
			}
		}
		for (int i = N/2; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				ret[i - N/2][j] = arr[i][j];
			}
		}
		return ret;
	}
	static int[][] changeArr6(int N, int M, int[][] arr) {
		int[][] ret = new int[N][M];
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				ret[i + N/2][j] = arr[i][j];
			}
		}
		for (int i = 0; i < N/2; i++) {
			for (int j = M/2; j < M; j++) {
				ret[i][j - M/2] = arr[i][j];
			}
		}
		for (int i = N/2; i < N; i++) {
			for (int j = M/2; j <M; j++) {
				ret[i - N/2][j] = arr[i][j];
			}
		}
		for (int i = N/2; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				ret[i][j + M/2] = arr[i][j];
			}
		}
		return ret;
	}
}

