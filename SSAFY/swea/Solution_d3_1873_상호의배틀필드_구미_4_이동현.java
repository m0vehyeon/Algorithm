package com.ssafy.swea;

import java.io.*;
import java.util.*;

public class Solution_d3_1873_상호의배틀필드_구미_4_이동현 {
	static int[] dx = {-1,1,0,0}; //상하좌
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			char[][] map = new char[x][y];
			for (int i = 0; i < x; i++) {
				map[i] = br.readLine().toCharArray();
			}
			int n = Integer.parseInt(br.readLine());
			char[] com = new char[n];
			com = br.readLine().toCharArray();
//			System.out.println(Arrays.toString(com));
//			for (char[]c : map) System.out.println(Arrays.toString(c));
			int nx = 0;
			int ny = 0;
			for (int i = 0; i < x; i++) { // 탱크를 찾고 nx ny에 좌표 초기화
				for (int j = 0; j < y; j++) {
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						nx = i; ny =j;
						break;
					}
				}
			}
			
			for (char c : com) { // 명령어 배열을 순회하면서 명령처리
				int tx = 0;
				int ty = 0;
				switch(c) {
				case 'U':
					tx = nx + dx[0]; 
					ty = ny + dy[0];
					// 이동시킨 좌표값 
					if (0<= tx && tx < x && 0<= ty && ty < y&&map[tx][ty] == '.') { // 평지검사
						map[nx][ny] = '.'; // 평지로바꾸기
						nx = tx; ny = ty; // 앞으로 이동
					}
					map[nx][ny] = '^'; //방향바꾸기
					break;
				case 'D':
					tx = nx + dx[1];
					ty = ny + dy[1];
					if (0<= tx && tx < x && 0<= ty && ty < y&& map[tx][ty] == '.') {
						map[nx][ny] = '.';
						nx = tx; ny = ty;
					}
					map[nx][ny] = 'v';
					break;
				case 'L':
					tx = nx + dx[2];
					ty = ny + dy[2];
					if (0<= tx && tx < x && 0<= ty && ty < y&&map[tx][ty] == '.') {
						map[nx][ny] = '.';
						nx = tx; ny = ty;
					}
					map[nx][ny] = '<';
					break;
				case 'R':
					tx = nx + dx[3];
					ty = ny + dy[3];
					if (0<= tx && tx < x && 0<= ty && ty < y&&map[tx][ty] == '.') {
						map[nx][ny] = '.';
						nx = tx; ny = ty;
					}
					map[nx][ny] = '>';
					break;
				case 'S':
					if (map[nx][ny] == '^') {
						for (int z = 1; z < x; z++) { // 위로 이동하면서
							if (0 <= nx-z && nx-z < x && map[nx - z][ny] == '*') { //벽 검사
								map[nx-z][ny] = '.'; break;
							} else if (0 <= nx-z && nx-z < x && map[nx-z][ny] == '#') break; //강철벽일때 break
						}
					} else if (map[nx][ny] == 'v') {
						for (int z = 1; z < x; z++) {
							if (0 <= nx+z && nx+z < x && map[nx + z][ny] == '*') {
								map[nx+z][ny] = '.'; break;
							} else if (0 <= nx+z && nx+z < x &&map[nx+z][ny] == '#') break;
						}
					} else if (map[nx][ny] == '<') {
						for (int z = 1; z < y; z++) {
							if (0 <= ny-z && ny-z < y && map[nx][ny-z] == '*') {
								map[nx][ny-z] = '.'; break;
							} else if (0 <= ny-z && ny-z < y &&map[nx][ny-z] == '#') break;
						}
					} else if (map[nx][ny] == '>'){
						for (int z = 1; z < y; z++) {
							if (0 <= ny+z && ny+z < y && map[nx][ny+z] == '*') {
								map[nx][ny+z] = '.'; break;
							} else if (0 <= ny+z && ny+z < y &&map[nx][ny+z] == '#') break;
						}
					}
				}
			} 
			pw.print("#" + (t+1) + " ");
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					pw.print(map[i][j]);
				}
				pw.println();
			}
		}
		pw.close();
		br.close();
	}

}
