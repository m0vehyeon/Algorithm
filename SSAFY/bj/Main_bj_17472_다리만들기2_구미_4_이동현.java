package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_17472_다리만들기2_구미_4_이동현 {
	static int N, M;
	static List<int[]>[] island;
	static int[][] distance, map;
	static int[] minEdge;
	static boolean[] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		map = new int[N][M];
		island = new ArrayList[6];
		
		for (int i = 0; i < 6; i++) {
			island[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = stoi(st.nextToken());
				map[i][j] = num == 1 ? -1 : 0;
			}
		}
		
		// 섬 나누기
		int count = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == -1) {
					map[i][j] = count;
					island[count - 1].add(new int[] {i,j});
					dfs(i, j, count++);
				}
			}
		}
		distance = new int[count-1][count-1];
		// 연결 가능한 점들을 판단 후 리스트로 관리
		for (int i = 0; i < count - 1; i++) {
			for (int j = i; j < count - 1; j++) {
				isAvailable(i,j);
			}
		}
		int result = prim(count-1);
		System.out.println(result);
	}
	static int prim(int n) {
		visited = new boolean[n];
		minEdge = new int[n];
		int result = 0;
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[0] = 0;
		
		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			int minIdx = 0;
			for (int j = 0; j < n; j++) {
				if (!visited[j] && min > minEdge[j]) {
					min = minEdge[j];
					minIdx = j;
				}
			}
			visited[minIdx] = true;
			if (min == Integer.MAX_VALUE) return -1;
			result += min;
			
			for (int j = 0; j < n; j++) {
				if (!visited[j] && distance[minIdx][j]!=0 && minEdge[j] > distance[minIdx][j]) {
					minEdge[j] = distance[minIdx][j];
				}
			}
		}
		return result;
	}
	// land 끼리 이어지는 점들 중 가장가까운 거리로 distance 배열 만들기
	static void isAvailable(int first, int second) {
		if (first == second) {
			distance[first][second] = 0;
			distance[second][first] = 0;
			return;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < island[first].size(); i++) {
			for (int j = 0; j < island[second].size(); j++) {
				int val = isConnect(island[first].get(i)[0], island[first].get(i)[1], island[second].get(j)[0], island[second].get(j)[1]);
				min = Math.min(min, val);
			}
		}
		if (min == Integer.MAX_VALUE) min = 0;
		distance[first][second] = min;
		distance[second][first] = min;
	}
	static int isConnect(int x1, int y1, int x2, int y2) {
		int d = 0;
		if (x1 == x2 || y1 == y2) {
			d = getLength(x1,y1,x2,y2);
			if (d >= 2 && isAvailable(x1,y1,x2,y2,d)) {
				return d;
			}
		}
		return Integer.MAX_VALUE;
	}
	static boolean isAvailable(int x1, int y1, int x2, int y2, int len) {
		boolean flag = true;
		if (x2 == x1) {
			if (y2 > y1) {
				for (int i = 1; i <= len; i++) {
					if (map[x1][y1 + i] != 0) {
						flag = false;
						break;
					}
				}
			} else {
				for (int i = 1; i <= len; i++) {
					if (map[x1][y2 + i] != 0) {
						flag = false;
						break;
					}
				}
			}
		} else {
			if (x2 > x1) {
				for (int i = 1; i <= len; i++) {
					if (map[x1 + i][y2] != 0) {
						flag = false;
						break;
					}
				}
			} else {
				for (int i = 1; i <= len; i++) {
					if (map[x2 + i][y2] != 0) {
						flag = false;
						break;
					}
				}
			}
		}
		return flag;
	}
	// 다리의 길이구하기
	static int getLength(int x1, int y1, int x2, int y2) {
		int len = 0;
		if (x2 == x1) {
			len = Math.abs(y2-y1) - 1;
		} else {
			len = Math.abs(x2-x1) - 1;
		}
		return len;
	}
	// 섬 나누기
	static void dfs(int x, int y, int cnt) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0<= nx && nx < N && 0<= ny && ny < M && map[nx][ny] == -1) {
				island[cnt-1].add(new int[] {nx,ny});
				map[nx][ny] = cnt;
				dfs(nx,ny,cnt);
			}
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
