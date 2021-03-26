package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_14502_연구소_구미_4_이동현 {
	static int N, M, bSize, max = Integer.MIN_VALUE;
	static int map[][], tmap[][];
	static int nums[];
	static List<int[]> blank;
	static List<int[]> viruses;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		map = new int[N][M];
		blank = new ArrayList<>();
		viruses = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = stoi(st.nextToken());
				if (map[i][j] == 0) blank.add(new int[] {i,j});
				else if (map[i][j] == 2) viruses.add(new int[] {i,j});
			}
		}
		bSize = blank.size();
		nums = new int[3];
		combi(0,-1);
		System.out.println(max);
	}
	static void combi(int cnt, int idx) {
		if (cnt == 3) {
			init();
			bfs();
			max = Math.max(max, safeCount());
			return;
		}
		for (int i = idx+1; i < bSize; i++) {
			nums[cnt] = i;
			combi(cnt+1,i);
		}
	}
	static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < viruses.size(); i++) q.offer(viruses.get(i));
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int tx = cur[0];
			int ty = cur[1];
			tmap[tx][ty] = 2;
			visited[tx][ty] = true;
			
			for (int i = 0; i < 4; i++) {
				int nx = tx + dx[i];
				int ny = ty + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && tmap[nx][ny] == 0) {
					
					q.offer(new int[] {nx,ny});
					
				}
			}
		}
		
	}
	static void init() {
		tmap = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmap[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < 3; i++) {
			tmap[blank.get(nums[i])[0]][blank.get(nums[i])[1]] = 1; 
		}
		
	}
	static int safeCount() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tmap[i][j] == 0) count++;
			}
		}
		return count;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
